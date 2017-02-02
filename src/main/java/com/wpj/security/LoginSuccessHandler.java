/*
 * Copyright (c) 2017 wupj e-mail:wpjlovehome@gmail.com
 */

package com.wpj.security;

import com.wpj.domain.UserMsg;
import com.wpj.service.UserMsgService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

/**
 * The type Login success handler.
 */
@Component
public class LoginSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {
    private Logger logger= LoggerFactory.getLogger(LoginSuccessHandler.class);
    /**
     * 注入操作用户.
     */
    @Autowired
    private UserMsgService sUserService;
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws ServletException, IOException {
        //获得授权后可得到用户信息   可使用SUserService进行数据库操作
        UserMsg userDetails = (UserMsg)authentication.getPrincipal();
        userDetails.setUserLastLogin(new Date());
        sUserService.updateNotNull(userDetails);
        super.onAuthenticationSuccess(request, response, authentication);
    }

}