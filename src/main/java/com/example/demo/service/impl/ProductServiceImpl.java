package com.example.demo.service.impl;

import com.example.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.jms.Destination;
import javax.jms.Queue;
import javax.jms.Topic;

@Service
public class ProductServiceImpl implements ProductService {


    //注入消息队列模板
    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;

    //点对点消息队列
    @Autowired
    private Queue queue;

    //发布订阅
    @Autowired
    private Topic topic;

    //发送消息，destination是发送到的队列，message是待发送消息
    @Override
    public void sendMessage(Destination destination, final String message) {
        jmsMessagingTemplate.convertAndSend(destination,message);
    }


    //发送消息，默认队列
    @Override
    public void sengMessage(final String message) {
        jmsMessagingTemplate.convertAndSend(this.queue,message);
    }


    //发布订阅
    @Override
    public void publish(String msg) {
        this.jmsMessagingTemplate.convertAndSend(this.topic,msg);
    }
}
