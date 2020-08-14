package com.laughing.rule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Fu zihao
 * @version 1.0
 * @Description:
 * @date 20202020/7/2 13:15
 */
@Configuration
public class RibbonRule {
    @Bean
    public IRule Rule() {
        /**
         * 定义策略为随机。
         */
        return new RandomRule();
    }
}
