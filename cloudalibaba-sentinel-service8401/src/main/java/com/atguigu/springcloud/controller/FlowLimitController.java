package com.atguigu.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: zhanxg
 * @create: 2020/5/6 20:07
 */
@RestController
public class FlowLimitController {

    @RequestMapping(value = "/testA",method = RequestMethod.GET)
    public String testA(){
        return "------A";
    }

    @RequestMapping(value = "/testB",method = RequestMethod.GET)
    public String testB(){
        return "------B";
    }

    /**
     * @SentinelResource(value = "testHotKey",blockHandler = "deal_testHotKey")
     * blockHandler = "deal_testHotKey" 热点限流错误回掉方法相当于hystrixCommoned
     * 不然限流错误即报error page 页面
     * @param p1
     * @param p2
     * @return
     */
    @RequestMapping(value = "/testHotKey",method = RequestMethod.GET)
    @SentinelResource(value = "testHotKey",blockHandler = "deal_testHotKey") //名字可随便定义，保证唯一即可
    public String testHotKey(@RequestParam(value = "p1",required = false) String p1,
                             @RequestParam(value = "p1",required = false) String p2){
        return "------testHotKey";
    }
    public String deal_testHotKey(String p1 , String p2, BlockException exception){

        return "------testHotKey";//sentinel默认的提示：Blocked by Sentinel(flow limiting)
    }
}
