/*
 * Copyright (c) 2017 wupj e-mail:wpjlovehome@gmail.com
 */

package com.wpj.controller;

import com.wpj.domain.UserMsg;
import com.wpj.model.GroupMessage;
import com.wpj.model.SingleMsg;
import com.wpj.service.UserMsgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.simp.annotation.SendToUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;
import java.util.Date;
import java.util.List;

/**
 * @author：WPJ587 2017/1/9 21:41.
 **/
@Controller
public class ChatController extends BaseController {

    /**
     * 自定义发送信息时候用.
     */
    @Autowired
    private SimpMessagingTemplate template;
    /**
     * 用户业务.
     */
    @Autowired
    private UserMsgService userMsgService;

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
        groupMessage.setUserName("");
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
    public void singleChat(final SingleMsg singleMsg
    ) {
        singleMsg.setSendTime(new Date());
        template.convertAndSendToUser(singleMsg.getToUser(),
                "/chat", singleMsg);
    }

    /**
     * 获取好友列表.
     *
     * @return
     */
    @MessageMapping("/friend/list")
    public void getFriendList(Principal principal) {
        //TODO 目前加载所有数据库用户，不管是不是好友
        // 这边不是很合理，没法再principal这个对象中直接拿出id
        List<UserMsg> userMsgs = userMsgService.selectAll();
        String id = null;
        for (int i = 0; i < userMsgs.size(); i++) {
            if (principal.getName().equals(userMsgs.get(i).getUserName())) {
                id = userMsgs.get(i).getId();
                userMsgs.remove(i);
            } else {
                userMsgs.get(i).setUserPwd(null);
                userMsgs.get(i).setUserRoleSet(null);
            }

        }
//        final String[] id = new String[1];
//        userMsgs.forEach((user) -> {
//            if(principal.getName().equals(user.getUserName())){
//                 id[0] = user.getId();
//                 userMsgs.remove(user);
//            }
//            user.setUserPwd(null);
//            user.setUserRoleSet(null);
//        });
        template.convertAndSendToUser(id,
                "/friend", userMsgs);

    }


}
