package com.cs.activemq.test;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class ObjectConsumer {

    @JmsListener(destination = "sample.objectQueue")
    public void receiveQueue(MyMessage message) {
        System.out.println(getClass().getSimpleName() + ": " + message);
        try {
            Thread.sleep((int)(Math.random() * 50));
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
