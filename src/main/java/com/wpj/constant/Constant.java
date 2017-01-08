/*
 * Copyright (c) 2017 wupj e-mail:wpjlovehome@gmail.com
 */

package com.wpj.constant;

import com.wpj.util.MyMapper;

/**
 * The type Constant.
 *
 * @author：WPJ587 2017 /1/7 16:36.
 */
public final class Constant {
    /**
     * 年龄.
     */
    public static final Integer AGE = 12;
    /**
     * mybatis扫描的基本包.
     */
    public static final String MYBATIS_BASE_PACKAGE="com.wpj.dao";
    /**
     * mybatis 通用Mapper 基本MARKER_INTERFACE
     */
    public static final Class MYBATIS_MARKER_INTERFACE= MyMapper.class;
    /**
     * "sqlSessionFactory" bean名字.
     */
    public static final String SQLSESSIONFACTORY="sqlSessionFactory";
    /**
     * 私有构造器.
     */
    private Constant() {
    }
}
