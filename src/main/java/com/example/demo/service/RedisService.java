package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class RedisService {
    @Autowired
    private StringRedisTemplate redisTemplate;

    public void putKeyValue(String key, String value){
        redisTemplate.opsForValue().set(key, value);
    }

    public String keyValueData(String key){
        String value = (String)redisTemplate.opsForValue().get(key);
        return value;
    }
}
