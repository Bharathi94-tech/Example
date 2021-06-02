package com.shop;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Admin {

	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/YYYY HH:mm:ss");
	LocalDateTime now = LocalDateTime.now();

	boolean exit = false;
	// Admin ad = new Admin();
	Admin ad;
	AdminDto adm;
	Employee e;
	Scanner sc;
	String d;
	String b;
	ShopDB sbd;
	Welcome wed = new Welcome();
	boolean a = false;

	/*
	 * void adcheck() { System.out.println("Enter the Below options:- ");
	 * System.out.println("\n1) Login 2) Create New Admin id"); int x=sc.nextInt();
	 * ad.selection(x); }
	 */

	void login() throws SQLException {
		ad = new Admin();
		sbd = new ShopDB();
		sc = new Scanner(System.in);
		System.out.println("Plese enter the Below Credentials:- ");
		System.out.println("\nUserName:- ");
		String a = sc.nextLine();
		System.out.println("\nPassWord:- ");
		String b = sc.nextLine();
		boolean res = sbd.adCheck(a, b);
		if (res == true) {
			System.out.format(
					"+-------------------------------------------------------------------------------------------------------------------------+%n");
			System.out.format(
					"+                                      WELCOME TO SAMS DEPARMENTAL STORE - ADMIN CONSOLE                                  +%n");
			System.out.format(
					"+-------------------------------------------------------------------------------------------------------------------------+%n");
			System.out.format(
					"+-------------------------------------------------------------------------------------------------------------------------+%n");
			System.out.format( "Welocme Admin:- "+a+"                                                             Date and Time:- "+dtf.format(now)+"+%n");
			ad.success(a);
		} else {
			System.out.println("\nIncorrect User Name or Password\n");
			wed.w1();
		}
	}

	void success(String a) throws SQLException {
		ad = new Admin();
		wed = new Welcome();
		sc = new Scanner(System.in);
		do {
			System.out.println("\nEnter the below Options to Continue");
			System.out.println("\n1) Add a new User \n2) Remove User \n3) Update User \n4) Log Out ");
			int x = sc.nextInt();
			ad.options(x, a);
		} while (exit = false);
		{
			wed.w1();
		}

	}

	void options(int x, String a) throws SQLException {
		ad = new Admin();
		e = new Employee();
		boolean r = false;
		switch (x) {
		case 1:
			e.regemp(a);
			ad.success(a);
			break;

		case 2:
			e.delemp(a);
			ad.success(a);

		case 3:
			e.updemp(a);
			ad.success(a);

		case 4:
			exit = true;

			/*
			 * ad.success(a); break;
			 */

			/* case 5: exit=true; */

		}
	}
}
