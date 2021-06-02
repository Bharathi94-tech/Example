package com.training;


public class UserData {
	
	private int Roll_no;
	private String name;
	private String place;
	private int age;
	private char sex;
	private long mob_nnum;
	public int getRoll_no() {
		return Roll_no;
	}
	public String getName() {
		return name;
	}
	public String getPlace() {
		return place;
	}
	public int getAge() {
		return age;
	}
	public char getSex() {
		return sex;
	}
	public long getMob_nnum() {
		return mob_nnum;
	}
	public void setRoll_no(int roll_no) {
		Roll_no = roll_no;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public void setSex(char sex) {
		this.sex = sex;
	}
	public void setMob_nnum(long mob_nnum) {
		this.mob_nnum = mob_nnum;
	}
		
	
	
}