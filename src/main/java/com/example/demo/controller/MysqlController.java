package com.example.demo.controller;

import com.example.demo.entity.MysqlEntity;
import com.example.demo.request.SearchBody;
import com.example.demo.service.MysqlService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@Api(value = "mysql操作")
@RestController
@RequestMapping("mysql")
public class MysqlController {
    @Autowired
    private MysqlService mysqlService;

    @GetMapping("/entity/{id}")
    public MysqlEntity findById(@PathVariable(value = "id") Long id) {
        return mysqlService.selectById(id);
    }

    @PostMapping("/search")
    public Page<MysqlEntity> findById(@RequestBody SearchBody searchBody) {
        return mysqlService.findByNameContaining(searchBody.getValue(),
                searchBody.getPage(), searchBody.getSize());
    }
}
