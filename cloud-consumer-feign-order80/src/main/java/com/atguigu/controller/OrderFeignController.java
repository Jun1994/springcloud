package com.atguigu.controller;

import com.atguigu.entity.Payment;
import com.atguigu.service.PaymentFeignService;
import com.atguigu.utils.CommonResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @ClassName OrderFeignController
 * @Author maxingjun@xci96716.com
 * @Since 2023/3/31 14:59
 * @Description
 * @Version 1.0
 */
@RestController
@RequestMapping("consumer")
public class OrderFeignController {

    @Resource
    private PaymentFeignService paymentFeignService;

    @GetMapping("/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id){
        return paymentFeignService.getPaymentId(id);
    }

    @GetMapping("/payment/feign/timeout")
    public String paymentFeignTimeout(){
        return paymentFeignService.paymentFeignTimeout();
    }
}
