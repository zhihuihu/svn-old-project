package com.hxkj.activemq.cons.activemq;

import javax.jms.Queue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@EnableScheduling
public class Producer {

	@Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;
   
    @Autowired
    private Queue queue;
   
    /*@Scheduled(fixedDelay=3000)//æ¯?3sæ‰§è¡Œ1æ¬?
    public void send() {
       this.jmsMessagingTemplate.convertAndSend(this.queue, "hi,activeMQ");
    }*/
}
