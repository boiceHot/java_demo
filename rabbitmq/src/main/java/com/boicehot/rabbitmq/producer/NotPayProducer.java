package com.boicehot.rabbitmq.producer;

import com.boicehot.rabbitmq.config.MqConstants;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class NotPayProducer {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public String pushMsg(String msg){
        String id = UUID.randomUUID().toString().replaceAll("-", "");
        CorrelationData correlationData = new CorrelationData(id);
        rabbitTemplate.convertAndSend(MqConstants.EXCHANGE_NOT_PAY, MqConstants.KEY_DL_NOT_PAY, msg, message -> {
            MessageProperties messageProperties = message.getMessageProperties();
            messageProperties.setContentEncoding("UTF-8");
            messageProperties.setExpiration("5000");
            return message;
        }, correlationData);
        return id;
    }
}