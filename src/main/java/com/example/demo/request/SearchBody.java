package com.example.demo.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "查询请求")
public class SearchBody {
    @ApiModelProperty(value = "查询字段", example = "name")
    private String key;
    @ApiModelProperty(value = "查询关键字", example = "中")
    private String value;
    @ApiModelProperty(value = "页码", example = "1")
    private Integer page;
    @ApiModelProperty(value = "页记显示条数", example = "10")
    private Integer size;
}
