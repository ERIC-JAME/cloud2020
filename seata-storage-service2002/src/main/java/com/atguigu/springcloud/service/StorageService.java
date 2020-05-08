package com.atguigu.springcloud.service;

/**
 * @author: zhanxg
 * @create: 2020/5/8 9:22
 */
public interface StorageService {
    /**
     * 减库存
     * @param productId 产品的id
     * @param count 减的数量
     */
    void decrease(Long productId,Integer count);
}
