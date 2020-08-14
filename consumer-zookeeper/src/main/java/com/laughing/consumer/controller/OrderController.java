package com.laughing.consumer.controller;


import com.laughing.common.entity.CommonResult;
import com.laughing.common.entity.PayMent;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("/consumer")
public class OrderController {
    public static final String URL = "http://cloud-pay-provider";
    @Autowired
    private RestTemplate restTemplate;

    /**
     * http://localhost:8002/consumer/insert?serial=3
     *
     * @param payMent
     * @return
     */
    @GetMapping("/insert")
    public CommonResult<PayMent> insert(PayMent payMent) {
        return restTemplate.postForObject(URL + "/payment/insert", payMent, CommonResult.class);
    }

    /**
     * http://localhost:8002/consumer/get/2
     *
     * @param id
     * @return
     */
    @GetMapping("/get/{id}")
    public PayMent getPay(@PathVariable("id") int id) {
        return restTemplate.getForObject(URL + "/payment/get/" + id, PayMent.class);
    }

    @GetMapping("/getid")
    public String getPort() {
        return restTemplate.getForObject(URL + "/payment/getport", String.class);
    }
}
