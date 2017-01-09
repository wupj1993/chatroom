/*
 * Copyright (c) 2017 wupj e-mail:wpjlovehome@gmail.com
 */

package com.wpj.model;

import java.util.Date;

/**
 * The type 私聊.
 *
 * @author：WPJ587 2017 /1/9 23:02.
 */
public class SingleMsg extends BaseModel {
    private static final long serialVersionUID = -3862360692939432972L;
    /**
     * 谁发的.
     */
    private String fromUser;
    /**
     * 发给谁.
     */
    private String toUser;
    /**
     * 时间.
     */
    private Date sendTime;
    /**
     * 内容
     */
    private String content;
    /**
     * 是否已读后期数据库.
     */
    private Boolean read;

    /**
     * Instantiates a new Single msg.
     */
    public SingleMsg() {
    }

    /**
     * Instantiates a new Single msg.
     *
     * @param fromUser the from user
     * @param toUser   the to user
     * @param sendTime the send time
     * @param content  the content
     * @param read     the read
     */
    public SingleMsg(String fromUser, String toUser,
                     Date sendTime, String content, Boolean read) {
        this.fromUser = fromUser;
        this.toUser = toUser;
        this.sendTime = sendTime;
        this.content = content;
        this.read = read;
    }

    /**
     * Gets from user.
     *
     * @return the from user
     */
    public String getFromUser() {
        return fromUser;
    }

    /**
     * Sets from user.
     *
     * @param fromUser the from user
     */
    public void setFromUser(String fromUser) {
        this.fromUser = fromUser;
    }

    /**
     * Gets to user.
     *
     * @return the to user
     */
    public String getToUser() {
        return toUser;
    }

    /**
     * Sets to user.
     *
     * @param toUser the to user
     */
    public void setToUser(String toUser) {
        this.toUser = toUser;
    }

    /**
     * Gets send time.
     *
     * @return the send time
     */
    public Date getSendTime() {
        return sendTime;
    }

    /**
     * Sets send time.
     *
     * @param sendTime the send time
     */
    public void setSendTime(Date sendTime) {
        this.sendTime = sendTime;
    }

    /**
     * Gets content.
     *
     * @return the content
     */
    public String getContent() {
        return content;
    }

    /**
     * Sets content.
     *
     * @param content the content
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * Gets read.
     *
     * @return the read
     */
    public Boolean getRead() {
        return read;
    }

    /**
     * Sets read.
     *
     * @param read the read
     */
    public void setRead(Boolean read) {
        this.read = read;
    }
}
