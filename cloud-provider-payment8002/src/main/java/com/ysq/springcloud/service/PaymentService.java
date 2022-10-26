package com.ysq.springcloud.service;

import com.ysq.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * 功能描述
 *
 * @author 闫思晴
 * @date 2022/09/29  22:39
 */
public interface PaymentService {
    int create(Payment payment);
    //读数据
    Payment getPaymentById(@Param("id") Long id);
}
