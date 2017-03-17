/*
 * Copyright (c) 2017 wupj e-mail:wpjlovehome@gmail.com.
 */

package com.wpj.model.bo;

/**
 * reidis存储当前登录用户及其信息
 *
 * @author：WPJ587 2017/2/12 11:09.
 **/

public class OnlineBO extends BaseBO {
    private static final long serialVersionUID = 2648945488161671786L;
    /**
     * 用户id
     */
    private String userId;
    /**
     * 用户名字
     */
    private String userName;
    /**
     * 登录时间（暂时不弄）
     */
    private Long loginTime;

    public OnlineBO() {
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Long getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(Long loginTime) {
        this.loginTime = loginTime;
    }
}
