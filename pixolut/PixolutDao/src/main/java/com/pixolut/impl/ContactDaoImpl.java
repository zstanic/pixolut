package com.pixolut.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.pixolut.entity.Contact;
import com.pixolut.intf.ContactDao;

@Repository
public class ContactDaoImpl extends BaseDao<Contact> implements ContactDao {

	@Override
	public void saveContact(Contact cnt) {	
		save(cnt);
	}
	
	@Override
	public void updateContact(Contact cnt) {
		saveOrUpdate(cnt);
	}
	
	@Override
	public void deleteContact(Contact cnt) {
		delete(cnt);
	}
	
		
	@Override
	public Contact getContactById(long id) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("contactId", id);
		Contact cnt = find(Contact.class, parameters).get(0);
		return cnt;
	}

}
