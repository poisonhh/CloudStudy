package com.sky.springcloud.alibaba.domain;

import lombok.Data;

/**
 * @author hhuang
 * @date 2020-07-20 17:40
 */
@Data
public class Storage {

    private Long id;

    /**
     * 产品id
     */
    private Long productId;

    /**
     * 总库存
     */
    private Integer total;

    /**
     * 已用库存
     */
    private Integer used;

    /**
     * 剩余库存
     */
    private Integer residue;
}
