package com.xinwen.schedule.mapper.bellon;


import com.xinwen.schedule.entity.RegistryDO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author shenlx
 * @description
 * @date 2024/5/8 22:48
 */
public interface RegistryMapper {
    int insert(@Param("list") List<RegistryDO> record);

    int insertSelective(RegistryDO record);
}
