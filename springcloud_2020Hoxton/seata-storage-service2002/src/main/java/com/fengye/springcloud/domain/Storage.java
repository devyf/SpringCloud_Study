package com.fengye.springcloud.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @Description:
 * @Author: huang
 * @Date: 2021/4/20 19:19
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Storage {
    private Long id;  //库存id
    private Long productId;  //产品id
    private Integer total;  //总库存
    private Integer used;  //已用库存
    private Integer residue;  //剩余库存
}
