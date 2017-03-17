/*
 * Copyright (c) 2017 wupj e-mail:wpjlovehome@gmail.com.
 */

package com.wpj.service;

public interface BaseRedisService {

    /**
     * 通过key的正则表达式进行删除.
     *
     * @param pattern
     */
    void deleteByPattern(String pattern);

    /**
     * 添加key value 并且设置存活时间(byte)
     *
     * @param key
     * @param value
     * @param liveTime
     */
    void set(byte[] key, byte[] value, long liveTime);

    /**
     * 添加key value 并且设置存活时间
     *
     * @param key
     * @param value
     * @param liveTime 单位秒
     */
    void set(String key, String value, long liveTime);

    /**
     * 添加key value
     *
     * @param key
     * @param value
     */
    void set(String key, String value);

    /**
     * 添加key value (字节)(序列化)
     *
     * @param key
     * @param value
     */
    void set(byte[] key, byte[] value);

    /**
     * 获取redis value (String)
     *
     * @param key
     * @return
     */
    Object get(String key);


    /**
     * 检查key是否已经存在
     *
     * @param key
     * @return
     */
    Boolean exists(String key);

    /**
     * 清空redis 所有数据
     *
     * @return
     */
    Object flushDB();

    /**
     * 查看redis里有多少数据
     */
    Long dbSize();

    /**
     * 检查是否连接成功
     *
     * @return
     */
    String ping();

}