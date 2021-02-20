package com.example.demo.controller;

import com.example.demo.entity.EsEntity;
import com.example.demo.request.SearchBody;
import com.example.demo.service.EsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.web.bind.annotation.*;


@Api(value = "Elasticsearch存取")
@RestController
@RequestMapping("es")
public class EsController {
    @Autowired
    private EsService esService;

    @ApiOperation(value = "写")
    @PostMapping()
    public EsEntity insert(@RequestBody EsEntity esEntity){
        return esService.save(esEntity);
    }

    @ApiOperation(value = "读")
    @PostMapping("/search")
    public SearchHits<EsEntity> fullTestSearch(@RequestBody SearchBody searchBody){
        return esService.Search(searchBody.getKey(), searchBody.getValue(), searchBody.getPage(), searchBody.getSize());

    }
}
