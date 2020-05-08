package com.atguigu.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author: zhanxg
 * @create: 2020/4/29 16:33
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Payment implements Serializable {

    private long id;
    private String serial;
}
