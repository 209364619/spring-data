package com.example.demo.service;

import com.example.demo.entity.MongoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class MongoService {
    @Autowired
    private MongoTemplate mongoTemplate;

    public MongoEntity save(MongoEntity mongoEntity){
        mongoTemplate.save(mongoEntity);
        return mongoEntity;
    }

    public List<MongoEntity> search(String key, String value, boolean isRegex){
        Query query = new Query();
        Criteria criteria = new Criteria().where(key);
        if(isRegex){
            criteria.regex(String.format(".*%s.*", value));
        }else {
            criteria.is(value);
        }
        query.addCriteria(criteria);
        List<MongoEntity> mongoEntities = mongoTemplate.find(query, MongoEntity.class);
        return mongoEntities;
    }
}
