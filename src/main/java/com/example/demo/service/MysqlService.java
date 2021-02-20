package com.example.demo.service;

import com.example.demo.entity.MysqlEntity;
import com.example.demo.repository.MysqlEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MysqlService {
    @Autowired
    private MysqlEntityRepository mysqlEntityRepository;

    /**
     * 保存实体
     * @param mysqlEntity
     * @return
     */
    public MysqlEntity save(MysqlEntity mysqlEntity){
        mysqlEntityRepository.save(mysqlEntity);
        return mysqlEntity;
    }

    /**
     * 通过id获取数据
     * @param id
     * @return
     */
    public MysqlEntity selectById(Long id){
        Optional<MysqlEntity> entity = mysqlEntityRepository.findById(id);
        if (entity.isPresent()){
            return entity.get();
        }
        return null;
    }

    /**
     * 模糊查询名字中包含
     * @param name
     * @param page
     * @param size
     * @return
     */
    public Page<MysqlEntity> findByNameContaining(String name, int page, int size){
        Pageable pageable = PageRequest.of(page, size);
        Page<MysqlEntity> entities = mysqlEntityRepository.findByNameContaining(name, pageable);
        return entities;
    }
}
