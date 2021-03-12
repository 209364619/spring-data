package com.example.demo.service;

import com.example.demo.entity.MybatisEntity;
import com.example.demo.entity.MybatisEntityExample;
import com.example.demo.repository.MybatisEntityMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MybatisServie {
    @Autowired
    MybatisEntityMapper mybatisEntityMapper;

    @Autowired
    PageHelper pageHelper;

    /**
     * 插入新记录
     * @param mybatisEntity
     * @return
     */
    public MybatisEntity insertOne(MybatisEntity mybatisEntity){
        mybatisEntityMapper.insertSelective(mybatisEntity);
        return mybatisEntity;
    }

    /**
     * 按页查询
     * @return
     */
    public PageInfo<MybatisEntity>  findByPage(int page, int pageSize){
        PageHelper.startPage(page,pageSize);
        MybatisEntityExample example = new MybatisEntityExample();
        List<MybatisEntity> mybatisEntities = mybatisEntityMapper.selectByExample(example);
        PageInfo<MybatisEntity> pageInfo = new PageInfo<>(mybatisEntities);
        return pageInfo;

    }

    public void findByLocalPage(int page, int pageSize){
    }
}
