package com.learn.service.test;

import javax.annotation.Resource;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Service;

@Service
public class MessageSender {

    @Resource(name="amqpTemplate")
    AmqpTemplate amqpTemplate;

    public void sendMessage(Object message){
    	System.out.println("amqpTemplate==="+amqpTemplate);
        amqpTemplate.convertAndSend("test_queue_key",message);
    }
}
