package com.boicehot.rabbitmq.api;

import com.boicehot.rabbitmq.producer.NotPayProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestRabbitMqApi {

    @Autowired
    private NotPayProducer notPayProducer;

    @GetMapping(value = "/not-pay/{item}")
    public String notPay(@PathVariable("item") String item){
        return notPayProducer.pushMsg(item);
    }
}