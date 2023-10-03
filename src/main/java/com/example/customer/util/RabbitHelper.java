package com.example.customer.util;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitHelper {

    @Value("${queue.name.email}")
    private String emailQueue;

    @Autowired
    private RabbitTemplate rabbitTemplate;
    @Bean
    public Queue emailQueue() {
        return new Queue(emailQueue, true);
    }
    public void sendEmailNotification(String customerDetails) {
        rabbitTemplate.convertAndSend(emailQueue().getName(), customerDetails);
    }

}