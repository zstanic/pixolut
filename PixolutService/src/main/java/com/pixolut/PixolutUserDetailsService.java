package com.pixolut;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pixolut.entity.User;
import com.pixolut.intf.UserDao;

@Service
public class PixolutUserDetailsService implements UserDetailsService {
	
	@Autowired
	UserDao usrDao;
	
	PixolutUserDetails userDtls;
		
	@Transactional
	public UserDetails loadUserByUsername(String username)	throws UsernameNotFoundException {
				
		User usr = usrDao.getUserByUserName(username);
		
		String password = usr.getPassword();
		
		System.out.println("is active : "+usr.getIsAcitve());
		
		List<GrantedAuthority> grantedAuthorities = new ArrayList<GrantedAuthority>();
		
        grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_USER"));

        userDtls = new PixolutUserDetails(username, password, grantedAuthorities, usr);
		return userDtls;
	}
	
	public PixolutUserDetails getUserDtls() {
		return userDtls;
	}
	
}
