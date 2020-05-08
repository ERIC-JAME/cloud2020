package com.atguigu.springcloud.damain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author: zhanxg
 * @create: 2020/5/8 9:57
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult<T> implements Serializable {

    private static final long serialVersionUID = 1641323394715440118L;

    private Integer code;

    private String message;

    private T data;

    public CommonResult(Integer code,String message){
        this(code,message,null);
    }
}
