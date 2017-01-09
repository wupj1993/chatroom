/*
 * Copyright (c) 2017 wupj e-mail:wpjlovehome@gmail.com
 */

package com.wpj.controller;

import com.wpj.domain.UserMsg;
import com.wpj.service.UserMsgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * The type User controler.
 *
 * @author：WPJ587 2017 /1/9 23:10.
 */
@Controller
@RequestMapping("/user")
public class UserControler extends BaseController {
    /**
     * 操作用户类.
     */
    @Autowired
    private UserMsgService userMsgService;

    /**
     * 获取所有的用户.
     *
     * @return 用户列表 list
     */
    @RequestMapping("/getUser")
    @ResponseBody
    public List<UserMsg> getUserMessage() {
        return userMsgService.selectAll();
    }
}
