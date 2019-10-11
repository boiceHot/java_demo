package com.boicehot.rabbitmq.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * @Desc: mq config
 * @Author: boiceHot
 * @Date: 2019-10-11
 */
@Configuration
public class MqConfig {
    private static final String DL_EXCHANGE = "x-dead-letter-exchange"; // 死信Exchange
    private static final String DL_ROUTING_KEY = "x-dead-letter-routing-key"; // 死信路由key

    @Bean
    public Queue dlNotPayQueue(){
        // 订单超时未支付死信队列
        Map<String, Object> arg = new HashMap<String, Object>();
        arg.put(DL_EXCHANGE, MqConstants.EXCHANGE_NOT_PAY); // 绑定死信交换机
        arg.put(DL_ROUTING_KEY, MqConstants.KEY_NOT_PAY); // 绑定死信路由key
        return QueueBuilder.durable(MqConstants.QUEUE_DL_NOT_PAY).withArguments(arg).build();
    }

    @Bean
    public Queue notPayQueue(){
        // 订单超时未支付队列
        return QueueBuilder.durable(MqConstants.QUEUE_NOT_PAY).build();
    }

    @Bean
    public Exchange notPayExchange(){
        // 订单超时未支付Exchange
        return ExchangeBuilder.directExchange(MqConstants.EXCHANGE_NOT_PAY).durable(true).build();
    }

    @Bean
    public Binding dlNotPayBinding(){
        // 绑定订单超时未支付死信队列和订单超时未支付Exchange
        return BindingBuilder.bind(dlNotPayQueue()).to(notPayExchange()).with(MqConstants.KEY_DL_NOT_PAY).noargs();
    }

    @Bean
    public Binding notPayBinding(){
        // 绑定订单超时未支付队列和订单超时未支付Exchange
        return BindingBuilder.bind(notPayQueue()).to(notPayExchange()).with(MqConstants.KEY_NOT_PAY).noargs();
    }
}