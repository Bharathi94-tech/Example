package com.shop;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Welcome {
	Scanner sc;
	Admin ad;
	Employee e;
	StandBl bl;
	Welcome wl;
	Stock stk;
	StandBl sbl;
	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
	LocalDateTime now = LocalDateTime.now();

	void w1() throws SQLException {
		wl = new Welcome();
		sc = new Scanner(System.in);
		System.out.println(
				"\n--------------------------------------------Enter the below Options to Continue--------------------------------------------");
		System.out.println(
				"\n1) Admin Login \n2) Employee Login \n3) Stocks Manager \n4) Close Application");
		int x = sc.nextInt();
		if (x > 6) {
			System.out.println("\nEnter the Above proper Option");
		} else
			optionS(x);

	}

	void optionS(int x) throws SQLException {
		e = new Employee();
		ad = new Admin();
		stk = new Stock();
		sbl = new StandBl();
		switch (x) {
		case 1:
			ad.login();
			break;

		case 2:
			e.empLog();
			break;

		case 3:
			sbl.stMg();
			break;
			
		/*
		 * case 4: stk.stView(x); break;
		 */

		case 4:
			System.out.println(
					"\n--------------------------------------------Successfully Logged out--------------------------------------------");
			System.exit(0);
		}
	}

	public static void main(String args[]) throws SQLException {
		System.out.format(
				"+-------------------------------------------------------------------------------------------------------------------------+%n");
		System.out.format(
				"+                                            WELCOME TO SAMS DEPARMENTAL STORE                                            +%n");
		System.out.format(
				"+                                        91-A PERIYAR NAGAR ,AMMAPET ,SALEM-636003                                        +%n");
		System.out.format(
				"+-------------------------------------------------------------------------------------------------------------------------+%n");
		Welcome wl = new Welcome();
		wl.w1();
	}

}
