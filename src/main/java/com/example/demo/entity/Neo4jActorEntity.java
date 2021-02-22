package com.example.demo.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.util.List;

@ApiModel(value = "neo4j演员实体")
@NodeEntity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Neo4jActorEntity {
    @Id @GeneratedValue
    @ApiModelProperty(value = "id", hidden = true)
    private Long id;

    @ApiModelProperty("姓名")
    private String name;

    @ApiModelProperty("年龄")
    private Integer age;

    @ApiModelProperty("关联电影实体")
    @Relationship(type="ACTED_IN", direction=Relationship.OUTGOING)
    private List<Neo4jMovieEntity> movieEntityList;
}
