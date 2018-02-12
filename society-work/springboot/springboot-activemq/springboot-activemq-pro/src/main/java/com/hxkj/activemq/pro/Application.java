package com.hxkj.activemq.pro;

import javax.jms.Queue;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

	@Bean
    public Queue queue() {
       return new ActiveMQQueue("sample.queue");
    }
   
    public static void main(String[] args) {
       SpringApplication.run(Application.class, args);
    }
}
