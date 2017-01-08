/*
 * Copyright (c) 2017 wupj e-mail:wpjlovehome@gmail.com
 */

package com.wpj.controller;

import com.wpj.domain.UserMsg;
import com.wpj.service.UserMsgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

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
     *
     * @param name 名字
     * @param pwd 密码
     * @param map 传参数
     *  @return 聊天室页面
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String checkUser(
            @RequestParam(name = "name", required = true)final String name,
            @RequestParam(name = "pwd", required = true)final String pwd,
            final ModelMap map
    ) {
        UserMsg userMsg = new UserMsg();
        userMsg.setUserName(name);
        userMsg.setUserPwd(pwd);
        List<UserMsg> userMsgs = userMsgService.select(userMsg);
        if (userMsgs.size() > 0 && userMsgs.size() <= 1) {
            userMsg = userMsgs.get(0);
            map.addAttribute("user", userMsg);
        } else {
            return "redirect:login";
        }
        return "chat";
    }
}
