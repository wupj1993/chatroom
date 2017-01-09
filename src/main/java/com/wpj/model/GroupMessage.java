/*
 * Copyright (c) 2017 wupj e-mail:wpjlovehome@gmail.com
 */

package com.wpj.model;

import java.util.Date;

/**
 * The type Group message.
 *
 * @author：WPJ587 2017 /1/9 21:46.
 */
public class GroupMessage extends BaseModel {
    private static final long serialVersionUID = 657263379780149079L;
    /**
     * 群号.
     */
    private String groupNum;
    /**
     * 发送该消息的用户名.
     */
    private String userName;
    /**
     * 用户发送的内容.
     */
    private String content;
    /**
     * 用户发送该消息的时间.
     */
    private Date sendTime;

    public GroupMessage() {
    }

    public GroupMessage(String groupNum, String userName, String content, Date sendTime) {
        this.groupNum = groupNum;
        this.userName = userName;
        this.content = content;
        this.sendTime = sendTime;
    }

    public String getGroupNum() {
        return groupNum;
    }

    public void setGroupNum(String groupNum) {
        this.groupNum = groupNum;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getSendTime() {
        return sendTime;
    }

    public void setSendTime(Date sendTime) {
        this.sendTime = sendTime;
    }
}
