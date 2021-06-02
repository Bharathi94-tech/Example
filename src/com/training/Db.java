package com.training;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*import com.mysql.cj.jdbc.Driver;*/

public class Db {
	// class.forName()
	String DB_URL = "jdbc:mysql://localhost:3306/student_info";
	String USER = "root";
	String PASS = "bharathi94";
	boolean dd = false;

	/*
	 * public void connn() throws SQLException { Connection
	 * con=DriverManager.getConnection(DB_URL,USER,PASS); Statement
	 * st=con.createStatement(); }
	 */

	void one(int x) throws SQLException {

		Connection con = DriverManager.getConnection(DB_URL, USER, PASS);
		Statement st = con.createStatement();
		String q = "Select count(*) from stu_info where id=" + x + ";";
		ResultSet rq1 = st.executeQuery(q);
		rq1.next();
		int count = rq1.getInt(1);

		if (count > 0) {
			String w = "Select * from stu_info where id=" + x + ";";
			ResultSet s1 = st.executeQuery(w);
			while (s1.next()) {
				System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
				printDb(s1);
			}
		} else
			System.out.println("No Data Found in our DataBase");
		con.close();
	}

	void del(int x) throws SQLException {

		Connection con = DriverManager.getConnection(DB_URL, USER, PASS);
		Statement st = con.createStatement();
		String q = "Select count(*) from stu_info where id=" + x + ";";
		ResultSet rq1 = st.executeQuery(q);
		rq1.next();
		int count = rq1.getInt(1);

		if (count > 0) {
			String q1 = "DELETE from stu_info where id=" + x + ";";
			boolean dd = st.execute(q1);
			System.out.println("\nStudent Data " + x + " is Deleted Successfully\n");

		}

		else
			System.out.println("No Data Found in our DataBase");
		con.close();
	}

	void showAll() throws SQLException {
		Connection con = DriverManager.getConnection(DB_URL, USER, PASS);
		Statement st = con.createStatement();
		String q = "Select * from stu_info;";
		ResultSet r = st.executeQuery(q);
		while (r.next()) {
			System.out.println("\n==================================");
			printDb(r);

		}
		con.close();
	}

	Boolean idcheck(int x) throws SQLException {
		Connection con = DriverManager.getConnection(DB_URL, USER, PASS);
		Statement st = con.createStatement();
		String q = "Select count(*) from stu_info where id=" + x + ";";
		ResultSet rq1 = st.executeQuery(q);
		rq1.next();
		int count = rq1.getInt(1);
		if (count > 0) {

			return true;
			// con.close();

		} else {
			return false;
			// con.close();
		}

	}

	void updName(int y, String a) throws SQLException {
		Connection con = DriverManager.getConnection(DB_URL, USER, PASS);
		Statement st = con.createStatement();
		String u1 = "UPDATE stu_info set name='" + a + "' where id=" + y + ";";
		// System.out.println(u1);
		boolean dd = st.execute(u1);
		String q = "Select * from stu_info where name='" + a + "';";
		ResultSet r = st.executeQuery(q);
		r.next();
		{
			System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			System.out.println("Updated Student Record is : ");
			printDb(r);

		}
	}

	void updPlace(int y, String a) throws SQLException {
		Connection con = DriverManager.getConnection(DB_URL, USER, PASS);
		Statement st = con.createStatement();
		String u1 = "UPDATE stu_info set place='" + a + "' where id=" + y + ";";
		// System.out.println(u1);
		boolean dd = st.execute(u1);
		String q = "Select * from stu_info where place='" + a + "';";
		ResultSet r = st.executeQuery(q);
		r.next();
		{
			System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			System.out.println("Updated Student Record is : ");
			printDb(r);

		}
	}

	void updAge(int y, int a) throws SQLException {
		Connection con = DriverManager.getConnection(DB_URL, USER, PASS);
		Statement st = con.createStatement();
		String u1 = "UPDATE stu_info set place='" + a + "' where id=" + y + ";";
		// System.out.println(u1);
		boolean dd = st.execute(u1);
		String q = "Select * from stu_info where age='" + a + "';";
		ResultSet r = st.executeQuery(q);
		r.next();
		{
			System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			System.out.println("Updated Student Record is : ");
			printDb(r);

		}
	}

	void updSex(int y, char a) throws SQLException {
		Connection con = DriverManager.getConnection(DB_URL, USER, PASS);
		Statement st = con.createStatement();
		String u1 = "UPDATE stu_info set place='" + a + "' where id=" + y + ";";
		// System.out.println(u1);
		boolean dd = st.execute(u1);
		String q = "Select * from stu_info where sex='" + a + "';";
		ResultSet r = st.executeQuery(q);
		r.next();
		{
			System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			System.out.println("Updated Student Record is : ");
			printDb(r);

		}
	}

	void updMob(int y, long a) throws SQLException {
		Connection con = DriverManager.getConnection(DB_URL, USER, PASS);
		Statement st = con.createStatement();
		String u1 = "UPDATE stu_info set place='" + a + "' where id=" + y + ";";
		// System.out.println(u1);
		boolean dd = st.execute(u1);
		String q = "Select * from stu_info where place='" + a + "';";
		ResultSet r = st.executeQuery(q);
		r.next();
		{
			System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			System.out.println("Updated Student Record is : ");
			printDb(r);

		}
	}

	void printDb(ResultSet r) throws SQLException {

		System.out.println("\nThe Student id is : " + r.getInt(1));
		System.out.println("\nName : " + r.getString(2));
		System.out.println("\nAge : " + r.getInt(3));
		System.out.println("\nPlace : " + r.getString(4));
		System.out.println("\nSex : " + r.getString(5));
		System.out.println("\nMobile number : " + r.getInt(6));
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
		// con.close();
	}

	void reg(UserData obj) throws SQLException {
		Connection con = DriverManager.getConnection(DB_URL, USER, PASS);
		Statement st = con.createStatement();
		String q = "INSERT into stu_info values (" + obj.getRoll_no() + ",'" + obj.getName() + "','" + obj.getAge()
				+ "','" + obj.getPlace() + "','" + obj.getSex() + "','" + obj.getMob_nnum() + "');";
		System.out.println(q);
		st.execute(q);
		System.out.println("User Added Successfully");

	}

}
