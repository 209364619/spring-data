package com.example.demo.entity;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@ApiModel(value = "Elasticsearch存储模型")
@Document(indexName = "entity")
public class EsEntity {
    @Id
    @ApiModelProperty(required = false)
    private String id;
    @ApiModelProperty(value = "名称", example = "西游记")
    private String name;
    @ApiModelProperty(value = "内容", example = "一个和尚待着一群动物去旅游！")
    private String content;

    @Override
    public String toString() {
        return "EsEntity{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", content='" + content + '\'' +
                '}';
    }

    public EsEntity(String id, String name, String content) {
        this.id = id;
        this.name = name;
        this.content = content;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
