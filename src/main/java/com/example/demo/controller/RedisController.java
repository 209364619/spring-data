package com.example.demo.controller;

import com.example.demo.service.RedisService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api("Redis读写")
@RestController
@RequestMapping("/redis")
public class RedisController {
    @Autowired
    private RedisService redisService;

    @ApiOperation(value = "Redis添加值")
    @PostMapping("/{key}/{value}")
    public boolean setKey(@ApiParam(value = "键", required = true, example = "count") @PathVariable(value = "key")String key,
                        @ApiParam(value = "值", required = true, example = "10")@PathVariable(value = "value")String value){
        redisService.putKeyValue(key, value);
        return true;
    }
    @ApiOperation(value = "获取键值")
    @GetMapping()
    public String getRandom(@ApiParam(value = "键", example = "count")@RequestParam(value = "key")String key){
        return redisService.keyValueData(key);
    }

    @ApiOperation(value = "根据key删除redis中数据")
    @PostMapping("/{key}")
    public boolean deleteByKey(@ApiParam(value = "redis中key")@PathVariable String key){
        return redisService.deleteByKey(key);
    }
}
