package com.boicehot.mongodb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

/**
 * @Desc: mongodb start
 * @Author: boiceHot
 * @Date: 2019-11-15
 */
@EnableMongoRepositories
@SpringBootApplication
public class MongoDbApplication {

    public static void main(String[] args) {
        SpringApplication.run(MongoDbApplication.class, args);
    }
}