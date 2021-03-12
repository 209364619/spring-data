package com.example.demo.controller;

import com.example.demo.entity.Neo4jActorEntity;
import com.example.demo.entity.Neo4jMovieEntity;
import com.example.demo.request.SearchBody;
import com.example.demo.service.Neo4jService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "neo4j读写关系查询")
@RestController
@RequestMapping("/neo4j")
public class Neo4jController {
    @Autowired
    private Neo4jService neo4jService;


    @ApiOperation(value = "movie详情获取")
    @GetMapping("/movie/{id}")
    public Neo4jMovieEntity getNeo4jMovieEntityById(@PathVariable(value = "id") Long id){
        return neo4jService.queryById(Neo4jMovieEntity.class, id);
    }

    @ApiOperation(value = "actor详情获取")
    @GetMapping("/actor/{id}")
    public Neo4jActorEntity getNeo4jActorEntityById(@PathVariable(value = "id") Long id){
        return neo4jService.queryById(Neo4jActorEntity.class, id);
    }

    @ApiOperation(value = "删除neo4j实体")
    @DeleteMapping("entity")
    public <T> boolean deleteNeo4jEntity(@RequestBody T object){
        return neo4jService.delete(object);
    }

    @ApiOperation("根据movie指定关键词检索节点")
    @PostMapping("/movie/query")
    public List<Neo4jMovieEntity> search(@RequestBody SearchBody searchBody){
        return neo4jService.queryMovie(searchBody.getKey(), searchBody.getValue());
    }

    @ApiOperation("分页查询neo4j name包含指定关键词的字段")
    @PostMapping("/movie/find")
    public Page<Neo4jMovieEntity> findByName(@RequestBody SearchBody searchBody){
        return neo4jService.findMovieByNameContains(searchBody.getKey(), searchBody.getPage(), searchBody.getSize());
    }

    @ApiOperation(value = "保存movie实体")
    @PostMapping("/movie")
    public Neo4jMovieEntity saveMovie(@RequestBody Neo4jMovieEntity neo4jMovieEntity){
        return neo4jService.save(neo4jMovieEntity);
    }

    @ApiOperation(value = "保存actor实体")
    @PostMapping("/actor")
    public Neo4jActorEntity saveActor(@RequestBody Neo4jActorEntity neo4jActorEntity){
        return neo4jService.save(neo4jActorEntity);
    }

    @ApiOperation(value = "通过演员id获取参演的电影")
    @PostMapping("/actor/movie")
    public Page<Neo4jMovieEntity> getMovieByActorId(@RequestBody SearchBody searchBody){
        return neo4jService.getMovieByActorId(Long.valueOf(searchBody.getValue()), searchBody.getPage()-1, searchBody.getSize());
    }

}
