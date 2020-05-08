package com.atguigu.springcloud.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


/**
 * @author: zhanxg
 * @create: 2020/5/8 8:45
 */
@AllArgsConstructor
@Data
@NoArgsConstructor
public class CommonResult<T> implements Serializable{

    private static final long serialVersionUID = 7581964627659675911L;

    private Integer code;

    private String message;

    private T data;

    public CommonResult(Integer code,String message){
        this(code,message,null);
    }
}
