/*
 * Copyright (c) 2017 wupj e-mail:wpjlovehome@gmail.com
 */

/*
 * ©2016 wupjhy.cn.  All rights reserved.
 */

package com.wpj.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.StandardEnvironment;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.util.ClassUtils;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by WPJ587 on 2015/9/28.
 */
@Configuration
@EnableAutoConfiguration (exclude={DataSourceAutoConfiguration.class})
public class MybatisConfig {

    private DataSource dataSource;
    @javax.annotation.Resource
    private DruidDataSourceEntity druidDataSourceEntity;
    @Bean
    public DataSource dataSource() {
        //加载配置文件属性
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(druidDataSourceEntity.getDriverClassName());
        dataSource.setUsername(druidDataSourceEntity.getUsername());
        dataSource.setPassword(druidDataSourceEntity.getPassword());
        dataSource.setUrl(druidDataSourceEntity.getUrl());
        dataSource.setMaxActive(druidDataSourceEntity.getMaxActive());
        dataSource.setMinIdle(druidDataSourceEntity.getMinIdle());
        dataSource.setValidationQuery(druidDataSourceEntity.getValidationQuery());
        dataSource.setTestOnBorrow(druidDataSourceEntity.isTestOnBorrow());
        dataSource.setTestOnReturn(druidDataSourceEntity.isTestOnReturn());
        dataSource.setTestWhileIdle(druidDataSourceEntity.isTestWhileIdle());
        dataSource.setTimeBetweenEvictionRunsMillis(druidDataSourceEntity.getTimeBetweenEvictionRunsMillis());
        dataSource.setMinEvictableIdleTimeMillis(druidDataSourceEntity.getMinEictableIdleTimeMillis());
        dataSource.setPoolPreparedStatements(druidDataSourceEntity.isPoolPreparedStatements());
        dataSource.setMaxOpenPreparedStatements(druidDataSourceEntity.getMaxOpenPreparedStatements());
        try {
            dataSource.setFilters(druidDataSourceEntity.getFilters());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        this.dataSource=dataSource;
        return dataSource;
    }

//    @Bean(name = "sqlSessionFactory")
//    public SqlSessionFactory sqlSessionFactory() throws Exception {
//        logger.info("------> sqlSessionFactory");
//        final SqlSessionFactoryBean sqlSessionFactory = new SqlSessionFactoryBean();
//        System.out.println("----first-->");
//        sqlSessionFactory.setDataSource(dataSource);
//        sqlSessionFactory.setConfigLocation(new ClassPathResource("mybatis-config.xml"));
//        Interceptor[] interceptors = new Interceptor[1];
//        PageHelper pageHelper = new PageHelper();
//        Properties properties = new Properties();
//        properties.setProperty("dialect", "mysql");
//        properties.setProperty("reasonable", "true");
//        pageHelper.setProperties(properties);
//        sqlSessionFactory.setPlugins(interceptors);
//        sqlSessionFactory.setFailFast(true);
////       sqlSessionFactory.setTypeAliases();
//        sqlSessionFactory.setMapperLocations(getResource("mapper", "*.xml"));
//        //配置插件
//
//        return sqlSessionFactory.getObject();
//    }
    public Resource[] getResource(String basePackage, String pattern) throws IOException {
        String packageSearchPath = ResourcePatternResolver.CLASSPATH_ALL_URL_PREFIX
                + ClassUtils.convertClassNameToResourcePath(new StandardEnvironment()
                .resolveRequiredPlaceholders(basePackage)) + "/" + pattern;
        Resource[] resources = new PathMatchingResourcePatternResolver().getResources(packageSearchPath);
        return resources;
    }


    @Bean
    @ConditionalOnMissingBean(name = "transactionManager")
    @ConditionalOnBean(DataSource.class)
    public PlatformTransactionManager transactionManager() {
        return new DataSourceTransactionManager(dataSource);
    }

}
