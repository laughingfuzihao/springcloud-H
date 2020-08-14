package com.laughing.hystrix.service.impl;

import cn.hutool.core.util.IdUtil;
import com.laughing.hystrix.service.PaymentService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.concurrent.TimeUnit;

/**
 * @author Fu zihao
 * @version 1.0
 * @Description:
 * @date 2020/7/2 16:02
 */
@Service
public class PayMentServiceImpl implements PaymentService {
    @Override
    public String payMentOk(Integer id) {
        return "线程池" + Thread.currentThread().getName() +"id==>>" + id + "Pay ok !!";
    }

    @Override
    @HystrixCommand(fallbackMethod = "payMentBadHandler",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "3000")
    })
    public String payMentBad(Integer id)  {
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池" + Thread.currentThread().getName() +"id==>>" + id + "Pay bad !!";
    }

    public String payMentBadHandler(Integer id)  {
        return "FALLBACK--线程池" + Thread.currentThread().getName() +"id==>>" + id + "payMentBadHandler Pay bad !!";
    }



    /**
     * 服务熔断
     */
    @HystrixCommand(fallbackMethod = "payMentCircuitBreakerFallBack", commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled", value = "true"), // 开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),//请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"),//时间窗口范围
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60"),// 失败率多少跳闸
            // 10s 内，10次访问失败6次触发 跳闸 过了时间窗口 尝试恢复
    })
    public String payMentCircuitBreaker(@PathVariable("id") Integer id) {
        String serial = IdUtil.simpleUUID();
        if (id < 0) {
            throw new RuntimeException("服务异常-----------");
        }
        return "调用成功-----------serial:" + serial;
    }

    public String payMentCircuitBreakerFallBack(@PathVariable("id") Integer id) {
        return "服务异常----------payMentCircuitBreakerFallBack";

    }
}
