package com.laughing.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author Fu zihao
 * @version 1.0
 * @Description:
 * @date 20202020/7/1 12:44
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ConsumerZookeeperApplication {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerZookeeperApplication.class, args);
    }
}
