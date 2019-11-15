package com.boicehot.mongodb.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.MongoTransactionManager;

/**
 * @Desc: 事物
 * @Author: boiceHot
 * @Date: 2019-11-15
 */
@Configuration
public class MongoTransactionConfig {

    @Bean
    MongoTransactionManager transactionManager(MongoDbFactory factory){
        return new MongoTransactionManager(factory);
    }
}