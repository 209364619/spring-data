package com.example.demo.entity;

import com.alibaba.fastjson.JSONObject;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "KafKa消息接收类")
public class KafKaEntity {
    @ApiModelProperty(value = "topic名称", example = "topic1")
    private String topic;
    @ApiModelProperty(value = "消息体", example = "{'msg':'hello world'}")
    private JSONObject object;

}
