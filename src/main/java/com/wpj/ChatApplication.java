/*
 * Copyright (c) 2017 wupj e-mail:wpjlovehome@gmail.com
 */

package com.wpj;

import com.wpj.config.DruidDataSourceEntity;
import com.wpj.util.MyMapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;

@SpringBootApplication
@EnableAutoConfiguration
@EnableConfigurationProperties({DruidDataSourceEntity.class})
@MapperScan(basePackages = "com.wpj.dao", markerInterface = MyMapper.class)
@EnableWebMvcSecurity
public class ChatApplication {

	public static void main(String[] args) {
		SpringApplication.run(ChatApplication.class, args);
	}
}
