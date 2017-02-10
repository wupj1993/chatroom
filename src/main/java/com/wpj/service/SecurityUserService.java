/*
 * Copyright (c) 2017 wupj e-mail:wpjlovehome@gmail.com.
 */

package com.wpj.service;

import com.wpj.model.SecurityUser;

import java.util.List;

/**
 * 使用redis用于操作用户信息.
 *
 */
public interface SecurityUserService {
    /**
     * 从redis中加载所有当前用户登录用户信息
     * @return
     */
    List<SecurityUser> listSecurityUser();

    /**
     * 把用户保存到redsi里面
     * @param securityUser 用户
     */
    void saveSecurity(SecurityUser securityUser);
}