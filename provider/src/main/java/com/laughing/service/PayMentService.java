package com.laughing.service;

import com.laughing.common.entity.PayMent;

/**
 * @author Fu zihao
 * @version 1.0
 * @Description:
 * @date 20202020/7/1 11:19
 */
public interface PayMentService {

    public int insert(PayMent payMent);

    public PayMent selectById(int id);
}
