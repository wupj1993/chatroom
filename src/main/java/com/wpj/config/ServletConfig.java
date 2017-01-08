/*
 * Copyright (c) 2017 wupj e-mail:wpjlovehome@gmail.com
 */
package com.wpj.config;

import com.alibaba.druid.support.http.StatViewServlet;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.embedded.ServletRegistrationBean;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

@Configuration
public class ServletConfig extends SpringBootServletInitializer {
	
//	@SuppressWarnings("serial")
//	@Bean
//	public Servlet dispatcherServlet() {
//		return new GenericServlet() {
//			@Override
//			public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
//				res.setContentType("text/plain");
//				res.getWriter().append("Hello World");
//			}
//		};
//	}
	
	@Bean
	@Order
	public ServletRegistrationBean statViewServlet() {
		StatViewServlet servlet = new StatViewServlet();
		ServletRegistrationBean bean = new ServletRegistrationBean(servlet, "/dev/druid/*");
		return bean;
	}
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(ServletConfig.class);
	}
}