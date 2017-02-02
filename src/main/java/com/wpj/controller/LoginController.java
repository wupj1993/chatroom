/*
 * Copyright (c) 2017 wupj e-mail:wpjlovehome@gmail.com
 */

package com.wpj.controller;

import com.wpj.service.UserMsgService;
import com.wpj.util.SecurityTools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * The type Login controller.
 *
 * @author：WPJ587 2017 /1/7 22:39.
 */
@RequestMapping("/chat")
@Controller
public class LoginController extends BaseController {
    /**
     * 用户业务.
     */
    @Autowired
    private UserMsgService userMsgService;

    /**
     * Login 页面.
     *
     * @return the string
     */
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String toLogin() {
        return "login";
    }

    /**
     * 登录成功
     * @param map
     * @return
     */
    @RequestMapping("/success")
    public String success(final ModelMap map){
        map.addAttribute("user",SecurityTools.getUserMsg());
        return "chat";
    }
}
