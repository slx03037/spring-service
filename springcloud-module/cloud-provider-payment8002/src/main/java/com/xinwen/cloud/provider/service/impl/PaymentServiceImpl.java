package com.xinwen.cloud.provider.service.impl;

import com.xinwen.cloud.commons.Payment;
import com.xinwen.cloud.provider.dao.PaymentDao;
import com.xinwen.cloud.provider.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author shenlx
 * @description
 * @date 2025/2/20 14:59
 */
@Service
public class PaymentServiceImpl implements PaymentService {
    @Resource
    private PaymentDao paymentDao;

    @Override
    public int create(Payment payment)
    {
        return paymentDao.create(payment);
    }

    @Override
    public Payment getPaymentById(Long id)
    {
        return paymentDao.getPaymentById(id);
    }
}
