package com.example.demo.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.neo4j.ogm.annotation.*;

@ApiModel
@NodeEntity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Neo4jMovieEntity {
    @Id @GeneratedValue
    private Long id;

    @ApiModelProperty(value = "电影名称")
    @Property
    private String name;
}
