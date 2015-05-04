package com.pixolut;

import java.util.List;

import org.springframework.security.core.GrantedAuthority;

import com.pixolut.entity.User;

public class PixolutUserDetails extends org.springframework.security.core.userdetails.User {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8819516643639512781L;
	private User user;
	
	public PixolutUserDetails(String username, String password, List<GrantedAuthority> grantedAuthorities, User user){
        super(username, password, grantedAuthorities);
        this.user = user;
    }

    public User getUser(){
        return user;
    }

}
