package com.example.demo.controller;

import com.example.demo.entity.MongoEntity;
import com.example.demo.request.SearchBody;
import com.example.demo.service.MongoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(tags = "MongoDB读写")
@RestController
@RequestMapping("mongo")
public class MongoController {
    @Autowired
    private MongoService mongoService;

    @ApiOperation(value = "写")
    @PostMapping()
    public MongoEntity save(@RequestBody MongoEntity mongoEntity){
        return mongoService.save(mongoEntity);
    }
    @PostMapping(value = "查")
    public List<MongoEntity> search(@RequestBody SearchBody searchBody){
        return mongoService.search(searchBody.getKey(), searchBody.getValue(),true);
    }
}
