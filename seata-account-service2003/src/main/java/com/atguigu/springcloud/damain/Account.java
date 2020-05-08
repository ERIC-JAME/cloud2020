package com.atguigu.springcloud.damain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author: zhanxg
 * @create: 2020/5/8 9:58
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Account implements Serializable {
    private static final long serialVersionUID = 7809657011108300597L;

    //id
    private Long id;

    //用户id
    private Long userId;

    //总额度
    private BigDecimal total;

    //已用额度
    private BigDecimal used;

    //剩余额度
    private BigDecimal residue;

}
