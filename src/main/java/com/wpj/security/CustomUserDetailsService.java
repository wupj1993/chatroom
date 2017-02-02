/*
 * Copyright (c) 2017 wupj e-mail:wpjlovehome@gmail.com
 */

package com.wpj.security;

import com.wpj.domain.UserMsg;
import com.wpj.model.SecurityUser;
import com.wpj.service.UserMsgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
  private UserMsgService userMsgService;
    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        UserMsg userMsg = userMsgService.selectByUserName(userName);
        if(userMsg==null){
            throw new UsernameNotFoundException("用户："+userName+"不存在");
        }
        SecurityUser securityUser = new SecurityUser(userMsg);
        Authentication authentication= new UsernamePasswordAuthenticationToken(securityUser, null, securityUser.getAuthorities()) ;
        SecurityContextHolder.getContext().setAuthentication(authentication);
        return securityUser;
    }
}