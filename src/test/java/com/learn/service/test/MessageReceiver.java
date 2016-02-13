package com.learn.service.test;

import java.io.UnsupportedEncodingException;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MessageReceiver implements MessageListener {

    public void onMessage(Message message) {
    	System.out.println("接受到消息~~~~~");
    	try {
			System.out.println("m=="+new String(message.getBody(),"UTF-8"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
        System.out.println(message);
        System.out.println("接受到消息完毕~~~~~");
    }

    public static void main(String[]args){
    	//spring-mybatis.xml
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("application-mq.xml");
    }
}
