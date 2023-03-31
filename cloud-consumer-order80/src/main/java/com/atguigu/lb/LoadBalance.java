package com.atguigu.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * @ClassName LoadBalance
 * @Author maxingjun@xci96716.com
 * @Since 2023/3/30 17:54
 * @Description
 * @Version 1.0
 */
public interface LoadBalance {
    ServiceInstance instances(List<ServiceInstance> serviceInstances);
}
