package com.pixolut.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.pixolut.RegisterService;
import com.pixolut.entity.User;

@Controller
public class RegisterController {
	
	@Autowired
	RegisterService regSrv;

	@Autowired
	private BCryptPasswordEncoder encoder;
	
	@RequestMapping(value="/register.json", method = RequestMethod.POST)
    public String processRegistration(@RequestParam(required = false) String firstName,
    		@RequestParam(required = false) String lastName,
    		@RequestParam(required = false) String username, 
    		@RequestParam(required = false) String password,
    		@RequestParam(required = false) String email,
    		final RedirectAttributes redirectAttributes) {
		
		System.out.println("user: "+username);
		System.out.println("pass: "+password);
		
		User usr = new User();
		usr.setUsername(username);
		usr.setPassword(encoder.encode(password));
		usr.setFirstName(firstName);
		usr.setLastName(lastName);
		usr.setEmail(email);
		
		regSrv.saveUser(usr);
		
		return "/login";
	}
	
}
