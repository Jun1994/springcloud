package com.atguigu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;

/**
 * @ClassName PaymentHystrixMain8001
 * @Author maxingjun@xci96716.com
 * @Since 2023/3/31 17:04
 * @Description
 * @Version 1.0
 */
@SpringBootApplication
@EnableCircuitBreaker
public class PaymentHystrixMain8001 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentHystrixMain8001.class, args);
    }
}
