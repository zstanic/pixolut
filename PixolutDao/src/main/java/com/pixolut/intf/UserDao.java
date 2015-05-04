package com.pixolut.intf;

import java.util.List;
import java.util.Map;

import com.pixolut.entity.Contact;
import com.pixolut.entity.User;

public interface UserDao {
	
	public Long saveUser(User user);

    public void updateUser(User user);

    public void deleteUser(User user);

    public User getUserByPrimaryKey(Long userId);

    public List<User> getUsers(Map<String, Object> parameters);

    public User getUserByUserName(String username);
    
    public User getUserByEmail(String email);
    
    public List<User> getAllUsers();
    
    public List<User> find(String hql);
    
    public List<Contact> getAllContacts(long id);

}
