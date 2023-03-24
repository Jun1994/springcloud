package com.atguigu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @ClassName ConsumerZkMain80
 * @Author maxingjun@xci96716.com
 * @Since 2023/3/24 17:32
 * @Description
 * @Version 1.0
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ConsumerZkMain80 {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerZkMain80.class, args);
    }

}
