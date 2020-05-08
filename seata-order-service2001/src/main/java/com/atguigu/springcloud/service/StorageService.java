package com.atguigu.springcloud.service;

import com.atguigu.springcloud.domain.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author: zhanxg
 * @create: 2020/5/7 20:51
 */
@FeignClient(value = "seata-storage-service")
public interface StorageService {

    /**
     * 减库存
     * @param id
     * @param count
     * @return
     */
    @RequestMapping(value = "/storage/decrease",method = RequestMethod.POST)
    CommonResult decrease(@RequestParam("productId") Long id,@RequestParam("count") Integer count);
}
