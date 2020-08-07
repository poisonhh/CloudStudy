package com.sky.elasticsearch.controller;

import com.sky.elasticsearch.entity.task.WorkTask;
import com.sky.elasticsearch.entity.task.WorkTask2;
import com.sky.elasticsearch.service.DynamicTaskService;
import com.sky.elasticsearch.util.ScheduleUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @author hhuang
 * @date 2020-08-07 11:49
 */
@RequestMapping(value = "/task")
@RestController
public class DynamicTaskController {

    @Autowired
    private DynamicTaskService dynamicTaskService;

    @GetMapping(value = "/startTask")
    public int startTask() throws Exception {
        WorkTask task1 = new WorkTask("task1");
//        ScheduleUtil.start(task1, new Date(System.currentTimeMillis() + 5000));
        ScheduleUtil.start(task1, 2000);
        Thread.sleep(10000);
        ScheduleUtil.cancel(task1);
        System.out.println("==========end===========");
        return 1;
    }

    @GetMapping(value = "/startTask2")
    public int startTask2() {
        WorkTask2 workTask2 = new WorkTask2("task2", DynamicTaskService.class, "startTask2");
        ScheduleUtil.start(workTask2, 2000);
        System.out.println("===============end============");
        return 1;
    }
}
