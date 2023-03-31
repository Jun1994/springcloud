package com.atguigu.service;

import org.springframework.stereotype.Component;

/**
 * @ClassName PaymentFallbackService
 * @Author maxingjun@xci96716.com
 * @Since 2023/4/1 0:01
 * @Description
 * @Version 1.0
 */
@Component
public class PaymentFallbackService implements PaymentHystrixService {
    @Override
    public String paymentInfo_OK(Integer id) {
        return "-----------PaymentFallbackService fall back ---paymentInfo_OK ,/(ㄒoㄒ)/~~";
    }

    @Override
    public String paymentInfo_TimeOut(Integer id) {
        return "-----------PaymentFallbackService fall back ---paymentInfo_TimeOut ,/(ㄒoㄒ)/~~";
    }
}
