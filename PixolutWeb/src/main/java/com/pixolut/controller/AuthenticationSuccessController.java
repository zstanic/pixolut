package com.pixolut.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

public class AuthenticationSuccessController implements AuthenticationSuccessHandler {
	
	public void onAuthenticationSuccess(HttpServletRequest arg0,
			HttpServletResponse arg1, Authentication arg2) throws IOException,
			ServletException {
		
		System.out.println("isAuthenticated: "+arg2.isAuthenticated());
		
		System.out.println("authenticated user: "+arg0.getParameter("username"));
		
		arg0.getSession().setAttribute("loggedUser", arg0.getParameter("username"));
		arg0.getSession().setAttribute("isAuthenticated", arg2.isAuthenticated());
		
		if (arg0.getParameter("remember-me")!=null)
			arg0.getSession().setAttribute("isRememberMe", true);
		else
			arg0.getSession().setAttribute("isRememberMe", false);
		
		System.out.println("remember : "+arg0.getParameter("remember-me"));
		
		arg1.sendRedirect("/index.html");
	}
	
}
