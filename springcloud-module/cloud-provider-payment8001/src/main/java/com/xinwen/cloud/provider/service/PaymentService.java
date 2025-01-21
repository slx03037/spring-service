package com.xinwen.cloud.provider.service;

import com.xinwen.cloud.commons.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * @author shenlx
 * @description
 * @date 2025/2/20 13:58
 */
public interface PaymentService {
    int create(Payment payment);

    Payment getPaymentById(@Param("id") Long id);
}
