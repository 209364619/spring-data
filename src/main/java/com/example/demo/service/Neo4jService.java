package com.example.demo.service;

import com.example.demo.entity.Neo4jMovieEntity;
import com.example.demo.repository.Neo4jActorRepository;
import com.example.demo.repository.Neo4jMovieRepository;
import org.neo4j.ogm.model.Result;
import org.neo4j.ogm.session.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class Neo4jService {
    @Autowired
    private Session session;

    @Autowired
    private Neo4jMovieRepository neo4jMovieRepository;

    @Autowired
    private Neo4jActorRepository neo4jActorRepository;

    @Transactional
    public <T> T save(T entity){
        session.save(entity);
        return entity;
    }

    @Transactional
    public <T> T queryById(Class<T> cls, Long id){
        String queryString = String.format("MATCH (n) WHERE id(n)=%s RETURN n", id);
        HashMap<String, Object> map = new HashMap<>();
        T t = session.queryForObject(cls, queryString, map);
        return t;
    }

    @Transactional
    public List<Neo4jMovieEntity> queryMovie(String key, String name){
        HashMap<String,Object> map = new HashMap<>();
        Result query = session.query("match (n:Neo4jMovieEntity) where n."+key+"=~'.*" + name + ".*' return n", map);
        ArrayList<Neo4jMovieEntity> neo4jMovieEntities = new ArrayList<>();
        query.queryResults().forEach(item->{
            neo4jMovieEntities.add((Neo4jMovieEntity) item.get("n"));
        });
        return neo4jMovieEntities;
    }

    @Transactional
    public <T> boolean delete(T object){
        session.delete(object);
        return true;
    }

    public Page<Neo4jMovieEntity> findMovieByNameContains(String value, int page, int size){
        Pageable pageable = PageRequest.of(page, size);
        Page<Neo4jMovieEntity> byNameContaining = neo4jMovieRepository.findByNameContaining(value, pageable);
        return byNameContaining;
    }

    public Page<Neo4jMovieEntity> getMovieByActorId(Long id, int page, int size){
        Pageable pageable = PageRequest.of(page, size);
        Page<Neo4jMovieEntity> movies= neo4jActorRepository.getMovieByActorId(id, pageable);
        return movies;
    }
}
