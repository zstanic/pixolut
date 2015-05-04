package com.pixolut.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

@Controller
public class LoginController {

	@RequestMapping(value = "/login.html", method = RequestMethod.GET)
    public ModelAndView login(@RequestParam(required = false) String error, 
    		@RequestParam(required = false) String logout, HttpServletRequest request) {

		String referrer = request.getHeader("Referer");
		request.getSession().setAttribute("url_prior_login", referrer);
		    
        ModelAndView model = new ModelAndView();
        if (error != null) {
        	if (error.equals("error")) {
        		model.addObject("errmsg", "User ID or password not recognised - please try again.");
        	}
        }

        model.setViewName("login");
        
        if (logout != null) {
        	if (logout.equals("logout"))
        	{
	        	model.setView(new View() {
					public void render(Map<String, ?> arg0, HttpServletRequest arg1,
							HttpServletResponse arg2) throws Exception {
						arg2.sendRedirect("j_spring_security_logout");						
					}
					public String getContentType() {
						return "";
					}
				});
        	}
        }      
        return model;
    }
	
}
