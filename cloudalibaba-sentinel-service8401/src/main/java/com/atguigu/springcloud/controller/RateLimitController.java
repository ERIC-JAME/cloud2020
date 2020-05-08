package com.atguigu.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.myhandler.CustomerBlockHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: zhanxg
 * @create: 2020/5/7 10:31
 */
@RestController
public class RateLimitController {

    @RequestMapping(value = "/byResource",method = RequestMethod.GET)
    @SentinelResource(value = "byResource",blockHandler = "handleException")
    public CommonResult byResource(){

        return new CommonResult(200,"按资源名测试ok",new Payment(2020L,"serial001"));
    }
    public CommonResult handleException(BlockException exception){

        return new CommonResult(444,exception.getClass().getCanonicalName()+"\t"+"服务不可用");
    }

    @RequestMapping(value = "/rateLimit/customerBlockHandler",method = RequestMethod.GET)
    @SentinelResource(value = "customerBlockHandler",
            //定义处理的类
            blockHandlerClass = CustomerBlockHandler.class,
            //定义指定的方法处理
            blockHandler = "handlerException2")
    public CommonResult customerBlockHandler(){

        return new CommonResult(200,"按客户自定义",new Payment(2020L,"serial003"));
    }
}
