package com.boicehot.mongodb.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import java.io.Serializable;

/**
 * @Desc: users
 * @Author: boiceHot
 * @Date: 2019-11-15
 */
@Document(value = "zxcvb")
public class Users implements Serializable {
    private static final long serialVersionUID = -3163675414100712890L;

    @Id
    private String _id;

    @Field(value = "username")
    private String username;

    @Field(value = "password")
    private String password;

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getUsername() {
        return username;
    }

    public Users setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public Users setPassword(String password) {
        this.password = password;
        return this;
    }
}