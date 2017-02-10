/*
 * Copyright (c) 2017 wupj e-mail:wpjlovehome@gmail.com
 */

package com.wpj.config;

import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.HandshakeInterceptor;

import javax.servlet.http.HttpSession;
import java.util.Map;
@Component
public class HttpSessionIdHandshakeInterceptor implements HandshakeInterceptor {

 @Override
 public boolean beforeHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler, Map

  attributes) throws Exception {
  if (request instanceof ServletServerHttpRequest) {
   ServletServerHttpRequest servletRequest = (ServletServerHttpRequest) request;
   HttpSession session = servletRequest.getServletRequest().getSession(false);
   if (session != null) {
    attributes.put("HTTPSESSIONID", session.getId());
   }
  }
  return true;
 }

 public void afterHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler, Exception ex) {
 }
}
