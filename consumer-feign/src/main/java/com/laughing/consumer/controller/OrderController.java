package com.laughing.consumer.controller;


import cn.hutool.core.util.IdUtil;
import com.laughing.common.entity.CommonResult;
import com.laughing.common.entity.PayMent;
import com.laughing.consumer.service.PayMentService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author Fu zihao
 * @version 1.0
 * @Description: 消费者调用服务
 * @date 20202020/7/1 12:45
 */
@RestController
/*@DefaultProperties(defaultFallback = "fallBack")*/
/**
 * @DefaultProperties: 1、不用每个方法都配置一个fallbackMethod
 *                     2、统一处理
 */
@RequestMapping("/consumer")
public class OrderController {
    @Autowired
    private PayMentService payMentService;

    @GetMapping("/getok/{id}")
    public String getok(@PathVariable("id") int id) {
        return payMentService.getPort(id);
    }

    @GetMapping("/getbad/{id}")
/*    @HystrixCommand(fallbackMethod = "payMentBadHandlerConsumer", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "2000")
    })*/

    public String getbad(@PathVariable("id") int id) {
        return payMentService.getBadPort(id);
    }

    public String payMentBadHandlerConsumer(@PathVariable("id") int id) {

        return "消费者FALLBACK--线程池" + Thread.currentThread().getName() + "id==>>" + id + "payMentBadHandler Pay bad !!";
    }

    // 全局fallback

    public String fallBack() {
        return "全局fallback";
    }



}
