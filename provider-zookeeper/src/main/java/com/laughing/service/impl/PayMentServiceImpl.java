package com.laughing.service.impl;

import com.laughing.common.entity.PayMent;
import com.laughing.dao.PayMentDao;
import com.laughing.service.PayMentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Fu zihao
 * @version 1.0
 * @Description:
 * @date 20202020/7/1 11:21
 */
@Service
public class PayMentServiceImpl implements PayMentService {
    @Autowired
    private PayMentDao payMentDao;

    @Override
    public int insert(PayMent payMent) {
        return payMentDao.insert(payMent);
    }

    @Override
    public PayMent selectById(int id) {
        return payMentDao.selectById(id);
    }
}
