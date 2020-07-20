package com.sky.springcloud.alibaba.service;

/**
 * @author hhuang
 * @date 2020-07-20 17:41
 */
public interface StorageService {

    /**
     * 扣减库存
     */
    void decrease(Long productId, Integer count);
}
