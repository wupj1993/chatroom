/*
 * Copyright (c) 2017 wupj e-mail:wpjlovehome@gmail.com..
 */
package com.wpj.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.AbstractWebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;

/**
 * websocket配置类.
 *
 * @author WPJ587 2017/1/10 23:20
 */
@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig extends AbstractWebSocketMessageBrokerConfigurer {

    @Override
    public void configureMessageBroker(MessageBrokerRegistry config) {
        //这句表示在groups和single这两个域上可以向客户端发消息
        config.enableSimpleBroker("/groups", "/single");
//        表示给指定用户发送（一对一）的主题前缀是“/single/”;
        config.setUserDestinationPrefix("/single/");

    }

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/chat").withSockJS();
    }

}