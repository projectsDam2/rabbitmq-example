package org.iesfm.rabbitmqexample;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableRabbit
public class EmailListenerMain {
    public static void main(String[] args) {
        SpringApplication.run(EmailListenerMain.class, args);
    }
}
