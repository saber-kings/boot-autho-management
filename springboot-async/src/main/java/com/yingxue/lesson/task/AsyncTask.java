package com.yingxue.lesson.task;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

import java.util.Random;
import java.util.concurrent.Future;

/**
 * @Auther:Saber污妖王
 * @Date:2020/3/22
 * @Description:com.yingxue.lesson.task
 * @version:1.0
 */
@Component
public class AsyncTask {
    public static Random random = new Random();

    @Async("myTaskExecutor")
    public Future<String> doTaskOne() throws Exception {
        System.out.println("开始任务一");
        long startTime = System.currentTimeMillis();
        Thread.sleep(random.nextInt(10000));
        long endTime = System.currentTimeMillis();
        System.out.println("完成任务一消耗的时间：" + (endTime - startTime) + "毫秒");
        return new AsyncResult<>("任务一完成");
    }

    @Async("myTaskExecutor")
    public Future<String> doTaskTwo() throws Exception {
        System.out.println("开始任务二");
        long startTime = System.currentTimeMillis();
        Thread.sleep(random.nextInt(10000));
        long endTime = System.currentTimeMillis();
        System.out.println("完成任务二消耗的时间：" + (endTime - startTime) + "毫秒");
        return new AsyncResult<>("任务二完成");
    }

    @Async("myTaskExecutor")
    public Future<String> doTaskThree() throws Exception {
        System.out.println("开始任务三");
        long startTime = System.currentTimeMillis();
        Thread.sleep(random.nextInt(10000));
        long endTime = System.currentTimeMillis();
        System.out.println("完成任务三消耗的时间：" + (endTime - startTime) + "毫秒");
        return new AsyncResult<>("任务三完成");
    }
}
