package com.atguigu.springcloud.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author: zhanxg
 * @create: 2020/5/8 9:01
 */
@Mapper
public interface StorageDao {

    /**
     * 减库存
     * @param productId
     * @param count
     */
    void decrease(@Param("productId") Long productId, @Param("count") Integer count);
}
