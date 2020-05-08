package com.atguigu.springcloud.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author: zhanxg
 * @create: 2020/5/8 8:58
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Storage implements Serializable {

    private static final long serialVersionUID = -3605117589695858851L;

    //产品id
    private Long id;

    //总库存
    private Integer total;

    //已用库存
    private Integer userd;

    //剩余库存
    private Integer residue;
}
