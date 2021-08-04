package com.example.demo.jms;


import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 * 监听消息队列
 */
@Component
public class OrderConsumer {


    /**
     * 实时监听对应的队列
     *
     * @param text
     */
    @JmsListener(destination = "order.queue")
    public void receiveQueue(String text) {
        System.out.println("OrderConsumer收到的消息：" + text);
    }


    /**
     * 发布订阅消费，支持高并发下多项目访问
     * containerFactory = "jmsListenerContainerFactory" 使用启动类中自定义方法，加上这个才能同时支持点对点和发布订阅模型
     *
     * @param text
     */
    @JmsListener(destination = "video.topic", containerFactory = "jmsListenerContainerFactory")
    public void receiveQueue1(String text) {
        System.out.println("video.topic 消费者 receiveQueue1：" + text);
    }


    @JmsListener(destination = "video.topic", containerFactory = "jmsListenerContainerFactory")
    public void receiveQueue2(String text) {
        System.out.println("video.topic 消费者 receiveQueue2：" + text);
    }


    @JmsListener(destination = "video.topic")
    public void receiveQueue3(String text) {
        System.out.println("video.topic 消费者 receiveQueue3：" + text);
    }


}
