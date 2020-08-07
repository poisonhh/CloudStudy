package com.sky.elasticsearch.util;

import cn.hutool.core.util.StrUtil;
import cn.hutool.cron.CronUtil;
import com.sky.elasticsearch.entity.task.MyDynamicTask;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.support.CronTrigger;

import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ScheduledFuture;

/**
 * @author hhuang
 * @date 2020-08-07 10:09
 */
public class ScheduleUtil {

    private static final Log logger = LogFactory.getLog(ScheduleUtil.class);

    private static ThreadPoolTaskScheduler threadPoolTaskScheduler = new ThreadPoolTaskScheduler();
    private static Map<String, ScheduledFuture<?>> scheduledFutureMap = new ConcurrentHashMap<>();

    static {
        threadPoolTaskScheduler.initialize();
    }

    /**
     * 启动某定时任务，到时间点就运行一次
     * @param myDynamicTask
     * @param startTime
     */
    public static void start(MyDynamicTask myDynamicTask, Date startTime) {
        if (isExists(myDynamicTask.getId())) {
            logger.info("启动定时任务" + myDynamicTask.getId() + "失败，任务已存在");
            return;
        }
        ScheduledFuture<?> scheduledFuture = threadPoolTaskScheduler.schedule(myDynamicTask, startTime);
        scheduledFutureMap.put(myDynamicTask.getId(), scheduledFuture);
        logger.info("启动定时任务" + myDynamicTask.getId() + "，执行时间为" + startTime);
    }

    /**
     * 启动某定时任务，以固定周期运行
     * @param myDynamicTask
     * @param period
     */
    public static void start(MyDynamicTask myDynamicTask, long period) {
        if (isExists(myDynamicTask.getId())) {
            logger.info("启动定时任务" + myDynamicTask.getId() + "失败，任务已存在");
            return;
        }
        ScheduledFuture<?> scheduledFuture = threadPoolTaskScheduler.scheduleAtFixedRate(myDynamicTask, period);
        scheduledFutureMap.put(myDynamicTask.getId(), scheduledFuture);
        logger.info("启动定时任务" + myDynamicTask.getId() + "，执行周期为" + period + "毫秒");
    }

    public static void startWithCorn() {
        CronTrigger cronTrigger = new CronTrigger("");
//        CronUtil
    }

    /**
     * 取消某定时任务
     * @param myDynamicTask
     */
    public static void cancel(MyDynamicTask myDynamicTask) {
        ScheduledFuture<?> scheduledFuture = scheduledFutureMap.get(myDynamicTask.getId());
        if (scheduledFuture != null && !scheduledFuture.isCancelled()) {
            scheduledFuture.cancel(false);
        }
        scheduledFutureMap.remove(myDynamicTask.getId());
        logger.info("取消定时任务" + myDynamicTask.getId());
    }

    /**
     * 修改定时任务执行时间
     * @param myDynamicTask
     * @param startTime
     */
    public static void reset(MyDynamicTask myDynamicTask, Date startTime) {
        String id = myDynamicTask.getId();
        ScheduledFuture<?> scheduledFuture = scheduledFutureMap.get(id);
        if (scheduledFuture != null && !scheduledFuture.isCancelled()) {
            scheduledFuture.cancel(false);
        }
        scheduledFutureMap.remove(id);
        scheduledFuture = threadPoolTaskScheduler.schedule(myDynamicTask, startTime);
        scheduledFutureMap.put(id, scheduledFuture);
        logger.info("重置定时任务" + id + "，执行时间为" + startTime);
    }

    public static boolean isExists(String taskId) {
        if (StrUtil.isNotBlank(taskId)) {
            ScheduledFuture<?> scheduledFuture = scheduledFutureMap.get(taskId);
            if (scheduledFuture != null && !scheduledFuture.isCancelled()) {
                return true;
            }
        }
        return false;
    }

}
