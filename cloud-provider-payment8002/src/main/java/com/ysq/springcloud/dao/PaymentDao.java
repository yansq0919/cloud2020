package com.ysq.springcloud.dao;

import com.ysq.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 功能描述
 *
 * @author 闫思晴
 * @date 2022/09/29  22:37
 */
@Mapper
public interface PaymentDao {
    int create(Payment payment);
    Payment getPaymentById(@Param("id") Long id);
}
