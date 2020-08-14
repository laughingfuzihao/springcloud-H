package com.laughing.hystrix.service;

/**
 * @author Fu zihao
 * @version 1.0
 * @Description:
 * @date 20202020/7/2 16:02
 */
public interface PaymentService {
    public String payMentOk(Integer id);
    public String payMentBad(Integer id) ;
    public String payMentCircuitBreaker(Integer id) ;
    public String payMentCircuitBreakerFallBack(Integer id) ;
}
