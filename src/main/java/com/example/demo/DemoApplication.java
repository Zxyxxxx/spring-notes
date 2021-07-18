package com.example.demo;

import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

import javax.jms.ConnectionFactory;
import javax.jms.Queue;
import javax.jms.Topic;

@SpringBootApplication
@EnableJms//开启jms消息队列
@EnableScheduling//开启定时任务
@EnableAsync//开启异步任务
@MapperScan("com.example.demo.mapper")//开启扫描mapper
public class DemoApplication {


    //交给spring管理的队列，方便后续注入
    @Bean
    public Queue queue(){
        return new ActiveMQQueue("common.queue");
    }


    /**
     * 主题队列交给spring管理
     * @return
     */
    @Bean
    public Topic topic(){
        return new ActiveMQTopic("video.topic");
    }


    /**
     * 给topic定义独立的JmsListenerContainerFactory
     * 定义此方法就可以去掉spring.jms.pub-sub-domain=true配置
     * @param
     */
    @Bean
    public JmsListenerContainerFactory<?> jmsListenerContainerFactory(ConnectionFactory activeMQConnectionFactory){
        DefaultJmsListenerContainerFactory bean = new DefaultJmsListenerContainerFactory();
        bean.setPubSubDomain(true);
        bean.setConnectionFactory(activeMQConnectionFactory);
        return bean;
    }







    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

}
