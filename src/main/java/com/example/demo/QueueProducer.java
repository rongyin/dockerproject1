package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.jms.Queue;
import java.util.UUID;

@Component
public class QueueProducer {
    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;

    @Autowired
    private Queue queue;

    public void produceMsg(){
        jmsMessagingTemplate.convertAndSend(queue,"****: "+ UUID.randomUUID().toString().substring(0,6));
    }

    @Scheduled(fixedDelay = 3000l)
    public void produceMsgScheduled(){
        jmsMessagingTemplate.convertAndSend(queue,"****Scheduled: "+ UUID.randomUUID().toString().substring(0,6));
        System.out.println("produceMsgScheduled send");
    }
}
