package com.chaos.controller;

import com.alibaba.fastjson.JSON;
import com.chaos.common.JsonData;
import com.chaos.domain.TestRedisUser;
import com.chaos.utils.JsonUtils;
import com.chaos.utils.RedisClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("/api/v1/redis")
public class RedisTestController {


    @Autowired
    private StringRedisTemplate redisTpl;

    @Autowired
    private RedisClient redisClient;

    @GetMapping(value = "add")
    public Object add(){
        redisTpl.opsForValue().set("name", "Springboot2019");
        return JsonData.buildSuccess("OK");
    }

    @GetMapping(value = "get")
    public Object get(){
        String value = redisTpl.opsForValue().get("name");
        return JsonData.buildSuccess(value);
    }

    @GetMapping(value = "saveuser")
    public Object saveUser(){
        TestRedisUser user = new TestRedisUser("test", 10, "123456", new Date());
        String strUser = JSON.toJSONString(user);
        boolean flag = redisClient.set("base:user:10", strUser);
        return JsonData.buildSuccess(flag);
    }

    @GetMapping(value = "finduser")
    public Object findUser(){
        String user = (String) redisClient.get("base:user:10");
        TestRedisUser testRedisUser = JSON.parseObject(user, TestRedisUser.class);
        return JsonData.buildSuccess(testRedisUser);
    }

}
