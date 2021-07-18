package com.example.demo.task;


import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/**
 * 异步任务
 */
@Component
@Async//标记异步任务
public class TaskAsync {


    public void task1() throws InterruptedException {
        long start = System.currentTimeMillis();
        Thread.sleep(1000L);
        long end = System.currentTimeMillis();
        System.out.println("task1执行时间："+(end-start));
    }


    public void task2() throws InterruptedException {
        long start = System.currentTimeMillis();
        Thread.sleep(2000L);
        long end = System.currentTimeMillis();
        System.out.println("task2执行时间："+(end-start));
    }

    public void task3() throws InterruptedException {
        long start = System.currentTimeMillis();
        Thread.sleep(3000L);
        long end = System.currentTimeMillis();
        System.out.println("task3执行时间："+(end-start));
    }


    //不执行异步，需要拿到结果后继续进行，判断task.isDone()为true
    public Future<String> task4() throws InterruptedException {
        long start = System.currentTimeMillis();
        Thread.sleep(3000L);
        long end = System.currentTimeMillis();
        System.out.println("task4执行时间："+(end-start));
        return new AsyncResult<>("任务4");
    }





}
