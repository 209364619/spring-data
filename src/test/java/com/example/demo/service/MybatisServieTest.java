package com.example.demo.service;

import com.example.demo.entity.MybatisEntity;
import com.example.demo.repository.MybatisEntityMapper;
import com.github.pagehelper.PageInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MybatisServieTest {
    @Autowired
    MybatisServie mybatisServie;

    @Test
    void insertOne() {
    }

    @Test
    void findByPage() {
        PageInfo<MybatisEntity> byPage = mybatisServie.findByPage(1, 1);
        System.out.println(byPage);
    }
}