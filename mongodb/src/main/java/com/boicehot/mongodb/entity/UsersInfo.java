package com.boicehot.mongodb.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import java.io.Serializable;

/**
 * @Desc: userInfo
 * @Author: boiceHot
 * @Date: 2019-11-15
 */
@Document(value = "users_info")
public class UsersInfo implements Serializable {
    private static final long serialVersionUID = 4204861333741870688L;

    @Id
    private String _id;

    @Field(value = "user_id")
    private String userId;

    @Field(value = "address")
    private String address;

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getUserId() {
        return userId;
    }

    public UsersInfo setUserId(String userId) {
        this.userId = userId;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public UsersInfo setAddress(String address) {
        this.address = address;
        return this;
    }
}