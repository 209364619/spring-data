package com.example.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.entity.KafKaEntity;
import com.example.demo.service.KafKaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@Api(tags = "KafKa读写")
@RestController
@RequestMapping("/kafka")
public class KafKaController {
    @Autowired
    KafKaService kafKaService;

    @ApiOperation(value = "向指定topic发送消息")
    @PostMapping("")
    public JSONObject sendJsonObject(@RequestBody KafKaEntity kafKaEntity){
        return kafKaService.sendJsonObject(kafKaEntity.getTopic(), kafKaEntity.getObject());
    }

    @ApiOperation(value = "kafka消息获取--暂存于队列中--分布式可使用kafka-cliet通过pull方法获取数据")
    @GetMapping("")
    public JSONObject fetchMessageFromTopic(){
        return kafKaService.fetchMessageFromTopic();
    }

}
