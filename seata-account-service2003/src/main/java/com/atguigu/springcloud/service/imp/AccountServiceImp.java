package com.atguigu.springcloud.service.imp;

import com.atguigu.springcloud.dao.AccountDao;
import com.atguigu.springcloud.service.AccountService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.concurrent.TimeUnit;

/**
 * @author: zhanxg
 * @create: 2020/5/8 10:37
 */

/**
 * 账户业务实现类
 */
@Service
public class AccountServiceImp implements AccountService {

    private static final Logger LOGGER = LoggerFactory.getLogger(AccountServiceImp.class);
    @Resource
    private AccountDao accountDao;


    /**
     * 扣减账户余额
     * @param userid 用户的id
     * @param money 金额
     */
    @Override
    public void decrease(Long userid, BigDecimal money) {
        LOGGER.info("account-service 中扣减账户余额开始");
        //模拟超时异常，全局事务回滚
        //暂停几秒钟线程
        try {
            TimeUnit.SECONDS.sleep(20);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        accountDao.decrease(userid,money);
        LOGGER.info("account-service 中扣减账户余额结束");
    }
}
