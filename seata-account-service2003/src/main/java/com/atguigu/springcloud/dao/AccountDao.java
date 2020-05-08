package com.atguigu.springcloud.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;

/**
 * @author: zhanxg
 * @create: 2020/5/8 10:08
 */
@Mapper
public interface AccountDao {

    /**
     * 减账户金额
     * @param useId 用户id
     * @param money 使用的金额
     */
    void decrease(@Param("useId") Long useId,@Param("money") BigDecimal money);
}
