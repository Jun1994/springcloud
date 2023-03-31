package com.atguigu.service;

import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @ClassName PaymentService
 * @Author maxingjun@xci96716.com
 * @Since 2023/3/31 17:06
 * @Description
 * @Version 1.0
 */
@Service
public class PaymentService {

    public String paymentInfo_OK(Integer id) {
        return "线程池" + Thread.currentThread().getName() + "paymentInfo_OK,id:" + id + "\t" + "(*^_^*)";
    }

    public String paymentInfo_TimeOut(Integer id) {
        int timeNumber = 3;
        try {
            TimeUnit.SECONDS.sleep(timeNumber);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return "线程池" + Thread.currentThread().getName() + "paymentInfo_TimeOut,id:" + id + "\t" + "/(ㄒoㄒ)/~~";
    }


}
