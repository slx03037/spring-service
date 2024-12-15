package com.xinwen.schedule.mapper.local;


import com.xinwen.schedule.entity.Additional;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author shenlx
 * @description
 * @date 2024/5/8 22:39
 */
public interface AdditionalMapper {
    List<Additional> selectByPrimaryKey(@Param("offset")Integer offset, @Param("pageSize")Integer pageSize);
}
