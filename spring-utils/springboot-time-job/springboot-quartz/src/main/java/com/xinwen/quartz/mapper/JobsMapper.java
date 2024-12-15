package com.xinwen.quartz.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * @author shenlx
 * @description
 * @date 2024/9/20 17:16
 */
@Mapper
public interface JobsMapper {
    Map get(Long id);

    List<Map> list();

    int save(Map job);

    int update(Map task);

    int remove(Long id);

    int removeBatch(Long[] ids);
}
