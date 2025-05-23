package com.xinwen.webflux.websocket.utils;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.config.ConnectionConfig;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.config.SocketConfig;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.LayeredConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLContexts;
import org.apache.http.conn.ssl.TrustStrategy;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import javax.net.ssl.SSLContext;
import java.io.IOException;
import java.nio.charset.Charset;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author shenlx
 * @description
 * @date 2025/3/2 0:20
 */
@Slf4j
public class HttpUtils {

    public static String defaultEncoding = "utf-8";

    /**
     * 发送http post请求，并返回响应实体
     *
     * @param url 请求地址
     * @return url响应实体
     */
    public static String postRequest(String url) {
        return postRequest(url, null, null);
    }

    /**
     * <p>方法名: postRequest</p>
     * <p>描述: 发送httpPost请求</p>
     *
     * @param url
     * @param params
     * @return
     */
    public static String postRequest(String url, Map<String, Object> params) {
        return postRequest(url, null, params);
    }

    /**
     * 发送http post请求，并返回响应实体
     *
     * @param url     访问的url
     * @param headers 请求需要添加的请求头
     * @param params  请求参数
     * @return
     */
    public static String postRequest(String url, Map<String, String> headers,
                                     Map<String, Object> params) {
        String result = null;
        CloseableHttpClient httpClient = buildHttpClient();
        HttpPost httpPost = new HttpPost(url);
        if (null != headers && headers.size() > 0) {
            for (Map.Entry<String, String> entry : headers.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();
                httpPost.addHeader(new BasicHeader(key, value));
            }
        }

        if(isJSON(params.toString())){
            /**
             * json格式
             */
            StringEntity requestEntity = new StringEntity(params.toString(), "utf-8");
            requestEntity.setContentEncoding("UTF-8");
            httpPost.setHeader("Content-type", "application/json");
            httpPost.setEntity(requestEntity);
        }else{
            /**
             * 名称值对节点类型
             */
            if (null != params && params.size() > 0) {
                List<NameValuePair> pairList = new ArrayList<NameValuePair>(params.size());
                for (Map.Entry<String, Object> entry : params.entrySet()) {
                    NameValuePair pair = new BasicNameValuePair(entry.getKey(), entry.getValue().toString());
                    pairList.add(pair);
                }
                httpPost.setEntity(new UrlEncodedFormEntity(pairList, Charset.forName(defaultEncoding)));
            }
        }


        try {
            CloseableHttpResponse response = httpClient.execute(httpPost);
            try {
                HttpEntity entity = response.getEntity();
                if (entity != null) {
                    log.info("【POST请求信息】,请求地址:{},请求参数:{}", url, params);
                    result = EntityUtils.toString(entity, Charset.forName(defaultEncoding));
                    log.info("【POST请求信息】,请求地址:{},请求参数:{},返回结果:{}", url, params,result);
                }
            } finally {
                response.close();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                httpClient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return result;
    }

    /**
     * 发送http get请求
     *
     * @param url 请求url
     * @return url返回内容
     */
    public static String getRequest(String url) {
        return getRequest(url, null);
    }


    /**
     * 发送http get请求
     *
     * @param url    请求的url
     * @param params 请求的参数
     * @return
     */
    public static String getRequest(String url, Map<String, Object> params) {
        return getRequest(url, null, params);
    }

    /**
     * 发送http get请求
     *
     * @param url        请求的url
     * @param headersMap 请求头
     * @param params     请求的参数
     * @return
     */
    public static String getRequest(String url, Map<String, String> headersMap, Map<String, Object> params) {
        String result = null;
        CloseableHttpClient httpClient = buildHttpClient();
        try {
            String apiUrl = url;
            if (null != params && params.size() > 0) {
                StringBuffer param = new StringBuffer();
                int i = 0;
                for (String key : params.keySet()) {
                    if (i == 0) {
                        param.append("?");
                    } else {
                        param.append("&");
                    }
                    param.append(key).append("=").append(params.get(key));
                    i++;
                }
                apiUrl += param;
            }

            HttpGet httpGet = new HttpGet(apiUrl);
            if (null != headersMap && headersMap.size() > 0) {
                for (Map.Entry<String, String> entry : headersMap.entrySet()) {
                    String key = entry.getKey();
                    String value = entry.getValue();
                    httpGet.addHeader(new BasicHeader(key, value));
                }
            }
            CloseableHttpResponse response = httpClient.execute(httpGet);
            try {
                HttpEntity entity = response.getEntity();
                if (null != entity) {
                    log.info("【GET请求信息】,请求地址:{},请求参数:{}", url, params);
                    result = EntityUtils.toString(entity, defaultEncoding);
                    log.info("【GET请求信息】,请求地址:{},请求参数:{},返回结果:{}", url, params,result);
                }
            } finally {
                response.close();
            }
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                httpClient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    /**
     * 创建httpclient,支持http、https
     *
     * @return
     */
    public static CloseableHttpClient buildHttpClient() {
        try {
            RegistryBuilder<ConnectionSocketFactory> builder = RegistryBuilder
                    .create();
            ConnectionSocketFactory factory = new PlainConnectionSocketFactory();
            builder.register("http", factory);
            KeyStore trustStore = KeyStore.getInstance(KeyStore.getDefaultType());
            SSLContext context = SSLContexts.custom().useTLS()
                    .loadTrustMaterial(trustStore, new TrustStrategy() {
                        @Override
                        public boolean isTrusted(X509Certificate[] chain,
                                                 String authType) throws CertificateException {
                            return true;
                        }
                    }).build();
            LayeredConnectionSocketFactory sslFactory = new SSLConnectionSocketFactory(
                    context,
                    SSLConnectionSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);
            builder.register("https", sslFactory);
            Registry<ConnectionSocketFactory> registry = builder.build();
            PoolingHttpClientConnectionManager manager = new PoolingHttpClientConnectionManager(registry);
            ConnectionConfig connConfig = ConnectionConfig.custom()
                    .setCharset(Charset.forName(defaultEncoding)).build();
            SocketConfig socketConfig = SocketConfig.custom()
                    .setSoTimeout(100000).build();
            manager.setDefaultConnectionConfig(connConfig);
            manager.setDefaultSocketConfig(socketConfig);
            return HttpClientBuilder.create().setConnectionManager(manager)
                    .build();
        } catch (KeyStoreException e) {
            e.printStackTrace();
        } catch (KeyManagementException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }


    public static boolean isJSON(String str) {
        boolean result = false;
        try {
            Object obj= JSON.parse(str);
            result = true;
        } catch (Exception e) {
            result=false;
        }
        return result;
    }

    public static void main(String[] args) {
        String url1 = "http://192.168.56.101:8196/test/get1";
        String result = HttpUtils.getRequest(url1);
        System.out.println(result);

        String url2 = "http://192.168.56.101:8196/test/get2";
        Map<String, Object> params = new HashMap<>();
        params.put("name", "一安未来1");
        params.put("addr", "北京1");
        String result2 = HttpUtils.postRequest(url2, null,params);
        System.out.println(result2);

        String url3 = "http://192.168.56.101:8196/test/get3";
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", "一安未来2");
        jsonObject.put("addr", "北京2");
        String result3 = HttpUtils.postRequest(url3, null,jsonObject);
        System.out.println(result3);
    }
}
