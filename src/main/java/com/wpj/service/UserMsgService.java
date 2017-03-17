/*
 * Copyright (c) 2017 wupj e-mail:wpjlovehome@gmail.com
 */

package com.wpj.service;

import com.wpj.domain.UserMsg;
import com.wpj.model.bo.OnlineBO;

import java.util.List;

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

    /**
     * 从redis中加载所有当前用户登录用户信息
     *
     * @return
     */
    List<OnlineBO> listOnlineBO(String pattern);

    /**
     * 把用户保存到redis里面
     *
     * @param onlineBO 用户
     */
    void saveOnlineBO(OnlineBO onlineBO);
}
