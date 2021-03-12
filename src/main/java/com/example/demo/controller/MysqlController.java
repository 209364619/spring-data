package com.example.demo.controller;

import com.example.demo.entity.MysqlEntity;
import com.example.demo.request.SearchBody;
import com.example.demo.service.MysqlService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@Api(tags = "mysql jpa 完成数据读写")
@RestController
@RequestMapping("mysql")
public class MysqlController {
    @Autowired
    private MysqlService mysqlService;

    @ApiOperation(value = "mysql插入新数据")
    @PostMapping("/entity")
    public MysqlEntity insert(@ApiParam(value = "新增Mysql数据") @RequestBody MysqlEntity mysqlEntity){
        mysqlService.save(mysqlEntity);
        return mysqlEntity;
    }
    @GetMapping("/entity/{id}")
    public MysqlEntity findById(@PathVariable(value = "id") Long id) {
        return mysqlService.selectById(id);
    }

    @PostMapping("/search")
    public Page<MysqlEntity> findByNameContaining(@RequestBody SearchBody searchBody) {
        return mysqlService.findByNameContaining(searchBody.getValue(),
                searchBody.getPage(), searchBody.getSize());
    }
}
