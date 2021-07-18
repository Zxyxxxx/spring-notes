package com.example.demo.service;


import org.springframework.stereotype.Service;

import javax.jms.Destination;

/**
 * 消息生产
 */
public interface ProductService {

    /**
     * 指定消息队列，消息
     */
    public void sendMessage(Destination destination, final String message);


    /**
     * 使用默认消息队列，发送消息
     */
    public void sengMessage(final String message);


    public void publish(String msg);


}
