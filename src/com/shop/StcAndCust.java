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
private long cust_mb_num;
public long getCust_mb_num() {
	return cust_mb_num;
}
public void setCust_mb_num(long cust_mb_num) {
	this.cust_mb_num = cust_mb_num;
}
private int Cust_bill_id;
private String Cust_addr;
private String pr_id;
public String getPr_id() {
	return pr_id;
}
public String getPr_name() {
	return pr_name;
}
public String getSell_price() {
	return Sell_price;
}
public void setPr_id(String pr_id) {
	this.pr_id = pr_id;
}
public void setPr_name(String pr_name) {
	this.pr_name = pr_name;
}
public void setSell_price(String sell_price) {
	Sell_price = sell_price;
}
private String pr_name;
private String Sell_price;

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

public int getCust_bill_id() {
	return Cust_bill_id;
}
public String getCust_addr() {
	return Cust_addr;
}


public void setProduct_id(int i) {
	Product_id = i;
}
public void setProduct_name(String product_name) {
	Product_name = product_name;
}
public void setPrice(double d) {
	Price = d;
}
public void setQuantity(int i) {
	Quantity = i;
}
public void setAgent(String agent) {
	Agent = agent;
}
public void setCustomer_id(int customer_id) {
	Customer_id = customer_id;
}
public String setCust_Name(String cust_Name) {
	return Cust_Name = cust_Name;

}
public void setCust_bill_id(int cust_bill_id) {
	Cust_bill_id = cust_bill_id;
}
public String setCust_addr(String cust_addr) {
	return Cust_addr = cust_addr;
}

}



