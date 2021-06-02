package com.shop;

public class AdminDto {

	private int emp_id;
	private String emp_name;
	private String emp_place;
	private String emp_address;
	private int emp_age;
	private long emp_mn;
	private  String user_name;
	private String pass;
	private String bill_role;
	private String stock_role;
	private char active_ind;
	
	public String getBill_role() {
		return bill_role;
	}
	public String getStock_role() {
		return stock_role;
	}
	public void setBill_role(String bill_role) {
		this.bill_role = bill_role;
	}
	public void setStock_role(String stock_role) {
		this.stock_role = stock_role;
	}
	public char getActive_ind() {
		return active_ind;
	}
	public void setActive_ind(char active_ind) {
		this.active_ind = active_ind;
	}
	public String getUser_name() {
		return user_name;
	}
	public String getPass() {
		return pass;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	
	public int getEmp_id() {
		return emp_id;
	}
	public String getEmp_name() {
		return emp_name;
	}
	public String getEmp_place() {
		return emp_place;
	}
	public String getEmp_address() {
		return emp_address;
	}
	public int getEmp_age() {
		return emp_age;
	}
	public long getEmp_mn() {
		return emp_mn;
	}
	public void setEmp_id(int emp_id) {
		this.emp_id = emp_id;
	}
	public void setEmp_name(String emp_name) {
		this.emp_name = emp_name;
	}
	public void setEmp_place(String emp_place) {
		this.emp_place = emp_place;
	}
	public void setEmp_address(String emp_address) {
		this.emp_address = emp_address;
	}
	public void setEmp_age(int emp_age) {
		this.emp_age = emp_age;
	}
	public void setEmp_mn(long emp_mn) {
		this.emp_mn = emp_mn;
	}
	
}
