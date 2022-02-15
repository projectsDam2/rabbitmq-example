package org.iesfm.rabbitmqexample.api.controllers;

import org.iesfm.rabbitmqexample.pojo.User;
import org.iesfm.rabbitmqexample.repository.UserRepository;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class RegisterController {

    private UserRepository userRepository;

    private AmqpTemplate amqpTemplate;

    public RegisterController(UserRepository userRepository, AmqpTemplate amqpTemplate) {
        this.userRepository = userRepository;
        this.amqpTemplate = amqpTemplate;
    }

    @RequestMapping(method = RequestMethod.POST, path = "/users")
    public void register(@RequestBody User user){
        if (userRepository.existsById(user.getUsername())){
            throw new ResponseStatusException(HttpStatus.CONFLICT, "ya existe ese usuario");
        } else {
            userRepository.insert(user);
            amqpTemplate.convertAndSend(
                    "register.exchange",
                    "",
                    user);
        }
    }
}
