package com.example.demo.service;

import com.example.demo.entity.EsEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.data.elasticsearch.core.query.Criteria;
import org.springframework.data.elasticsearch.core.query.CriteriaQuery;
import org.springframework.data.elasticsearch.core.query.Query;
import org.springframework.stereotype.Service;
import reactor.util.annotation.Nullable;

@Service
public class EsService {
    @Autowired
    private ElasticsearchRestTemplate elasticsearchRestTemplate;

    /**
     * 将实体保存到es中
     * @param esEntity
     * @return
     */
    public EsEntity save(EsEntity esEntity){
        elasticsearchRestTemplate.save(esEntity);
        return esEntity;
    }

    /**
     * 按照字段进行检索
     * @param key
     * @param value
     * @param page
     * @param size
     * @return
     */
    public SearchHits<EsEntity> Search(@Nullable String key, String value, Integer page, Integer size){
        if(key == null){
            key = "*";
        }
        Criteria criteria = new Criteria(key);
        criteria.fuzzy(value);
        Query query = new CriteriaQuery(criteria);
        for (String field : query.getFields()) {
            System.out.println(field);
        }
        SearchHits<EsEntity> search = elasticsearchRestTemplate.search(query, EsEntity.class);
        return search;
    }
}
