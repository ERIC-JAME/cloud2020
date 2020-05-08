package com.atguigu.springcloud.myhandler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.atguigu.springcloud.entities.CommonResult;

/**
 * @author: zhanxg
 * @create: 2020/5/7 10:50
 */
public class CustomerBlockHandler {

    public static CommonResult handlerException1(BlockException exception){

        return new CommonResult(4444,"按客户自定义，global handlerException---1");
    }

    public static CommonResult handlerException2(BlockException exception){

        return new CommonResult(4444,"按客户自定义，global handlerException---2");
    }
}
