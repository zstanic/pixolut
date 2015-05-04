package com.pixolut.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.pixolut.entity.Contact;
import com.pixolut.entity.User;
import com.pixolut.intf.UserDao;

@Repository
public class UserDaoImpl extends BaseDao<User> implements UserDao {

	@Override
	public List<Contact> getAllContacts(long id) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("userId", id);

	    List<User> cnt = find(User.class, params);
	    	    
		return cnt.get(0).getContacts();
	}
	
	@Override
	public Long saveUser(User user) {
		this.save(user);
		return user.getId();
	}

	@Override
	public void updateUser(User user) {
		this.update(user);
	}

	@Override
	public void deleteUser(User user) {
		this.delete(user);
	}

	@Override
	public User getUserByPrimaryKey(Long userId) {
		return this.get(User.class, userId);
	}

	@Override
	public List<User> getUsers(Map<String, Object> parameters) {
		return find(User.class, parameters);
	}

	@Override
	public User getUserByUserName(String username) {	
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("username", username);
//	    params.put("isActive", true);
	    List<User> users = find(User.class, params);
	    if(users != null && !users.isEmpty()){
	    	return users.get(0);
	    }	    
		return null;
	}

	@Override
	public User getUserByEmail(String email) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("email", email);
//	    params.put("isActive", 1);
	    List<User> users = find(User.class, params);
	    if(users != null && !users.isEmpty()){
	    	return users.get(0);
	    }	    
	    return null;
	}

	@Override
	public List<User> getAllUsers() {
		return this.findAll(User.class);
	}

	@Override
	public List<User> find(String hql) {
		return this.find(hql, User.class);
	}

}
