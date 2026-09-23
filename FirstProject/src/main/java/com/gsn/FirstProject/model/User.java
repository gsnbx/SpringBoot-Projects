package com.gsn.FirstProject.model;

public class User {
	private long id;
	private String name;
	private String mail;
	
	public long getId() {
		return this.id;
	}
	public String getName() {
		return this.name;
	}
	public String getMail() {
		return this.mail;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setMail(String email) {
		this.mail = email;
	}
	
	public User(long id, String name, String mail) {
		this.id = id;
		this.name = name;
		this.mail = mail;
	}
}
