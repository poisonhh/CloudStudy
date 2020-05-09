package com.sky.springcloud.service.impl;

import com.sky.springcloud.dao.PaymentDao;
import com.sky.springcloud.entities.Payment;
import com.sky.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author hhuang
 * @date 2020-05-09 11:42
 */
@Service
public class PaymentServiceImpl implements PaymentService {

    @Resource
    private PaymentDao paymentDao;

    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }
}
