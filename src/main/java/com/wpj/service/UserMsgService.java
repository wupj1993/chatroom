/*
 * Copyright (c) 2017 wupj e-mail:wpjlovehome@gmail.com
 */

package com.wpj.service;

import com.wpj.domain.UserMsg;

/**
 * @author：WPJ587 2017/1/8 14:02.
 **/
public interface UserMsgService extends IService<UserMsg>{
    /**
     * 根据用户名获取用户.
     * @param userName 用户名字
     * @return 用户
     */
    UserMsg selectByUserName(String userName);
}
