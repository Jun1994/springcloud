package com.atguigu.controller;

import com.atguigu.entity.Payment;
import com.atguigu.service.PaymentService;
import com.atguigu.utils.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@Slf4j
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @Resource
    private DiscoveryClient discoveryClient;

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

    @GetMapping("/discovery")
    public DiscoveryClient getDiscoveryClient() {
        List<String> services = discoveryClient.getServices();
        services.forEach((service)->{
            System.out.println(service);
        });
        List<ServiceInstance> instances = discoveryClient.getInstances("cloud-payment-service");
        instances.forEach(obj ->{
            log.info("**实例名**"+obj.getInstanceId()+"**服务名**"+obj.getServiceId()+"**主机名**"+obj.getHost()+"**端口号**"+obj.getPort()+"**uri**"
                    +obj.getUri()+"**元数据**"+obj.getMetadata()+"**方案**"+obj.getScheme());
        });


        return discoveryClient;
    }
}

