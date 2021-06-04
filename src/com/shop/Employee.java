package com.shop;

import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Employee {
	DateTimeFormatter dtf1 = DateTimeFormatter.ofPattern("dd/MM/YYYY HH:mm:ss");
	DateFormat tf = new SimpleDateFormat("MMM-YYYY");
	LocalDateTime now = LocalDateTime.now();
	Employee e;
	AdminDto adm;
	StandBl sbl;
	Admin ad;
	ShopDB sbd;
	Scanner sc;
	Stock s;
	Welcome wl;

	void regemp(String x) throws SQLException {

		sbd = new ShopDB();
		adm = new AdminDto();
		sc = new Scanner(System.in);
		System.out.println("\nEnter the Employee Name:- ");
		adm.setEmp_name(sc.next().toUpperCase());
		System.out.println("\nEnter the ind for Billing Role 'PRIM' or 'SEC' or 'NULL':- ");
		adm.setBill_role(sc.next().toUpperCase());
		System.out.println("\nEnter the ind for Stock 'PRIM' or 'SEC' or 'NULL':- ");
		adm.setStock_role(sc.next().toUpperCase());
		System.out.println("\nEnter the Employee Status");
		adm.setActive_ind(sc.next().toUpperCase().charAt(0));
		System.out.println("\nEnter the Employee Place:-");
		adm.setEmp_place(sc.next().toUpperCase());
		System.out.println("\nEnter the Employee Age:-");
		adm.setEmp_age(sc.nextInt());
		System.out.println("\nEnter the Employee Address Line 1:-");
		adm.setEmp_address(sc.next().toUpperCase());
		System.out.println("\nEnter the Employee Mobile Number:-");
		adm.setEmp_mn(sc.nextLong());
		boolean a = sbd.empcheck(adm.getEmp_mn());
		if (a == false) {
			System.out.println("Entered User already present in DataBase ");

		}
		if (a == true) {
			boolean t = sbd.regEmp(adm, x);
			if (t == false) {
				System.out.println("\n New Employee created Successfully");
			} else
				System.out.println("\nNew Employee Not created, Please Try Again \n");
		}
	}

	boolean delemp(String a) throws SQLException {
		sc = new Scanner(System.in);
		boolean r = false;
		ad = new Admin();
		sbd = new ShopDB();
		System.out.println("Enter the Employee id to delete the User");
		int x = sc.nextInt();
		r = sbd.delemp(x, a);
		return r;

	}

	boolean updemp(String a) throws SQLException {
		sbd = new ShopDB();
		sc = new Scanner(System.in);
		e = new Employee();
		boolean r = false;
		try {
			System.out.println("Enter the Employee id to Update:- ");
			int x = sc.nextInt();
			r = sbd.empidcheck(x);
			if (r == true) {
				System.out.println("Enter the Below options to Update:- ");
				System.out.println("\n1) Role \n2) Mobile Number \n3) Activate or Deactivate Employee \n4) Exit");
				int y = sc.nextInt();

				e.option_emp(y, x, a);
				return r;

			} else {
				System.out.println("Entered Employee id is not valid");
				return r;
			}
		} catch (InputMismatchException ime) {
			System.out.println("Try Again the below options:-");
			// e.updemp(a);
			return r;

		}
	}

	void role(int y, String z) throws SQLException {
		ad = new Admin();
		sbd = new ShopDB();
		int exit = 0;
		sc = new Scanner(System.in);
		e = new Employee();
		System.out.println("The Roles for the Entered Employee ID:-  ");
		String u = sbd.bill(y, "BILL");
		System.out.println("\nBill Role is :- " + u);
		String u1 = sbd.stock(y, "STOCK");
		System.out.println("\nStock Role is :- " + u1);
		do {
			System.out.println("\nEnter which Role to Change \n1-Billing Role \n2-Stockist Role \n3-Exit");
			int c = sc.nextInt();

			switch (c) {
			case 1:
				String b = e.role_updater();
				boolean h = sbd.upBill(y, z, b);
				if (h = true) {
					System.out.println("\nUpdate Successful");
					ad.success(z);
				}

			case 2:
				String b1 = e.role_updater();
				boolean h1 = sbd.upStock(y, z, b1);
				if (h = true) {
					System.out.println("\nUpdate Successful");
					ad.success(z);
				}
				exit = 1;
			}
		} while (exit == '1');
		ad.success(z);

	}

	String role_updater() {
		String updt = "";
		sc = new Scanner(System.in);
		System.out.println("Enter the Desired Role to Update:- \n1) To Primary \n2) To Secondary");
		int x = sc.nextInt();
		if (x == 1) {
			updt = "PRIM";
		}
		if (x == 2) {
			updt = "SEC";
		}
		return updt;
	}

	void option_emp(int x, int y, String a) throws SQLException {
		sbd = new ShopDB();
		ad = new Admin();
		e = new Employee();
		sc = new Scanner(System.in);
		switch (x) {
		case 1:
			e.role(y, a);
			ad.success(a);

		case 2:
			System.out.println("Enter the Mobile Player to Update:- ");
			long i = sc.nextLong();
			boolean q = sbd.empcheck(i);
			if (q == true) {
				boolean t = sbd.upMb_num(y, a, i);
				if (t == true)
					System.out.println("Employee Updated Successfully");
			} else
				System.out.println("Entered Mobile number is Same as exisiting for the Employee ID " + y);
			ad.success(a);

		case 3:
			int r = sbd.empStatus(y);
			if (r == 1) {
				System.out.println("Status of Employee " + y + " is Active");
			} else
				System.out.println("Status of Employee " + y + " is InActive");
			e.stat_updater(y, a);

		case 4:
			ad.success(a);
		}

	}

	void stat_updater(int y, String a) throws SQLException {
		sc = new Scanner(System.in);
		ad = new Admin();
		sbd = new ShopDB();
		System.out.println("Enter \n1) Activate Employee \n2) Deactivate Employee \n3) Back");
		int x = sc.nextInt();
		switch (x) {
		case 1:
			boolean m = sbd.actEmp(y, a);
			System.out.println("Employee " + y + " is Activated ");

			break;

		case 2:
			boolean n = sbd.decEmp(y, a);
			System.out.println("Employee " + y + " is Dectivated and Ready for Delete");
			System.out.println("If Need to Delete Employee press 'Y' else 'N' ");
			if (sc.next().toUpperCase().charAt(0) == 'Y') {
				sbd.delemp(y, a);
				System.out.println("\n Employee Delete Successfully");
			} else
				break;

		case 3:
			ad.success(a);
			break;
		}

	}

	void empLog() throws SQLException {
		String pass = "";
		e = new Employee();
		sbd = new ShopDB();
		wl = new Welcome();
		sc = new Scanner(System.in);
		System.out.println("\n Enter the Below Credentials");
		System.out.println("\n Employee ID:- ");
		int i = sc.nextInt();
		System.out.println("\n Password or Use 'default' as Passwoord for First time Login:- ");
//		System.out.println("PassWord :- ");
		pass = sc.next();
		int r = sbd.setDefpassEmp(i);
		if (pass.equals("default") && (r > 0)) {

			System.out.println("\n You have logged in with Default PassWord");
			System.out.println("\n Please enter the New Password:- ");
			String pa = sc.next();
			int ret = sbd.empChgPass(i, pa);
			if (ret == 1) {
				System.out
						.println("\n PassWord for the Employee ID " + i + "is Changed and Continue with New Password");
				wl.w1();
			} else
				System.out.println("\n PassWord change unsuccessful or the Entered ID is Incorrect");
			wl.w1();
		}
		if (r <= 0) {
			String tt = sbd.emplogin(i, pass);
			if (tt.equals("success")) {
				System.out.println("\n Login Successful");
				e.empSelect(i);
			} else
				System.out.println("\n Login as Employee" + i + " is UnSuccessful");
			wl.w1();
		}

	}

	void empSelect(int a) throws SQLException {
		sc = new Scanner(System.in);
		sbd = new ShopDB();
		sbl = new StandBl();
		e = new Employee();
		s = new Stock();
		String r = "";
		System.out.println(
				"\n Please select the Options below \n1) Billing \n2) Stocks \n3) Change Password \n4) Log Out");
		int x = sc.nextInt();
		switch (x)

		{
		case 1:

			String k = sbd.bill(a, "BILL");
			if (k.equals("PRIM")) {
				sbl.bill(a);
				e.empSelect(a);
			} else
				System.out.println("\n Employee " + a + " dont have proper permission");
			e.empSelect(a);

		case 2:
			r = sbd.stock(a, "STOCK");
			// System.out.println(r);
			System.out.format(
					"+-------------------------------------------------------------------------------------------------------------------------+%n");
			System.out.format(
					"+                                   WELCOME TO THE STOCK ROOM OF SAMS DEPARMENTAL STORE                                   +%n");
			System.out.format(
					"+                                        91-A PERIYAR NAGAR ,AMMAPET ,SALEM-636003                                        +%n");
			System.out.format(
					"+-------------------------------------------------------------------------------------------------------------------------+%n");
			System.out.format("+Date:- " + dtf1.format(now)
					+ "                                                                                 Emp_id:- " + a
					+ "%n");
			System.out.format(
					"+-------------------------------------------------------------------------------------------------------------------------+%n");
			s.stockSel(a, r);
			e.empSelect(a);
			// break;
		case 3:
			System.out.println("Enter the new Password");
			String s1 = sc.next();
			System.out.println("ReEnter the Password");
			String s2 = sc.next();
			int r1 = sbd.setDefpassEmp(a);
			if (s1.equals(s2) && r1 == 0) {
				int l = sbd.empChgPass(a, s2);
				if (l == '1') {
					System.out.println("\nPasswWord Change Successful and Continue with New Password");
					wl.w1();
				}
			} else
				System.out.println("\nPassWord Change Unsucessful");
			empSelect(a);

		case 4:
			wl = new Welcome();
			wl.w1();
		}
	}

}
