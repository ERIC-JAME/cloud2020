package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.domain.CommonResult;
import com.atguigu.springcloud.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: zhanxg
 * @create: 2020/5/8 9:44
 */
@RestController
public class StorageController {

    @Autowired
    private StorageService storageService;

    @RequestMapping("/storage/decrease")
    public CommonResult decrease(@RequestParam("productId") Long productId,@RequestParam("count") Integer count){

        storageService.decrease(productId,count);

        return new CommonResult(200,"扣减成功");
    }
}
