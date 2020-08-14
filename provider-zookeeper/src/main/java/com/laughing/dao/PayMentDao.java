package com.laughing.dao;


import com.laughing.common.entity.PayMent;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @author Fu zihao
 * @version 1.0
 * @Description:
 * @date 20202020/7/1 11:09
 */
@Mapper
@Repository
public interface PayMentDao {

    public int insert(PayMent payMent);

    public PayMent selectById(@Param("id")int id);
}
