package com.sky.springcloud.alibaba.controller;

import com.sky.springcloud.alibaba.domain.CommonResult;
import com.sky.springcloud.alibaba.domain.Order;
import com.sky.springcloud.alibaba.service.OrderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author hhuang
 * @date 2020-07-20 17:28
 */
@RestController
public class OrderController {

    @Resource
    private OrderService orderService;

    @GetMapping("/order/create")
    public CommonResult create(Order order) {
        orderService.create(order);
        return new CommonResult(200,"订单创建成功");
    }
}
