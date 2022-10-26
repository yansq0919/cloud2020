package com.ysq.springcloud.service;

import com.ysq.springcloud.dao.PaymentDao;
import com.ysq.springcloud.entities.Payment;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 功能描述
 *
 * @author 闫思晴
 * @date 2022/09/29  22:40
 */
@Service
public class PaymentServiceImpl implements PaymentService{
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
