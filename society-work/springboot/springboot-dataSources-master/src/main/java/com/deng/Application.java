package com.deng;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.net.UnknownHostException;

@SpringBootApplication
@EnableAutoConfiguration
public class Application {

    public static void main(String[] args) throws UnknownHostException {
       SpringApplication.run(Application.class, args);
    }
}
