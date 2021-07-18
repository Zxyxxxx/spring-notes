package com.example.demo.task;


import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * 定时业务
 */
@Component
public class Stask {



//    @Scheduled(fixedRate = 2000)//每隔两秒执行一次
//    @Scheduled(cron = "*/2 * * * * *")
    public void testTask(){
        System.out.println("当前时间："+new Date());
    }



}
