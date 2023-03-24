package com.atguigu.controller;

import cn.hutool.core.lang.UUID;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName PaymentController
 * @Author maxingjun@xci96716.com
 * @Since 2023/3/24 11:47
 * @Description
 * @Version 1.0
 */
@RestController
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;

    @RequestMapping(value = "payment/zk")
    public String paymentZk(){
        return "SpringCloud with Zookeeper:"+serverPort +"\t"+ UUID.randomUUID().toString();
    }
}
