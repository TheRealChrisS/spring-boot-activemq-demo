package com.cs.activemq.test;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class Consumer2 {

    @JmsListener(destination = "sample.queue")
    public void receiveQueue(String text) {
        System.out.println(getClass().getSimpleName() + ": " + text);
        try {
            Thread.sleep((int)(Math.random() * 50));
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
