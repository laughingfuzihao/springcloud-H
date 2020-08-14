package com.laughing.consumer.service;

import com.laughing.common.entity.PayMent;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.concurrent.TimeUnit;

/**
 * @author Fu zihao
 * @version 1.0
 * @Description:
 * @date 20202020/7/2 13:50
 */
@Component
@FeignClient(value = "HYSTRIX-PAYMENT" ,fallback = PayMentServiceImpl.class)
public interface PayMentService {
    /**
     * provider控制层提供的方法
     */

    @GetMapping("/getokport/{id}")
    public String getPort(@PathVariable("id") int id);

    @GetMapping("/getbadport/{id}")
    public String getBadPort(@PathVariable("id") int id);
}
