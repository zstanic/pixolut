package com.pixolut.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "contacts", catalog = "pixolutdb")
public class Contact extends BaseEntity<Long> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6501763477179750667L;

	@Id
	@Column(name = "contact_id", unique = true, nullable = false)
	private long contactId;
	
	@Column(name = "name", length = 50)
	private String name;
	
	@Column(name = "phone", length = 50)
	private String phone;
	
	@Column(name = "email", length = 50)
	private String email;
	
	@Column(name = "city", length = 50)
	private String city;
	
	@Column(name = "country", length = 50)
	private String country;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "user_id")
	private User user;
	
	@Override
	public Long getId() {
		// TODO Auto-generated method stub
		return this.contactId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
}
