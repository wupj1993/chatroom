/*
 * Copyright (c) 2017 wupj e-mail:wpjlovehome@gmail.com
 */

package com.wpj.dao;

import com.wpj.domain.UserMsg;
import com.wpj.util.MyMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * The interface User msg mapper.
 */
public interface UserMsgMapper extends MyMapper<UserMsg> {
    List<UserMsg> selectByUserName(@Param("userName")String userName);
}