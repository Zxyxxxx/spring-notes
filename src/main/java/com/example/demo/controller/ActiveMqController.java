package com.example.demo.controller;


import com.example.demo.domain.JsonData;
import com.example.demo.service.ProductService;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.jms.Destination;

@RestController
@RequestMapping("/api/v1/order")
public class ActiveMqController {


    @Autowired
    private ProductService productService;


    /**
     * 点对点消费
     * 模拟支付回调，回调信息放入队列进行
     */
    @GetMapping("/order")
    public Object order(String msg) {
        //生成消息队列
        Destination destination = new ActiveMQQueue("order.queue");
        productService.sendMessage(destination, msg);
        return JsonData.buildSuccess();
    }


    @GetMapping("/common")
    public Object common(String msg) {
        productService.sengMessage(msg);
        return JsonData.buildSuccess();
    }


    @GetMapping("/topic")
    public Object topic(String msg) {
        productService.publish(msg);
        return JsonData.buildSuccess();
    }


}
