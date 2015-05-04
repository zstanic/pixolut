package com.pixolut;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pixolut.entity.User;
import com.pixolut.intf.UserDao;

@Service
public class RegisterService {
	
	@Autowired
	UserDao dao;
	
	@Transactional(value="pixolutTM")
	public void saveUser(User usr){
		dao.saveUser(usr);
	}

}
