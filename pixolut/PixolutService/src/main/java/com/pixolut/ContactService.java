package com.pixolut;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pixolut.entity.Contact;
import com.pixolut.intf.ContactDao;
import com.pixolut.intf.UserDao;

@Service
public class ContactService {
	
	@Autowired
	ContactDao dao;
	
	@Autowired
	UserDao usrDao;
	
	@Transactional(value="pixolutTM")
	public void saveContact(Contact cnt){
		dao.saveContact(cnt);
	}
	
	@Transactional(value="pixolutTM")
	public void updateContact(Contact cnt){
		dao.updateContact(cnt);
	}
	
	@Transactional(value="pixolutTM")
	public void deleteContact(Contact cnt){
		dao.deleteContact(cnt);
	}
		
	public Contact getContactById(long id){
		return dao.getContactById(id);
	}

	public List<Contact> getAllContacts(long id) {
		return usrDao.getAllContacts(id);
	}
}
