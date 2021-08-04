package com.example.demo.controller;

import com.example.demo.domain.JsonData;
import com.example.demo.utils.RedisClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/redis")
public class RedisController {

    @Autowired
    private RedisClient redisClient;


    @GetMapping("/add")
    public Object add(String key, String value) {
        redisClient.set(key, value);
        return JsonData.buildSuccess("OK");
    }

    @RequestMapping("/get")
    public Object get(String key) {
        return redisClient.get(key);
    }


}
