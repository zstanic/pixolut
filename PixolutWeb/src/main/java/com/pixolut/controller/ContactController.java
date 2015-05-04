package com.pixolut.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.pixolut.ContactService;
import com.pixolut.PixolutUserDetails;
import com.pixolut.entity.Contact;
import com.pixolut.intf.UserDao;

@Controller
public class ContactController {
	
	@Autowired
	ContactService srv;
	
	PixolutUserDetails user;
		
	@RequestMapping(value="/getAllContacts.json", method=RequestMethod.GET)
	public @ResponseBody String getAllContacts(){
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		user = (PixolutUserDetails)authentication.getPrincipal();
		System.out.println(user.getUser().getUsername());
		
		String str = "";
		
		StringBuilder sb = new StringBuilder();
		
		List<Contact> lst = srv.getAllContacts(user.getUser().getId());
		
		sb.append("[");
		
		int x=0;
		
		for(Contact cnt : lst){
			sb.append("{\"id\": "+ "\""+cnt.getId()+"\","+"\"name\":"+"\""+cnt.getName()+"\","
					+"\"phone\":"+"\""+cnt.getPhone()+"\","+"\"email\":"+"\""+cnt.getEmail()+"\","
					+"\"city\":"+"\""+cnt.getCity()+"\","+"\"country\":"+"\""+cnt.getCountry()+"\"}");
			if (x<lst.size()-1)	sb.append(",");
			x++;
		}
		
		sb.append("]");
		
		System.out.println(sb.toString());
		
		str = sb.toString();
		
		return str;
	}
		
	@RequestMapping(value="/saveCnt.json", method = RequestMethod.POST)
    public ModelAndView saveContact(@RequestParam(required = false) String id,
    		@RequestParam(required = false) String name,
    		@RequestParam(required = false) String phone, 
    		@RequestParam(required = false) String email,
    		@RequestParam(required = false) String city,
    		@RequestParam(required = false) String country,
    		final RedirectAttributes redirectAttributes) {
		
		System.out.println("id: "+id);
		System.out.println("name: "+name);
		System.out.println("city: "+city);
		
		ModelAndView model = new ModelAndView();
		
		if (id==null)
		{
			Contact cnt = new Contact();
			cnt.setName(name);
			cnt.setPhone(phone);
			cnt.setEmail(email);
			cnt.setCity(city);
			cnt.setCountry(country);
			cnt.setUser(user.getUser());
						
			srv.saveContact(cnt);
			
			model.addObject("saveCnt", "Contact saved !!");
			
		}else{
			Contact cnt = srv.getContactById(Long.parseLong(id));
			
			cnt.setName(name);
			cnt.setPhone(phone);
			cnt.setEmail(email);
			cnt.setCity(city);
			cnt.setCountry(country);
			cnt.setUser(user.getUser());
			
			srv.updateContact(cnt);
			
			model.addObject("saveCnt", "Contact updated !!");
		}
		
        model.setViewName("index");
		
		return model;
	}
	
	@RequestMapping(value="/deleteCnt.json", method = RequestMethod.POST)
	public ModelAndView deleteContact(@RequestParam(required = false) String id){
		
		Contact cnt = srv.getContactById(Long.parseLong(id));
		
		srv.deleteContact(cnt);
		
		ModelAndView model = new ModelAndView();
		
        model.addObject("saveCnt", "Contact deleted !!");
        model.setViewName("index");
		
		return model;
	}

}
