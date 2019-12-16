package com.chaos.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class TestRedisUser {
    private String name;
    private int phone;
    private String password;
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss", locale = "zh", timezone = "GMT+8")
    private Date createdTime;

    public TestRedisUser(String name, int age, String password, Date createdTime) {
        this.name = name;
        this.phone = age;
        this.password = password;
        this.createdTime = createdTime;
    }

    public TestRedisUser() {
    }
}
