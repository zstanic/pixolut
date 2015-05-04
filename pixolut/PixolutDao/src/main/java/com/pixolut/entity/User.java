package com.pixolut.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "user", catalog = "pixolutdb")
public class User extends BaseEntity<Long> implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4536799491372465407L;

	@Id
	@Column(name = "user_id", unique = true, nullable = false)
	private long userId;
	
	@Column(name = "first_name", length = 50)
	private String firstName;

	@Column(name = "last_name", length = 50)
	private String lastName;
	
	@Column(name = "is_acitve")
	private Boolean isAcitve;

	@Column(name = "username", length = 20)
	private String username;

	@Column(name = "password", length = 100)
	private String password;
	
	@Column(name = "email", length = 50)
	private String email;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "user")
	private List<Contact> contacts = new ArrayList<Contact>();
	
	public List<Contact> getContacts() {
		return contacts;
	}
	
	public void setContacts(List<Contact> contacts) {
		this.contacts = contacts;
	}
	
	@Override
	public Long getId() {
		return this.userId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Boolean getIsAcitve() {
		return isAcitve;
	}

	public void setIsAcitve(Boolean isAcitve) {
		this.isAcitve = isAcitve;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
}
