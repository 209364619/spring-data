package com.example.demo.repository;

import com.example.demo.entity.Neo4jMovieEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Neo4jMovieRepository extends Neo4jRepository<Neo4jMovieEntity, Long> {
    Page<Neo4jMovieEntity> findByNameContaining(String name, Pageable pageable);
}
