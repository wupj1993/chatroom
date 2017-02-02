/*
 * Copyright (c) 2017 wupj e-mail:wpjlovehome@gmail.com
 */

package com.wpj.base;

import com.wpj.domain.UserMsg;
import com.wpj.service.UserMsgService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.annotation.Rollback;

import java.util.Date;
import java.util.List;

/**
 * @author：WPJ587 2017/1/8 14:01.
 **/
@Rollback(value = false)
public class UserMsgTest  extends BaseTest{
    @Autowired
    UserMsgService userMsgService;
    @Test
    public void insert(){
        UserMsg userMsg = new UserMsg();
        BCryptPasswordEncoder bc=new BCryptPasswordEncoder(4);

        userMsg.setUserName("mye");
        userMsg.setUserActivity(true);
        userMsg.setUserLastLogin(new Date());
        userMsg.setUserPwd(bc.encode("123456"));
        userMsg.setUserNick("明雨儿");
        userMsg.setUserMotto("幸福呢？然后呢？");
        userMsg.setUserEmail("mingyuer@pj.com");
        userMsgService.save(userMsg);
    }
    @Test
    public void select(){

//        Example example = new Example(UserMsg.class);
////        example.createCriteria().andGreaterThan("id", 100);
       UserMsg userMsg=new UserMsg();
        userMsg.setUserName("wupj");
        userMsg.setUserPwd("123456");
        userMsg.setUserActivity(false);
        List<UserMsg> countryList = userMsgService.select(userMsg);
        for (int i = 0; i <countryList.size() ; i++) {
            System.out.println(countryList.get(i).toString());
        }
    }
    @Test
    public void createUserPwd(){
        BCryptPasswordEncoder bc=new BCryptPasswordEncoder(4);
        UserMsg userMsg=new UserMsg();
        userMsg.setUserName("wupj");
        userMsg.setUserPwd(bc.encode("123456789"));
        userMsg.setUserActivity(false);
        userMsg.setUserEmail("757671834@qq.com");
        userMsg.setUserLastLogin(new Date());
        userMsg.setUserMotto("喜欢你没道理");
        System.out.println(userMsgService.save(userMsg));
    }
}
