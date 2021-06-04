package com.shop;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ShopDB {
	ShopDB sb;
	// char p;
	// char s;

	DateTimeFormatter dtf1 = DateTimeFormatter.ofPattern("dd/MM/YYYY HH:mm:ss");
	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
	LocalDateTime now = LocalDateTime.now();
	private String DB_URL = "jdbc:mysql://localhost:3306/am_shop";
	private String AD_UN = "root";
	private String AD_PASS = "bharathi94";

	boolean empcheck(long x) throws SQLException {
		Connection con = DriverManager.getConnection(DB_URL, AD_UN, AD_PASS);
		Statement st = con.createStatement();
		String q1 = "select count(*) from employee where mob_num=" + x + ";";
		ResultSet r1 = st.executeQuery(q1);
		r1.next();
		int count = r1.getInt(1);
		con.close();
		if (count <= 0) {
			return true;
		} else
			return false;

	}

	boolean regEmp(AdminDto adm, String a) throws SQLException {
		//boolean x=false;
		Connection con = DriverManager.getConnection(DB_URL, AD_UN, AD_PASS);
		Statement st = con.createStatement();
		String q1 = "INSERT into employee values (NULL,'"/* + adm.getEmp_id() + */ + adm.getEmp_name() + "','"
				+ adm.getBill_role() + "','" + adm.getStock_role() + "','" + adm.getActive_ind() + "','"
				+ adm.getEmp_place() + "'," + adm.getEmp_age() + ",'" + adm.getEmp_address() + "'," + adm.getEmp_mn()
				+ ","+ "str_to_date('" + dtf1.format(now) + "','%d/%m/%Y %H:%i:%s'),'" + a + "',NULL,NULL,default,default);";
		System.out.println(q1);
		boolean ref = st.execute(q1);
		System.out.println(ref);
		if (ref==false) 
		{
			return ref;
			}else
				return ref;

	}

	boolean delemp(int a, String b) throws SQLException {
		Connection con = DriverManager.getConnection(DB_URL, AD_UN, AD_PASS);
		Statement st = con.createStatement();
		String q1 = "select count(*) from employee where emp_id=" + a + " and active_status !='A';";
		System.out.println(q1);
		ResultSet d1 = st.executeQuery(q1);
		d1.next();
		int count = d1.getInt(1);
		if (count <= 0) {
			System.out.println("Entered Employee Id is Not Present in DataBase or Employee is in Active Status ");
			return false;
		} else {
			String del = "delete  from employee where emp_id=" + a + ";";
			boolean de = st.execute(del);
			System.out.println("Employee of ID:- " + a + " Deleted Successfully");
			con.close();
			return de;

		}

		/*
		 * else { Statement sst=con.createStatement(); String
		 * del_up="update tbale employee set delete_id='"
		 * +b+"', and delete_date=str_to_date('"+dtf.format(now)
		 * +"','%d/%m/%Y %H:%i:%s')"; String del="" }
		 */
	}

	boolean adCheck(String a, String b) throws SQLException {
		Connection con = DriverManager.getConnection(DB_URL, AD_UN, AD_PASS);
		Statement st = con.createStatement();
		String q1 = "Select count(*) from admin where username='" + a + "' and password='" + b + "';";
		System.out.println("\n" + q1);
		ResultSet r = st.executeQuery(q1);
		r.next();
		int count = r.getInt(1);
		con.close();
		if (count <= 0) {
			return false;
		} else
			return true;

	}

	boolean empidcheck(int x) throws SQLException {
		// sb = new ShopDB();
		Connection con = DriverManager.getConnection(DB_URL, AD_UN, AD_PASS);
		Statement st = con.createStatement();
		String q1 = "select count(*) from employee where emp_id=" + x + ";";
		ResultSet r1 = st.executeQuery(q1);
		r1.next();
		int count = r1.getInt(1);
		con.close();
		if (count <= 0) {
			return false;
		} else
			return true;
	}

	String bill(int x, String f) throws SQLException {
		String ch = "";

		if (f.matches("BILL")) {
			Connection con = DriverManager.getConnection(DB_URL, AD_UN, AD_PASS);
			Statement st = con.createStatement();
			String i = "select bill_role from employee where emp_id=" + x + ";";
			//System.out.println(i);
			ResultSet rew = st.executeQuery(i);
			rew.next();
			String p = rew.getString(1);
			//System.out.println(p);
			con.close();
			if (p.equals("PRIM")) {
				ch = "PRIM";
				return ch;
				
			}
			if (p.equals("SEC")) {
				ch = "SEC";
				return ch;
			}
			// = "NULL";

		}
		return ch;
	}

	String stock(int x, String op) throws SQLException {

		String ch1 = "";

		if (op == "STOCK") {
			Connection conn = DriverManager.getConnection(DB_URL, AD_UN, AD_PASS);
			Statement st1 = conn.createStatement();
			String i1 = "select stock_role from employee where emp_id=" + x + ";";
			//System.out.println(i1);
			ResultSet rew1 = st1.executeQuery(i1);
			rew1.next();
			String p1 = rew1.getString(1);
			//System.out.println(p1);
			conn.close();
			if (p1.equals("PRIM")) {
				ch1 = "PRIM";
				return ch1;

			}
			if (p1.equals("SEC")) {
				ch1 = "SEC";
				return ch1;
			}
			// ch1 = "NULL";

		}

		return ch1;

	}

	boolean upBill(int x, String z, String sl) throws SQLException {
		// sb = new ShopDB();
		Connection con = DriverManager.getConnection(DB_URL, AD_UN, AD_PASS);
		Statement st = con.createStatement();
		String q1 = "Update employee set bill_role='" + sl + "' , update_id='" + z + "', update_date='"
				+ dtf.format(now) + "' where emp_id=" + x + ";";
		System.out.println(q1);
		boolean e = st.execute(q1);
		System.out.println("Update Successful");
		con.close();
		return e;
	}

	boolean upStock(int x, String z, String sl) throws SQLException {
		// sb = new ShopDB();
		Connection con = DriverManager.getConnection(DB_URL, AD_UN, AD_PASS);
		Statement st = con.createStatement();
		String q1 = "Update employee set stock_role='" + sl + "' , update_id='" + z + "', update_date='"
				+ dtf.format(now) + "' where emp_id=" + x + ";";
		System.out.println(q1);
		System.out.println(q1);
		boolean e = st.execute(q1);
		System.out.println("Update Successful");
		con.close();
		return e;
	}

	int empStatus(int x) throws SQLException {
		// sb=new ShopDB();
		Connection con = DriverManager.getConnection(DB_URL, AD_UN, AD_PASS);
		Statement st = con.createStatement();
		String stat = "Select active_status from employee where emp_id=" + x + ";";
		//System.out.println(stat);
		ResultSet e = st.executeQuery(stat);
		e.next();
		String p = e.getString(1);
		con.close();
		//System.out.println(p);
		if (p.equals("A")) {
			return 1;
		}

		else {
			return 0;
		}
	}

	boolean actEmp(int a, String g) throws SQLException {
		Connection con = DriverManager.getConnection(DB_URL, AD_UN, AD_PASS);
		Statement st = con.createStatement();
		String act = "Update employee set active_status='A', update_id='" + g + "', update_date='" + dtf.format(now)
				+ "' where emp_id=" + a + ";";
		boolean at = st.execute(act);
		con.close();
		return at;
	}

	boolean decEmp(int a, String g) throws SQLException {
		Connection con = DriverManager.getConnection(DB_URL, AD_UN, AD_PASS);
		Statement st = con.createStatement();
		String dct = "Update employee set active_status='I', update_id='" + g + "', update_date='" + dtf.format(now)
				+ "' where emp_id=" + a + ";";
		boolean dt = st.execute(dct);
		con.close();
		return dt;
	}

	boolean upMb_num(int y, String a, long l) throws SQLException {
		Connection con = DriverManager.getConnection(DB_URL, AD_UN, AD_PASS);
		Statement st = con.createStatement();
		String mob = "Update employee set mob_num=" + l + ", update_id='" + a + "', update_date='" + dtf.format(now)
				+ "' where emp_id=" + y + ";";
		System.out.println(mob);
		boolean dt = st.execute(mob);
		con.close();
		return dt;

	}

	String emplogin(int us, String pa) throws SQLException {
		sb=new ShopDB();
		Connection con = DriverManager.getConnection(DB_URL, AD_UN, AD_PASS);
		Statement st = con.createStatement();
		boolean te = sb.empidcheck(us);
		String def = "Select count(*) from employee where password='" + pa + "' and emp_id="+us+";";
		System.out.println(def);
		ResultSet ref = st.executeQuery(def);
		ref.next();
		int k = ref.getInt(1);
		con.close();
		if (te == true && k > 0) {
			return "success";
		} else
			return "fail";
	}
	
	int setDefpassEmp(int x) throws SQLException
	{
		Connection con = DriverManager.getConnection(DB_URL, AD_UN, AD_PASS);
		Statement st = con.createStatement();
		String s1="select count(*) from employee where pass_change_id='default' and emp_id="+x+";";
		ResultSet y=st.executeQuery(s1);
		y.next();
		int c=y.getInt(1);
		if(c>0)
		{return 1;}else return 0;
		
	}

	int empChgPass(int a, String p) throws SQLException {
		Connection con = DriverManager.getConnection(DB_URL, AD_UN, AD_PASS);
		Statement st = con.createStatement();
		String def = "Update employee set password='" + p + "', pass_change_id='" + a + "', update_date='" + dtf.format(now)
				+ "' where emp_id=" + a + ";";
		//System.out.println(def);
		boolean ref = st.execute(def);
		//System.out.println(ref);
		con.close();
		
		if (ref==false)
		{
			return 1;
			//return ref;
		}else return 0;
		
	}

}
