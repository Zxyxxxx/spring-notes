package com.example.demo.controller;

import com.example.demo.domain.JsonData;
import com.example.demo.task.TaskAsync;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 异步任务
 */
@RestController
@RequestMapping("/api/v1")
public class TaskAsyncController {


    @Autowired
    private TaskAsync taskAsync;


    @RequestMapping("/task1")
    public Object task1() throws InterruptedException {
        long start = System.currentTimeMillis();
        taskAsync.task1();
        taskAsync.task2();
        taskAsync.task3();
        long end = System.currentTimeMillis();

        System.out.println("执行总耗时：" + (end - start));
        return JsonData.buildSuccess("OK");
    }


}
