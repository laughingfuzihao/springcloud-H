package com.laughing.controller;


import com.laughing.common.entity.CommonResult;
import com.laughing.common.entity.PayMent;
import com.laughing.service.PayMentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.TimeUnit;

/**
 * @author Fu zihao
 * @version 1.0
 * @Description:
 * @date 20202020/7/1 11:06
 */
@RestController
@Slf4j
@RequestMapping("/payment")
public class PayController {
    @Autowired
    private PayMentService payMentService;
    @Value("${server.port}")
    private String port;

    @GetMapping("/get/{id}")
    public PayMent getPay(@PathVariable("id") int id) {
        return payMentService.selectById(id);
    }

    @PostMapping("/insert")
    public CommonResult insert(@RequestBody PayMent payMent) {
        int result = payMentService.insert(payMent);
        log.info("insert" + result);
        if (result > 0) {
            return new CommonResult(200, "insert 成功");
        } else {
            return new CommonResult(500, "insert 失败");
        }
    }

    @GetMapping("/getport")
    public String getPort(){
        return port;

    }
    @GetMapping("/gettimeout")
    public String paymentTimeOut() throws InterruptedException {
        TimeUnit.SECONDS.sleep(3);
        return port;
    }
}
