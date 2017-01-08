/*
 * Copyright (c) 2017 wupj e-mail:wpjlovehome@gmail.com
 */

package com.wpj.base;

import com.wpj.domain.UserMsg;
import com.wpj.service.UserMsgService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;

import java.util.Date;
import java.util.List;

/**
 * @author：WPJ587 2017/1/8 14:01.
 **/
@Rollback(value = true)
public class UserMsgTest  extends BaseTest{
    @Autowired
    UserMsgService userMsgService;
    @Test
    public void insert(){
        UserMsg userMsg = new UserMsg();
        userMsg.setUserName("wupj");
        userMsg.setUserActivity(true);
        userMsg.setUserLastLogin(new Date());
        userMsg.setUserPwd("123456");
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
}
