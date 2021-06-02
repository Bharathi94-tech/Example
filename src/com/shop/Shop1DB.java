package com.shop;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;

public class Shop1DB {
	DateTimeFormatter dtf1 = DateTimeFormatter.ofPattern("dd/MM/YYYY HH:mm:ss");
	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
	LocalDateTime now = LocalDateTime.now();
	Calendar calendar = Calendar.getInstance();
	private String DB_URL = "jdbc:mysql://localhost:3306/am_shop";
	private String AD_UN = "root";
	private String AD_PASS = "bharathi94";

	ResultSet viewStock() throws SQLException {
		Connection con = DriverManager.getConnection(DB_URL, AD_UN, AD_PASS);
		Statement st = con.createStatement();
		String q1 = "Select product_id as ID,product_name as Name, Stock_status,Quantity as Quantity_Remaining,Selling_price,Expiry_date as Expiry,create_id,create_date as Date from stocks order by Date;";
		ResultSet re = st.executeQuery(q1);
		re.next();
		return re;

	}
	
	void checkQty()
	{
		
	}

	boolean addStock(StcAndCust ob, int a) throws SQLException {
		Connection con = DriverManager.getConnection(DB_URL, AD_UN, AD_PASS);
		Statement st = con.createStatement();
		String q1 = "Insert into stocks values (" + ob.getProduct_id() + ",'" + ob.getProduct_name() + "','"
				+ ob.getProd_category() + "'," + ob.getPrice() + "," + ob.getQuantity() + ",'" + ob.getStock_status()
				+ "'," + ob.getSelling_price() + ",'" + ob.getAgent() + "','" + ob.getExpiry_date() + "','" + a + "',str_to_date('"
				+ dtf1.format(now) + "','%d/%m/%Y %H:%i:%s'),NULL,NULL);";
		System.out.println(q1);
		boolean b = st.execute(q1);

		return b;
	}
	
	int checkPrdo(int a) throws SQLException
	{
		Connection con=DriverManager.getConnection(DB_URL, AD_UN, AD_PASS);
		Statement st=con.createStatement();
		String pr="Select count(*) from stocks where product_id="+a+");";
		ResultSet rt=st.executeQuery(pr);
		rt.next();
		int x=rt.getInt(1);
		if (x>0) {
			return 1;
			
		}else return 0;
	}
	
	String checkStockAvail(int a) throws SQLException {
		Connection conn=DriverManager.getConnection(DB_URL, AD_UN, AD_PASS);
		Statement st=conn.createStatement();
		String q_ch="Select product_name,count(*) from stocks where product_id="+a+" and stock_status='Y';";
		ResultSet rs=st.executeQuery(q_ch);
		rs.next();
		String s1=rs.getString(1);
		int s2=rs.getInt(2);	
		//System.out.println(s1+s2);
		conn.close();
		if (s2 > 0) {
			return "success,"+s1;
		}
		else return "failure,"+s1; 
	}

	int checkSt(int c) throws SQLException {
		Connection con = DriverManager.getConnection(DB_URL, AD_UN, AD_PASS);
		Statement st = con.createStatement();
		String q2 = "Select count(*) from stocks where product_id=" + c + ";";
		ResultSet re2 = st.executeQuery(q2);
		re2.next();
		int i = re2.getInt(1);
		con.close();
		if (i > 0) {
			return 0;
		} else
			return 1;
	}
	
	int stockDel(int a) throws SQLException
	{
		Connection con=DriverManager.getConnection(DB_URL, AD_UN, AD_PASS);
		Statement st=con.createStatement();
		String de="Delete from stocks where product_id="+a+";";
		boolean rt=st.execute(de);
		if (rt==true)
				{
			return 0;
				}else return 1;
		
		
	}
	
	
}
