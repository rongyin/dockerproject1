package com.example.demo;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.jms.TextMessage;

@Component
public class QueueConsumer {

    @JmsListener(destination = "${myqueue}")
    public void recieve(TextMessage textMessage) throws Exception{
        System.out.println("***consumed:"+textMessage.getText());
    }
}
