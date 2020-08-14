package com.laughing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author Fu zihao
 * @version 1.0
 * @Description:
 * @date 20202020/7/1 10:49
 */

@SpringBootApplication
@EnableEurekaClient
public class PayApplication2 {
    public static void main(String[] args) {
        SpringApplication.run(PayApplication2.class, args);
    }

}
