package com.schoolofnet.javaJdbc.model;

public class Users {
	
	private Integer id;
	private String name;
	
	public Users() {
		
	}
	
	public Users(Integer id, String name) {
		this.id   = id;
		this.name = name;
	}
	
	public Users(String name) {
		this.name = name;
	}	
	
	public Integer getId() {
		return this.id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
}
