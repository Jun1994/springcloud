package com.atguigu.service;


import com.atguigu.dao.PaymentDao;
import com.atguigu.entity.Payment;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @ClassName PaymentService
 * @Author maxingjun@xci96716.com
 * @Since 2023/3/10 16:55
 * @Description
 * @Version 1.0
 */
@Service
public class PaymentService {

    @Resource
    private PaymentDao paymentDao;

    public int create(Payment payment){
        return paymentDao.create(payment);
    };

    public Payment selectById(Long id){
        return paymentDao.selectById(id);
    };

}
