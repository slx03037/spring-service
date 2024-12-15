package com.xinwen.leaf.segment;

import com.alibaba.druid.pool.DruidDataSource;
import com.xinwen.leaf.Constants;
import com.xinwen.leaf.IDGen;
import com.xinwen.leaf.common.Result;
import com.xinwen.leaf.common.ZeroIDGen;
import com.xinwen.leaf.common.prop.PropertyFactory;
import com.xinwen.leaf.exception.InitException;
import com.xinwen.leaf.segment.dao.IDAllocDao;
import com.xinwen.leaf.segment.dao.impl.IDAllocDaoImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.Properties;

/**
 * @author shenlx
 * @description 段模式获取ID
 * @date 2024/5/9 15:02
 */
@Slf4j
@Service
public class SegmentServiceImpl implements SegmentService {
    private final IDGen idGen;

    public SegmentServiceImpl() throws SQLException, InitException {
        Properties properties = PropertyFactory.getProperties();
        boolean flag = Boolean.parseBoolean(properties.getProperty(Constants.LEAF_SEGMENT_ENABLE, "true"));
        if (flag) {
            // Config dataSource
            DruidDataSource dataSource = new DruidDataSource();
            dataSource.setUrl(properties.getProperty(Constants.LEAF_JDBC_URL));
            dataSource.setUsername(properties.getProperty(Constants.LEAF_JDBC_USERNAME));
            dataSource.setPassword(properties.getProperty(Constants.LEAF_JDBC_PASSWORD));
            dataSource.init();

            // Config Dao
            IDAllocDao dao = new IDAllocDaoImpl(dataSource);

            // Config ID Gen
            idGen = new SegmentIDGenImpl();
            ((SegmentIDGenImpl) idGen).setDao(dao);
            if (idGen.init()) {
                log.info("Segment Service Init Successfully");
            } else {
                throw new InitException("Segment Service Init Fail");
            }
        } else {
            idGen = new ZeroIDGen();
            log.info("Zero ID Gen Service Init Successfully");
        }
    }

    @Override
    public Result getId(String key) {
        return idGen.get(key);
    }

    @Override
    public SegmentIDGenImpl getIdGen() {
        if (idGen instanceof SegmentIDGenImpl) {
            return (SegmentIDGenImpl) idGen;
        }
        return null;
    }

}
