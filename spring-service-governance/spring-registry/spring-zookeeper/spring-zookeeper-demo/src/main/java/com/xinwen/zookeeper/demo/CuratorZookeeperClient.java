package com.xinwen.zookeeper.demo;

import com.xinwen.zookeeper.demo.interfaces.ZkStateListener;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.api.CuratorWatcher;
import org.apache.curator.framework.state.ConnectionState;
import org.apache.curator.framework.state.ConnectionStateListener;
import org.apache.curator.retry.RetryNTimes;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher.Event;

import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.logging.Logger;

/**
 * @author shenlx
 * @description
 * @date 2025/1/14 11:00
 */
@Slf4j
public class CuratorZookeeperClient {
    private final int CONNECT_TIMEOUT = 15000;
    private final int RETRY_TIME = Integer.MAX_VALUE;
    private final int RETRY_INTERVAL = 1000;
    private CuratorFramework curator;

    private volatile static CuratorZookeeperClient instance;


    /**
     * key:父路径，如/jobcenter/client/goodscenter
     * value：Map-->key:子路径，如/jobcenter/client/goodscenter/goodscenter00000001
     * value:路径中的值
     */

    private static final ConcurrentHashMap<String, Map<String, String>> zkCacheMap = new ConcurrentHashMap<String, Map<String, String>>();

    public static Map<String, Map<String, String>> getZkCacheMap() {
        return zkCacheMap;
    }
    private final Set<ZkStateListener> stateListeners = new CopyOnWriteArraySet<ZkStateListener>();

    public void addStateListener(ZkStateListener listener) {
        stateListeners.add(listener);
    }

    private CuratorFramework newCurator(String zkServers) {
        return CuratorFrameworkFactory.builder().connectString(zkServers)
                .retryPolicy(new RetryNTimes(RETRY_TIME, RETRY_INTERVAL))
                .connectionTimeoutMs(CONNECT_TIMEOUT).build();
    }

    private CuratorZookeeperClient(String zkServers) {
        if(curator == null) {
            curator = newCurator(zkServers);
            curator.getConnectionStateListenable().addListener(new ConnectionStateListener() {
                @Override
                public void stateChanged(CuratorFramework client, ConnectionState state) {
                    if (state == ConnectionState.LOST) {
                        //连接丢失
                        log.info("lost session with zookeeper");
                    } else if (state == ConnectionState.CONNECTED) {
                        //连接新建
                        log.info("connected with zookeeper");
                    } else if (state == ConnectionState.RECONNECTED) {
                        log.info("reconnected with zookeeper");
                        //连接重连
                        for(ZkStateListener s:stateListeners){
                            s.reconnected();
                        }
                    }
                }
            });
            curator.start();
        }
    }

    public static CuratorZookeeperClient getInstance(String zkServers) {
        if(instance == null) {
            synchronized(CuratorZookeeperClient.class) {
                if(instance == null) {
                    log.info("initial CuratorZookeeperClient instance");
                    instance = new CuratorZookeeperClient(zkServers);
                }
            }
        }
        return instance;
    }


    /**
     * 写数据：/docker/jobcenter/client/app/app0..../app1...../app2
     * @param path
     * @param content
     * @return
     * @throws Exception
     */
    public String write(String path,String content) throws Exception {
        String writePath = curator.create().creatingParentsIfNeeded()
                .withMode(CreateMode.EPHEMERAL_SEQUENTIAL)
                .forPath(path, content.getBytes(StandardCharsets.UTF_8));
        return writePath;
    }


    /**
     * 随机读取一个path子路径
     * @param path
     * @return
     * @throws Exception
     */
    public String readRandom(String path) throws Exception {
        String parentPath = path;
        Map<String,String> cacheMap = zkCacheMap.get(path);
        if(cacheMap != null && cacheMap.size() > 0) {
            log.debug("get random value from cache,path="+path);
            return getRandomValue4Map(cacheMap);
        }
        if(curator.checkExists().forPath(path) == null) {
            log.debug("path [{}] is not exists,return null",path);
            return null;
        } else {
            log.debug("read random from zookeeper,path="+path);
            cacheMap = new HashMap<String,String>();
            List<String> list = curator.getChildren().usingWatcher(new ZKWatcher(parentPath,path)).forPath(path);
            if(list == null || list.size() == 0) {
                log.debug("path [{}] has no children return null",path);
                return null;
            }
            Random rand = new Random();
            String child = list.get(rand.nextInt(list.size()));
            path = path + "/" + child;
            byte[] b = curator.getData().usingWatcher(new ZKWatcher(parentPath,path))
                    .forPath(path);
            String value = new String(b, StandardCharsets.UTF_8);
            if(StringUtils.isNotBlank(value)) {
                cacheMap.put(path, value);
                zkCacheMap.put(parentPath, cacheMap);
            }
            return value;
        }
    }

    /**
     * 读取path下所有子路径下的内容
     * 先从map中读取，如果不存在，再从zookeeper中查询
     * @param path
     * @return
     * @throws Exception
     */

    public List<String> readAll(String path) throws Exception {
        String parentPath = path;
        Map<String,String> cacheMap = zkCacheMap.get(path);
        List<String> list = new ArrayList<String>();
        if(cacheMap != null) {
            log.debug("read all from cache,path="+path);
            list.addAll(cacheMap.values());
            return list;
        }
        if(curator.checkExists().forPath(path) == null) {
            log.debug("path [{}] is not exists,return null",path);
            return null;
        } else {
            cacheMap = new HashMap<String,String>();
            List<String> children = curator.getChildren().usingWatcher(new ZKWatcher(parentPath,path)).forPath(path);
            if(children == null || children.size() == 0) {
                log.debug("path [{}] has no children,return null",path);
                return null;
            } else {
                log.debug("read all from zookeeper,path="+path);
                String basePath = path;
                for(String child : children) {
                    path = basePath + "/" + child;
                    byte[] b = curator.getData().usingWatcher(new ZKWatcher(parentPath,path))
                            .forPath(path);
                    String value = new String(b, StandardCharsets.UTF_8);
                    if(StringUtils.isNotBlank(value)) {
                        list.add(value);
                        cacheMap.put(path, value);
                    }
                }
            }
            zkCacheMap.put(parentPath, cacheMap);
            return list;
        }
    }


    /**
     * 随机获取Map中的一个值
     * @param map
     * @return
     */
    private String getRandomValue4Map(Map<String,String> map) {
        Object[] values = map.values().toArray();
        Random rand = new Random();
        return values[rand.nextInt(values.length)].toString();
    }

    public void delete(String path) throws Exception {
        if(curator.checkExists().forPath(path) != null) {
            curator.delete().inBackground().forPath(path);
            zkCacheMap.remove(path);
        }
    }

    /**
     * 获取路径下的所有子路径
     * @param path
     * @return
     * @throws Exception
     */
    public List<String> getChildren(String path) throws Exception {
        if(curator.checkExists().forPath(path) == null) {
            log.debug("path [{}] is not exists,return null",path);
            return null;
        } else {
            List<String> children = curator.getChildren().forPath(path);
            return children;
        }
    }

    public void close() {
        if(curator != null) {
            curator.close();
            curator = null;
        }
        zkCacheMap.clear();
    }


    private class ZKWatcher implements CuratorWatcher {
        private final String parentPath;
        private final String path;
        public ZKWatcher(String parentPath,String path) {
            this.parentPath = parentPath;
            this.path = path;
        }

        @Override
        public void process(WatchedEvent event) throws Exception {
            Map<String,String> cacheMap = zkCacheMap.get(parentPath);
            if(cacheMap == null) {
                cacheMap = new HashMap<String,String>();
            }
            if(event.getType() == Event.EventType.NodeDataChanged
                    || event.getType() == Event.EventType.NodeCreated){
                byte[] data = curator.getData().
                        usingWatcher(this).forPath(path);
                cacheMap.put(path, new String(data, StandardCharsets.UTF_8));
                log.info("add cache={}",new String(data, StandardCharsets.UTF_8));
            } else if(event.getType() == Event.EventType.NodeDeleted) {
                cacheMap.remove(path);
                log.info("remove cache path={}",path);
            } else if(event.getType() == Event.EventType.NodeChildrenChanged) {
                //子节点发生变化，重新进行缓存
                cacheMap.clear();
                List<String> children = curator.getChildren().usingWatcher(new ZKWatcher(parentPath,path)).forPath(path);
                if(children != null && children.size() > 0) {
                    for(String child : children) {
                        String childPath = parentPath + "/" + child;
                        byte[] b = curator.getData().usingWatcher(new ZKWatcher(parentPath,childPath))
                                .forPath(childPath);
                        String value = new String(b, StandardCharsets.UTF_8);
                        if(StringUtils.isNotBlank(value)) {
                            cacheMap.put(childPath, value);
                        }
                    }
                }
                log.info("node children changed,recaching path={}",path);
            }
            zkCacheMap.put(parentPath, cacheMap);
        }
    }



}
