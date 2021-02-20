package com.example.demo.repository;

import com.example.demo.entity.MysqlEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;

public interface MysqlEntityRepository  extends CrudRepository<MysqlEntity, Long> {
    public Page<MysqlEntity> findByNameContaining(String name, Pageable pageable);
    public Page<MysqlEntity> findByBirthBetween(Date from, Date to, Pageable pageable);
}
