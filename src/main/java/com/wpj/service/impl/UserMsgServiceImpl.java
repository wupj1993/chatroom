/*
 * Copyright (c) 2017 wupj e-mail:wpjlovehome@gmail.com
 */

package com.wpj.service.impl;

import com.wpj.dao.UserMsgMapper;
import com.wpj.domain.UserMsg;
import com.wpj.service.BaseService;
import com.wpj.service.UserMsgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * The type User msg service.
 *
 * @author：WPJ587 2017 /1/8 14:04.
 */
@Service
public class UserMsgServiceImpl  extends BaseService<UserMsg> implements UserMsgService {
    @Autowired
    private UserMsgMapper userMsgMapper;
    @Override
    public List<UserMsg> selectByUserName(String userName) {

        return userMsgMapper.selectByUserName(userName);
    }
}
