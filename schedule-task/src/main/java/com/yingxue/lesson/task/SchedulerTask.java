package com.yingxue.lesson.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Auther:Saber污妖王
 * @Date:2020/3/22
 * @Description:com.yingxue.lesson.task
 * @version:1.0
 */
@Component
public class SchedulerTask {
    private static final SimpleDateFormat f = new SimpleDateFormat("HH:mm:ss");

//    @Scheduled(fixedRate = 5000)
//    public void processFixedRate() {
//        System.out.println("processFixedRate方式：开始定时任务，现在时间是：" + f.format(new Date()));
//    }

    @Scheduled(cron = "*/5 * * * * ?")
    public void processCron(){
        System.out.println("processCron：开始定时任务，现在时间是：" + f.format(new Date()));
    }
}
