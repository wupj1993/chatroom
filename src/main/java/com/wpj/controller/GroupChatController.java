/*
 * Copyright (c) 2017 wupj e-mail:wpjlovehome@gmail.com
 */

package com.wpj.controller;

import com.wpj.model.GroupMessage;
import com.wpj.model.SingleMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.simp.annotation.SendToUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Date;

/**
 * @author：WPJ587 2017/1/9 21:41.
 **/
@Controller
public class GroupChatController extends BaseController {
    public SimpMessagingTemplate template;

    @Autowired
    public GroupChatController(SimpMessagingTemplate template) {
        this.template = template;
    }
    /**
     * 群聊通道.
     * @param content 聊天内容
     * @return 群聊信息
     */
    @MessageMapping("/group")
    @SendTo("/groups/chatting")
    public GroupMessage groupChat(@RequestParam("content")final String content) {
        GroupMessage groupMessage = new GroupMessage();
        groupMessage.setContent(content);
        groupMessage.setUserName("明雨儿");
        groupMessage.setSendTime(new Date());
        return groupMessage;
    }
    @MessageMapping("/chat")
    @SendToUser(value ="/chat",broadcast = false)
    public SingleMsg singleChat(@RequestParam("content")final String content,
                                @RequestParam("userId")final String userId,
                                HttpSession session
    ){
        session.setAttribute("user_id",userId);
        SingleMsg singleMsg=new SingleMsg();
        singleMsg.setContent(content);
        singleMsg.setToUser("小明");
        singleMsg.setFromUser("大明");
        singleMsg.setSendTime(new Date());
        return singleMsg;
    }

}
