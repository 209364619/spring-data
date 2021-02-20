package com.example.demo.repository;

import com.example.demo.entity.Neo4jActorEntity;
import com.example.demo.entity.Neo4jMovieEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Neo4jActorRepository extends Neo4jRepository<Neo4jActorEntity, Long> {
    @Query(value = "match (n)-[]->(m:Neo4jMovieEntity) where id(n)=$id return m", countQuery = "match (n)-[]->(m:Neo4jMovieEntity) where id(n)=$id RETURN count(*)")
    Page<Neo4jMovieEntity> getMovieByActorId(Long id, Pageable page);
}
