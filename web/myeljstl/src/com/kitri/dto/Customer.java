package com.kitri.dto;

public class Customer {
	private String id;
	private String name;
	private String pass;

	public Customer() {
	}
	public Customer(String id, String name, String pass) {
		super();
		this.id = id;
		this.name = name;
		this.pass = pass;

	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", pass=" + pass + "]";
	}
	
}
