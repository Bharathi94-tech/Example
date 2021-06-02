package com.shop;

//import java.util.Date;

public class StcAndCust {
	//StcAndCust stc=new StcAndCust();
private int Product_id;
private String Product_name;
private String prod_category;
private String expiry_date;

public String getExpiry_date() {
	return expiry_date;
}
public void setExpiry_date(String string) {
	this.expiry_date = string;
}
public String getProd_category() {
	return prod_category;
}
public void setProd_category(String prod_category) {
	this.prod_category = prod_category;
}
private double Price;
private String stock_status;
public String getStock_status() {
	return stock_status;
}
public void setStock_status(String stock_status) {
	this.stock_status = stock_status;
}
private double selling_price;


public double getSelling_price() {
	return selling_price;
}
public void setSelling_price(double selling_price) {
	this.selling_price = selling_price;
}
private int Quantity;
private String Agent;
private int Customer_id;
private String Cust_Name;
private long Cust_Mob_Num;
private int Cust_bill_id;
private String Cust_addr;

public int getProduct_id() {
	return Product_id;
}
public String getProduct_name() {
	return Product_name;
}
public double getPrice() {
	return Price;
}
public int getQuantity() {
	return Quantity;
}
public String getAgent() {
	return Agent;
}
public int getCustomer_id() {
	return Customer_id;
}
public String getCust_Name() {
	return Cust_Name;
}
public long getCust_Mob_Num() {
	return Cust_Mob_Num;
}
public int getCust_bill_id() {
	return Cust_bill_id;
}
public String getCust_addr() {
	return Cust_addr;
}


public void setProduct_id(int product_id) {
	Product_id = product_id;
}
public void setProduct_name(String product_name) {
	Product_name = product_name;
}
public void setPrice(double d) {
	Price = d;
}
public void setQuantity(int quantity) {
	Quantity = quantity;
}
public void setAgent(String agent) {
	Agent = agent;
}
public void setCustomer_id(int customer_id) {
	Customer_id = customer_id;
}
public void setCust_Name(String cust_Name) {
	Cust_Name = cust_Name;
}
public void setCust_Mob_Num(long cust_Mob_Num) {
	Cust_Mob_Num = cust_Mob_Num;
}
public void setCust_bill_id(int cust_bill_id) {
	Cust_bill_id = cust_bill_id;
}
public void setCust_addr(String cust_addr) {
	Cust_addr = cust_addr;
}





}
