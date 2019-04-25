package com.jvtc.entity;

public class Grade {
	int  id;
	String name;
	int num;
	public Grade(int id, String name, int num) {
		super();
		this.id = id;
		this.name = name;		
		this.num = num;
	}
	public Grade() {
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	@Override
	public String toString() {
		return "Grade [id=" + id + ", name=" + name + ", num=" + num + "]";
	}
	
	
}
