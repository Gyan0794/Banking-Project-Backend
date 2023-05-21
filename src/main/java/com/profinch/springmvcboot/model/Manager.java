package com.profinch.springmvcboot.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Manager
{
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private long id;
	private String email;
	private String password;
	private String name;
	private final String role = "ROLE_MANAGER";
	
	public Manager() {}
	
	public Manager(long id, String email, String password, String name) {
		super();
		this.id = id;
		this.email = email;
		this.password = password;
		this.name = name;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRole() {
		return role;
	}
	
	@Override
	public String toString() {
		return "Manager [id=" + id + ", email=" + email + ", password=" + password + ", name=" + name + ", role=" + role
				+ "]";
	}
	
}
