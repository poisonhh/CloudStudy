package com.sky.elasticsearch.entity.task;

import java.lang.reflect.Method;

/**
 * @author hhuang
 * @date 2020-08-07 12:06
 */
public class WorkTask2 extends MyDynamicTask {

    private Class clazz;
    private String methodName;

    public WorkTask2(String id) {
        super(id);
    }

    public WorkTask2(String id, Class clazz, String methodName) {
        super(id);
        this.clazz = clazz;
        this.methodName = methodName;
    }

    @Override
    public void run() {
        try {
            Class<?> targetClass = Class.forName(this.clazz.getName());
            Object obj = targetClass.newInstance();
            Method method = targetClass.getMethod(this.methodName);
            method.invoke(obj);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
