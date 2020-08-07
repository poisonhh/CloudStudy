package com.sky.elasticsearch.entity.task;

import java.util.Date;

/**
 * @author hhuang
 * @date 2020-08-07 11:44
 */
public class WorkTask extends MyDynamicTask {

    public WorkTask(String id) {
        super(id);
    }

    @Override
    public void run() {
        System.out.println(new Date() + "任务" + this.getId() + "开始执行...hello world!");
    }
}
