package com.sky.elasticsearch.entity.task;

/**
 * @author hhuang
 * @date 2020-08-07 11:08
 */
public abstract class MyDynamicTask implements Runnable {

    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public MyDynamicTask(String id) {
        this.id = id;
    }

    @Override
    public void run() {

    }
}
