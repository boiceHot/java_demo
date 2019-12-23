package com.boicehot.mongodb.api;

import com.boicehot.mongodb.entity.Users;
import com.boicehot.mongodb.entity.UsersInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Desc: test api
 * @Author: boiceHot
 * @Date: 2019-11-15
 */
@RestController
public class TestApi {

    @Autowired
    private MongoTemplate mongoTemplate;

    @GetMapping(value = "/save")
    public Object save(){
        Users users = new Users().setUsername("boiceHot").setPassword("xxxx1111");
        Users dbUsers = mongoTemplate.insert(users, "zxcvb");
        UsersInfo usersInfo = new UsersInfo().setAddress("广东省深圳市南山区").setUserId(dbUsers.get_id());
        mongoTemplate.insert(usersInfo, "users_info");
        return "success";
    }

    @Transactional(rollbackFor = Exception.class)
    @GetMapping(value = "/save1")
    public Object save1(){
        Users users = new Users().setUsername("boiceHot").setPassword("xxxx1111");
        Users dbUsers = mongoTemplate.insert(users, "zxcvb");
        int i = 10/0;
        UsersInfo usersInfo = new UsersInfo().setAddress("广东省深圳市南山区").setUserId(dbUsers.get_id());
        mongoTemplate.insert(usersInfo, "users_info");
        return "success";
    }
}