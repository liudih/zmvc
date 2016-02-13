package com.learn.service.test;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

public class MessageSenderTest {

    private ApplicationContext context = null;

    @Before
    public void setUp() throws Exception {
        context = new ClassPathXmlApplicationContext("spring-mybatis.xml");
    }

    @Test
    public void should_send_a_amq_message() throws Exception {
        MessageSender messageSender = (MessageSender) context.getBean("messageSender");
        messageSender.sendMessage("Hello, I am amq sender");
    }
}