package com.cs.activemq.test;

import java.io.Serializable;
import java.util.Date;

public class MyMessage implements Serializable {

    private static final long serialVersionUID = 785241137840682101L;

    private String message;
    private Date date = new Date();

    public MyMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return date + " - " + message;
    }
}
