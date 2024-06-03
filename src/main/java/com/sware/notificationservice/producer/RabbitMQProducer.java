package com.sware.notificationservice.producer;

import com.netflix.discovery.converters.Auto;
import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQProducer {

    private static final Logger LOGGER= LoggerFactory.getLogger(RabbitMQProducer.class);
    @Value("${rabbitmq.queue.name}")
    private String queueName;

    @Value("${rabbitmq.exchange.name}")
    private String exchangeName;

    @Value("${rabbitmq.exchange.routingkey}")
    private String routingKey;

    private RabbitTemplate rabbitTemplate;

    @Autowired
    public RabbitMQProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendMessageToQueue(String message){
        LOGGER.info("Message writting to queue:", message);
        //writting
        rabbitTemplate.convertAndSend(exchangeName,routingKey,message);
    }
}
