package com.sky.springcloud.alibaba.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author hhuang
 * @date 2020-05-26 15:45
 */
@RestController
@Slf4j
public class FlowLimitController {

    @GetMapping("/testA")
    public String test() {
        return "-------->testA";
    }

    @GetMapping("/testB")
    public String testB() {
        log.info(Thread.currentThread().getName() + "\t" + "...testB");
        return "-------->testB";
    }
}
