package org.iesfm.rabbitmqexample.listener;

import org.iesfm.rabbitmqexample.pojo.User;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class EmailListener {

    @RabbitListener(queues = "register.email.queue")
    public void onMessage(User user){
        System.out.println(user.toString());
    }
}
