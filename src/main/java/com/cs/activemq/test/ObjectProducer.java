package com.cs.activemq.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import javax.jms.Queue;

@Component
public class ObjectProducer implements CommandLineRunner {

    @Autowired
    private JmsTemplate jmsTemplate;

    @Autowired
    private Queue objectQueue;

    @Override
    public void run(String... args) throws Exception {
        for (int i = 0; i < 100; i++) {
            send(new MyMessage("Sample message " + (i + 1)));
        }
        System.out.println("Message was sent to the Queue");
    }

    public void send(MyMessage msg) {
        this.jmsTemplate.convertAndSend(this.objectQueue, msg);
    }
}
