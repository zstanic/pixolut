package com.pixolut.controller;

import java.util.Date;

import javax.servlet.http.HttpSessionEvent;

import org.springframework.security.web.session.HttpSessionEventPublisher;

public class SessionController extends HttpSessionEventPublisher {
	
	@Override
	public void sessionCreated(HttpSessionEvent event) {
		System.out.println("in sessionCreated");
		System.out.println("creation time "+new Date(event.getSession().getCreationTime()));
		System.out.println("last accessed time "+new Date(event.getSession().getLastAccessedTime()));
		System.out.println("max time "+event.getSession().getMaxInactiveInterval()+" sec");
	}
	
	@Override
	public void sessionDestroyed(HttpSessionEvent event) {
		System.out.println("in sessionDestroyed");
		System.out.println(new Date(System.currentTimeMillis()));
	}
	
}