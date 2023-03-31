package com.atguigu.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
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

    @HystrixCommand(fallbackMethod = "payment_TimeOutHandler", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000")
    })
    public String paymentInfo_TimeOut(Integer id) {
        int timeNumber = 6;
        try {
            int i = 10/0;
            TimeUnit.SECONDS.sleep(timeNumber);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return "线程池" + Thread.currentThread().getName() + "paymentInfo_TimeOut,id:" + id + "\t" + "/(ㄒoㄒ)/~~";
    }

    public String payment_TimeOutHandler(Integer id){
        return "/(ㄒoㄒ)/~~调用支付接口超时或异常：\t 当前线程池名字" + Thread.currentThread().getName();
    }


}
