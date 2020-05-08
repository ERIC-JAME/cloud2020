package com.atguigu.springcloud.service.imp;

import com.atguigu.springcloud.dao.StorageDao;
import com.atguigu.springcloud.service.StorageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author: zhanxg
 * @create: 2020/5/8 9:24
 */
@Service
public class StorageServiceImp implements StorageService {

    private static final Logger LOGGER = LoggerFactory.getLogger(StorageServiceImp.class);

    @Resource
    private StorageDao storageDao;

    @Override
    public void decrease(Long productId, Integer count) {
        LOGGER.info("--------->storage-service中扣减库存开始");
        storageDao.decrease(productId,count);
        LOGGER.info("--------->storage-service中扣减库存结束");
    }
}
