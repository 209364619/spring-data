package com.example.demo.controller;

import com.example.demo.entity.MybatisEntity;
import com.example.demo.service.MybatisServie;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "mybatis mysql数据增删改查", value = "mybatis数据库分页查询")
@RestController
@RequestMapping("/mybatis")
public class MybatisController {
    @Autowired
    MybatisServie mybatisServie;

    @ApiOperation(value = "mybatis插入数据")
    @PostMapping("")
    public MybatisEntity insertOne(@RequestBody MybatisEntity mybatisEntity) {
        return mybatisServie.insertOne(mybatisEntity);
    }

    @ApiOperation(value = "分页查询数据")
    @GetMapping()
    public PageInfo<MybatisEntity> findByPage(@ApiParam(value = "页码", example = "1") @RequestParam(value = "page") int page,
                                              @ApiParam(value = "页记录", example = "1")@RequestParam(value = "size") int size) {
        return mybatisServie.findByPage(page, size);
    }

}
