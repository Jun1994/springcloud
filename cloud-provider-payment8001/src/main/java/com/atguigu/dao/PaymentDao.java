package com.atguigu.dao;


import com.atguigu.entity.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * @ClassName PaymentDao
 * @Author maxingjun@xci96716.com
 * @Since 2023/3/10 16:44
 * @Description
 * @Version 1.0
 */
public interface PaymentDao {

    int create(Payment payment);

    Payment selectById(@Param("id") Long id);

}
