package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class RedisService {
    @Autowired
    private StringRedisTemplate redisTemplate;

    /**
     * redis插入数据
     * @param key
     * @param value
     */
    public void putKeyValue(String key, String value){
        redisTemplate.opsForValue().set(key, value);
    }

    /**
     * 根据key获取redis中的数据
     * @param key
     * @return
     */
    public String keyValueData(String key){
        String value = (String)redisTemplate.opsForValue().get(key);
        return value;
    }

    /**
     * 根据key值删除redis中数据
     * @param key
     * @return
     */
    public boolean deleteByKey(String key){
        return redisTemplate.delete(key);
    }
}
