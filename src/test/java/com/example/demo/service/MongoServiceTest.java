package com.example.demo.service;

import com.example.demo.entity.MongoEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MongoServiceTest {
    @Autowired
    private MongoService mongoService;

    @Test
    void save() {
        MongoEntity mongoEntity = new MongoEntity();
        mongoEntity.setName("卡卡罗特");
        mongoEntity.setContent("卡卡罗特是孙悟空在贝吉塔行星的名字！");
        System.out.println(mongoService.save(mongoEntity));
    }

    @Test
    void search() {
        List<MongoEntity> search = mongoService.search("content", "卡", true);
        for (MongoEntity entity : search) {
            System.out.println(entity);
        }
        List<MongoEntity> search1 = mongoService.search("name", "孙悟空", false);
        for (MongoEntity entity : search1) {
            System.out.println(entity);
        }
    }
}