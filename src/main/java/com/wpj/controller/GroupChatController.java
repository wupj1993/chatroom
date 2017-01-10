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

import java.util.Date;

/**
 * @author：WPJ587 2017/1/9 21:41.
 **/
@Controller
public class GroupChatController extends BaseController {
    /**
     * 自定义发送信息时候用.
     */
    @Autowired
    private  SimpMessagingTemplate template;


    /**
     * 群聊通道.
     *
     * @param content 聊天内容
     * @return 群聊信息
     */
    @MessageMapping("/group")
    @SendTo("/groups/chatting")
    public GroupMessage groupChat(@RequestParam("content")
                                  final String content) {
        GroupMessage groupMessage = new GroupMessage();
        groupMessage.setContent(content);
        groupMessage.setUserName("明雨儿");
        groupMessage.setSendTime(new Date());
        return groupMessage;
    }

    /**
     * @param singleMsg 私聊信息
     * @return 消息
     * @author：wupj 2017/1/10 23:29
     */
    @MessageMapping("/chat")
    @SendToUser(value = "/chat", broadcast = false)
    public SingleMsg singleChat(final SingleMsg singleMsg
    ) {

        singleMsg.setFromUser("大明");
        singleMsg.setSendTime(new Date());
        template.convertAndSendToUser(singleMsg.getToUser(),
                "/chat", singleMsg);
        return singleMsg;
    }

}
