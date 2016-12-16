package com.cs.activemq.test;

import javax.jms.Queue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
public class Producer implements CommandLineRunner {

    @Autowired
    private JmsTemplate jmsTemplate;

    @Autowired
    private Queue queue;

    @Override
    public void run(String... args) throws Exception {
        for (int i = 0; i < 100; i++) {
            send("Sample message " + (i + 1));
        }
        System.out.println("Message was sent to the Queue");
    }

    public void send(String msg) {
        this.jmsTemplate.convertAndSend(this.queue, msg);
    }
}
