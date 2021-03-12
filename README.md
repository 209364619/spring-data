 # spring boot 数据读写
 ## 基于JPA操作
> jpa 操作相对简单，只需导入相关jar包，根据JPA对应的规则书写即可完成快速完成操作
 ### mysql
> mysql额外的数据库连接
```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-data-jpa</artifactId>
</dependency>
<dependency>
    <groupId>mysql</groupId>
    <artifactId>mysql-connector-java</artifactId>
    <scope>runtime</scope>
</dependency>
```
 ### neo4j
 >neo4j只需导入对应starter
```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-data-neo4j</artifactId>
</dependency>
```
 ## 基于Template对象操作
 ### mongodb
 > mongodb starter中以及注入了MongoTemplate对象，可以直接使用该对象完成相关的查询，也可是实现CRUD接口快速实现业务
 ```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-data-mongodb</artifactId>
</dependency>
```
 ### elasticsearch
 > elasticsearch starter中已注入ElasticsearchRestTemplate, 将使用JSONObject完成restful query body即可实现相关检索
```xml
 
```
 
 ### redis
> redisTemplate读写
### kafka
> kafka消息订阅与消费
### mybatis 
> 添加pagehelper进行物理磁盘分页