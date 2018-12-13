package com.hwua.amqp;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableRabbit
public class SpringBoot06AmqpApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBoot06AmqpApplication.class, args);
    }

}

