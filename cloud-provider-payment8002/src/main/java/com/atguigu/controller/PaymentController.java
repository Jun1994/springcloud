package com.atguigu.controller;

import com.atguigu.entity.Payment;
import com.atguigu.service.PaymentService;
import com.atguigu.utils.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

@RestController
@Slf4j
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/selectById/{id}")
    public CommonResult<Payment> selectById(@PathVariable Long id){
        CommonResult<Payment> commonResult = null;
        Payment payment = paymentService.selectById(id);
        if (payment != null) {
            commonResult = new CommonResult<>(200,"查询成功,serverPort: "+ serverPort,payment);
            log.info("*****查询结果："+payment);
        }else if(payment == null){
            commonResult = new CommonResult<>(200,"查询成功",null);
        }else{
            commonResult = new CommonResult<>(404,"查询失败");
        }
        return commonResult;
    }

    @PostMapping("/create")
    public CommonResult<Integer> create(@RequestBody Payment payment){
        CommonResult<Integer> commonResult = null;
        int num = paymentService.create(payment);
        if (num > 0) {
            commonResult = new CommonResult<>(200,"添加成功",num);
            log.info("*****插入结果："+num);
        }else{
            commonResult = new CommonResult<>(404,"添加失败");
        }
        return commonResult;
    }

    @GetMapping(value = "/payment/lb")
    public String getPayment(){
        return serverPort;
    }

    @GetMapping("feign/timeout")
    public String getFeignTimeOut() {
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return serverPort;
    }
}

