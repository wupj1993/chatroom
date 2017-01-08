/*
 * Copyright (c) 2017 wupj e-mail:wpjlovehome@gmail.com
 */

package com.wpj.service;

import com.wpj.domain.UserMsg;

import java.util.List;

/**
 * @author：WPJ587 2017/1/8 14:02.
 **/
public interface UserMsgService extends IService<UserMsg>{
    List<UserMsg> selectByUserName(String userName);

}
