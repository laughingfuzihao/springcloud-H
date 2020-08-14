package com.laughing.consumer.service;

import org.springframework.stereotype.Component;

/**
 * @author Fu zihao
 * @version 1.0
 * @Description:
 * @date 20202020/7/3 10:52
 */
@Component
public class PayMentServiceImpl implements PayMentService{
    @Override
    public String getPort(int id) {
        return "PayMentService -----getPort---fallback";
    }

    @Override
    public String getBadPort(int id) {
        return "PayMentService -----getBadPort---fallback";
    }
}
