package com.sky.springcloud.alibaba.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author hhuang
 * @date 2020-07-20 17:27
 */
@Configuration
@MapperScan({"com.sky.springcloud.alibaba.dao"})
public class MyBatisConfig {
}
