package com.example.demo.service;

import com.example.demo.entity.EsEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.elasticsearch.core.SearchHit;
import org.springframework.data.elasticsearch.core.SearchHits;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class EsServiceTest {

    @Autowired
    private EsService esService;
    @Test
    void search() {
        SearchHits<EsEntity> search = esService.Search(null, "石", 1, 1);
        System.out.println(search.getTotalHits());
        List<SearchHit<EsEntity>> searchHits = search.toList();
        for (SearchHit<EsEntity> searchHit : searchHits) {
            System.out.println(searchHit);
        }

    }
}