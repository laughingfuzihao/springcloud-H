package com.laughing.consumer;

import com.laughing.rule.RibbonRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * @author Fu zihao
 * @version 1.0
 * @Description:
 * @date 20202020/7/1 12:44
 */
@RibbonClient(name = "CLOUD-PAY-PROVIDER",configuration = RibbonRule.class)
@SpringBootApplication
@EnableEurekaClient
public class ConsumerApplication {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerApplication.class, args);
    }
}
