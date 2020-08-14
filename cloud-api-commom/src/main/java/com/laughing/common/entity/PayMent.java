package com.laughing.common.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Fu zihao
 * @version 1.0
 * @Description:
 * @date 20202020/7/1 11:03
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PayMent {

    private int id;
    /**
     * 交易流水号
     */
    private String serial;
}
