package com.pixolut.intf;

import java.util.List;

import com.pixolut.entity.Contact;

public interface ContactDao {
	
	void saveContact(Contact cnt);
	
	void updateContact(Contact cnt);
	
	void deleteContact(Contact cnt);
		
	Contact getContactById(long id);

}
