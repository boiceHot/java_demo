package com.boicehot.rabbitmq.config;

/**
 * @Desc: mq constants
 * @Author: boiceHot
 * @Date: 2019-10-11
 */
public final class MqConstants {

    // Queue
    public static String QUEUE_NOT_PAY = "Q-NOT-PAY"; // 订单超时未支付队列
    public static String QUEUE_DL_NOT_PAY = "Q-DL-NOT-PAY"; // 订单超时未支付死信队列

    // Exchange
    public static String EXCHANGE_NOT_PAY = "E-NOT-PAY"; // 订单超时未支付Exchange

    // Routing
    public static String KEY_NOT_PAY = "K-NOT-PAY"; // 订单超时未支付队列路由key
    public static String KEY_DL_NOT_PAY = "K-DL-NOT-PAY"; // 订单超时未支付死信队列路由key
}