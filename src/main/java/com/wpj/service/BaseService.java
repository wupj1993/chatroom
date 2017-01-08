/*
 * Copyright (c) 2017 wupj e-mail:wpjlovehome@gmail.com
 */

/*
 * ©2016 wupjhy.cn.  All rights reserved.
 */

package com.wpj.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * Created by liuzh on 2014/12/11.
 *
 * @param <T> the type parameter
 */
@Service
public abstract class BaseService<T> implements IService<T> {
    /**
     * The Mapper.
     */
    @Autowired
    protected Mapper<T> mapper;

    @Override
    public T selectByKey(Object key) {

        return mapper.selectByPrimaryKey(key);
    }
    @CacheEvict(value="myCache",allEntries=true,beforeInvocation=true)
    public int save(T entity) {
        return mapper.insert(entity);
    }
    @CacheEvict(value="myCache",allEntries=true,beforeInvocation=true)
    public int delete(Object key) {
        return mapper.deleteByPrimaryKey(key);
    }
    @CacheEvict(value="myCache",allEntries=true,beforeInvocation=true)
    public int updateAll(T entity) {
        return mapper.updateByPrimaryKey(entity);
    }
    @CacheEvict(value="myCache",allEntries=true,beforeInvocation=true)
    public int updateNotNull(T entity) {
        return mapper.updateByPrimaryKeySelective(entity);
    }

    public List<T> selectByExample(Object example) {
        return mapper.selectByExample(example);
    }

    public List<T> selectAll() {
        return mapper.selectAll();
    }

    /**
     * Select list.
     *
     * @param entity the entity
     * @return the list
     */
    @Override
    public List<T> select(T entity) {
        return mapper.select(entity);
    }
}
