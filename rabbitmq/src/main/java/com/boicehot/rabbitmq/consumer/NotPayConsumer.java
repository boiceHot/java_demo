package com.boicehot.rabbitmq.consumer;

import com.rabbitmq.client.Channel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@RabbitListener(queues = "Q-NOT-PAY")
public class NotPayConsumer {
    private static Logger logger = LoggerFactory.getLogger(NotPayConsumer.class);

    @RabbitHandler
    public void task(String str, Message message, Channel channel) throws IOException {
        long id = message.getMessageProperties().getDeliveryTag();
        logger.info("[Q-NOT-PAY consumer] {}-{}", id, str);
        channel.basicAck(message.getMessageProperties().getDeliveryTag(), true);
    }
}