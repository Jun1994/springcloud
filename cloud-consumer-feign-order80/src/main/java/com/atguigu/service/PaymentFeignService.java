package com.atguigu.service;

import com.atguigu.entity.Payment;
import com.atguigu.utils.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @ClassName PaymentFeignService
 * @Author maxingjun@xci96716.com
 * @Since 2023/3/31 14:50
 * @Description
 * @Version 1.0
 */
@Component
@FeignClient("CLOUD-PAYMENT-SERVICE")
public interface PaymentFeignService {

    @GetMapping("/selectById/{id}")
    CommonResult<Payment> getPaymentId(@PathVariable("id") Long id);

    @GetMapping("/feign/timeout")
    String paymentFeignTimeout();

}
