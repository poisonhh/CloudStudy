package com.sky.springcloud.service;

import com.sky.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * @author hhuang
 * @date 2020-05-09 11:41
 */
public interface PaymentService {

    public int create(Payment payment);

    public Payment getPaymentById(@Param("id") Long id);
}
