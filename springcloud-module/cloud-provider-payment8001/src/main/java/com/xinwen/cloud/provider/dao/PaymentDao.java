package com.xinwen.cloud.provider.dao;

import com.xinwen.cloud.commons.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author shenlx
 * @description
 * @date 2025/2/20 13:58
 */
@Mapper
public interface PaymentDao {
     int create(Payment payment);

     Payment getPaymentById(@Param("id") Long id);
}
