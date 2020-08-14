package com.laughing.hystrix.controller;

import cn.hutool.core.util.IdUtil;
import com.laughing.hystrix.service.PaymentService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Fu zihao
 * @version 1.0
 * @Description:
 * @date 20202020/7/2 16:08
 */
@RestController
@Slf4j
public class PayMentController {
    @Autowired
    private PaymentService paymentService;
    @Value("${server.port}")
    private String port;

    @GetMapping("/getokport/{id}")
    public String getPort(@PathVariable("id") int id){
        String result = paymentService.payMentOk(id);
        return result;
    }

    @GetMapping("/getbadport/{id}")
    public String getBadPort(@PathVariable("id") int id){
        String result = paymentService.payMentBad(id);
        return result;
    }

    /**
     * 服务熔断控制层调用
     */
    @GetMapping("/circuitbreaker/{id}")
    public String getBreaker(@PathVariable("id") Integer id){
        return paymentService.payMentCircuitBreaker(id);
    }


}
