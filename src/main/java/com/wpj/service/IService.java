/*
 * Copyright (c) 2017 wupj e-mail:wpjlovehome@gmail.com
 */

/*
 * ©2016 wupjhy.cn.  All rights reserved.
 */

package com.wpj.service;

import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 通用接口
 *
 * @param <T> the type parameter
 */
@Service
public interface IService<T> {

    /**
     * Select by key t.
     *
     * @param key the key
     * @return the t
     */
    T selectByKey(Object key);

    /**
     * Select list.
     *
     * @param entity the entity
     * @return the list
     */
    List<T> select(T entity);

    /**
     * Save int.
     *
     * @param entity the entity
     * @return the int
     */
    int save(T entity);

    /**
     * Delete int.
     *
     * @param key the key
     * @return the int
     */
    int delete(Object key);

    /**
     * Update all int.
     *
     * @param entity the entity
     * @return the int
     */
    int updateAll(T entity);

    /**
     * Update not null int.
     *
     * @param entity the entity
     * @return the int
     */
    int updateNotNull(T entity);

    /**
     * Select by example list.
     *
     * @param example the example
     * @return the list
     */
    List<T> selectByExample(Object example);

    /**
     * Select all list.
     *
     * @return the list
     */
    public List<T> selectAll();
    //TODO 其他...
}
