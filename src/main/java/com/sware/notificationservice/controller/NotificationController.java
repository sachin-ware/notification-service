package com.sware.notificationservice.controller;


import com.sware.notificationservice.producer.RabbitMQProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/notification")
public class NotificationController {
    @Autowired
    private RabbitMQProducer rabbitMQProducer;


    //http://localhost:8080/nitification/publish?message=hello
    @GetMapping("/publist")
    public String sendMessage(String message){
        rabbitMQProducer.sendMessageToQueue(message);
        return "Message sent to RabbitMQ . . . !";
    }

}
