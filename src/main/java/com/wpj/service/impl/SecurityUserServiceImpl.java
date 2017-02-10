/*
 * Copyright (c) 2017 wupj e-mail:wpjlovehome@gmail.com.
 */

package com.wpj.service.impl;

import com.wpj.model.SecurityUser;
import com.wpj.service.SecurityUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author：WPJ587 2017/2/9 22:44.
 **/
@Service
public class SecurityUserServiceImpl implements SecurityUserService {
    @Autowired
    RedisTemplate redisTemplate;
    /**
     * 从redis中加载所有当前用户登录用户信息
     *
     * @return
     */
    @Override
    public List<SecurityUser> listSecurityUser() {
        ValueOperations<String, SecurityUser> valueops = redisTemplate.opsForValue();
        return null;
    }

    /**
     * 把用户保存到redsi里面
     *
     * @param securityUser 用户
     * @return
     */
    @Override
    public void saveSecurity(SecurityUser securityUser) {
        ValueOperations<String, SecurityUser> valueops = redisTemplate.opsForValue();
        valueops.set("online:"+securityUser.getId(),securityUser);
    }
}
