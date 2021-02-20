package com.example.demo.service;

import com.example.demo.entity.Neo4jActorEntity;
import com.example.demo.entity.Neo4jMovieEntity;
import org.junit.jupiter.api.Test;
import org.neo4j.ogm.model.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.lang.UsesSunMisc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class Neo4jServiceTest {

    @Autowired
    Neo4jService neo4jService;
    @Test
    void save() {
        Neo4jMovieEntity neo4jMovieEntity = neo4jService.queryById(Neo4jMovieEntity.class, 1L);
        Neo4jActorEntity neo4jActorEntity = new Neo4jActorEntity();
        neo4jActorEntity.setName("葛优");
        neo4jActorEntity.setAge(40);
        ArrayList<Neo4jMovieEntity> arrayList = new ArrayList<>();
        arrayList.add(neo4jMovieEntity);
        neo4jActorEntity.setMovieEntityList(arrayList);
        neo4jService.save(neo4jActorEntity);
    }

    @Test
    void queryMovie() {
        List<Neo4jMovieEntity> q = neo4jService.queryMovie("name", "下");
        for (Neo4jMovieEntity neo4jMovieEntity : q) {
            System.out.println(neo4jMovieEntity);
        }
    }

    @Test
    void deleteById() {
        Neo4jMovieEntity entity = neo4jService.queryById(Neo4jMovieEntity.class, 0L);
        neo4jService.delete(entity);
    }

    @Test
    void queryById() {
        Neo4jMovieEntity t = neo4jService.queryById(Neo4jMovieEntity.class, 0L);
        System.out.println(t);
    }
}