package com.shop;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

public class StandBl {
	DateTimeFormatter dtf1 = DateTimeFormatter.ofPattern("dd/MM/YYYY HH:mm:ss");
	LocalDateTime now = LocalDateTime.now();
	Scanner sc;
	ShopDB sbd;
	Shop1DB sbd1;
	Stock stk;
	Employee e;
	StandBl sbl;
	StcAndCust bill;
	ArrayList<String> arr;
	HashMap<Integer, String> blpr;

	void stMg() throws SQLException {
		try {
			sc = new Scanner(System.in);
			stk = new Stock();
			sbd = new ShopDB();
			System.out.print("\n Enter the User ID:- ");
			int u = sc.nextInt();
			System.out.print("\n Enter PassWord:- ");
			String pass = sc.next();
			String st = sbd.stock(u, "STOCK");
			if (st.equals("PRIM")) {
				String g = sbd.emplogin(u, pass);
				System.out.println(g);
				if (g.equals("success")) {
					stk.stockSel(u, st);
				} else
					System.out.println("----------------------LOGIN UNSUCCESSFUL----------------------");
			}
		} catch (InputMismatchException ime) {
			System.out.println("Input Mismatch Occurs Please Try Again");
		}
	}

	void bill(int a) throws SQLException {
		int no = 0;
		sbl = new StandBl();
		String leftAlignFormat = "%15s %25s %25s %n";
		sbd1 = new Shop1DB();
		sc = new Scanner(System.in);
		String x = " ";
		String e = " ";
		arr = new ArrayList<String>();
		while (!e.equals("bill")) {
			System.out.println("Enter the Product Name to enter into the Cart");
			x = sc.next().toUpperCase();
			if (!x.equals("O")) {
				ArrayList<String> r = sbd1.showProd(x);
				System.out.format("+----------------------+--------------------+----------------------+%n");
				System.out.format("+         Name         |     PRODUCT ID     |     SELLING_PRICE    +%n");
				System.out.format("+----------------------+--------------------+----------------------+%n");
				int k = r.size();
				// System.out.println(r);
				for (int i = 0; i < k; i++) {
					String b = ((String) r.get(i)).split(",")[0];
					String b1 = ((String) r.get(i)).split(",")[1];
					String b2 = ((String) r.get(i)).split(",")[2];
					System.out.format(leftAlignFormat, b, b1, b2);
				}

				System.out.println("\n Enter the ID to Add in Cart:-");
				int id = sc.nextInt();
				// System.out.println(id);
				String g = sbd1.getProd(id);
				// System.out.println(g);
				String pr_name = g.split(",")[0];
				String pr_id = g.split(",")[1];
				String pr_price = g.split(",")[2];
				System.out.println("\n Enter the Quantity to Add in the Cart: - ");
				int q = sc.nextInt();
				// blpr.put(no,id+","+pr_name+","+q+","+pr_price );
				no = no + 1;
				arr.add(no + "," + pr_id + "," + pr_name + "," + q + "," + pr_price);
				// bill.setProduct_id(pr_id);

			}
			if (x.equals("O")) {
				e = "bill";

			}
		}

		sbl.getCust(a, arr);

	}

	void getCust(int a, ArrayList<String> arr) throws SQLException {
		sbd1 = new Shop1DB();
		sbl = new StandBl();
		sc = new Scanner(System.in);
		System.out.println("Enter the Customer Mobile Number:- ");
		long mob = sc.nextLong();
		int g = sbd1.selCust(mob);
		System.out.println(g);
		if (g == 0) {
			sbl.regCust(a, mob, arr);
		} else
			sbl.printBill(a, mob, arr);
	}

	void regCust(int a, long mob, ArrayList<String> arr) throws SQLException {
		sbl = new StandBl();
		sbd1 = new Shop1DB();
		bill = new StcAndCust();
		sc = new Scanner(System.in);
		System.out.println("If you Wish to Register Customer Press 'Y' else Press 'N' ");
		char m = sc.next().toUpperCase().charAt(0);
		if (m == 'Y') {
			System.out.println(m);
			System.out.println("Enter the Name of the Customer:- ");
			bill.setCust_Name(sc.next().toUpperCase());
			System.out.println("Enter the Customer Address:- ");
			bill.setCust_addr(sc.next().toUpperCase());
			System.out.println("Enter the Customer Mobile Number:- ");
			bill.setCust_mb_num(sc.nextLong());
			System.out.println();
			int h = sbd1.regCust(bill, a);
			if (h == 1) {
				System.out.println("\nCustomer Registered Successfully");
				sbl.getCust(a, arr);
			}
		} else
			sbl.printBill(a, mob, arr);

	}

	void printBill(int emp, long mob, ArrayList<String> arr) throws SQLException {
		sbd1 = new Shop1DB();
		sbl = new StandBl();
		e = new Employee();
		sc = new Scanner(System.in);
		String leftAlignFormat = "%-13s %-25s %-25s %-25s %-25s %-25s %n";
		System.out.format(
				"+-------------------------------------------------------------------------------------------------------------------------------+%n");
		System.out.format(
				"+                                             WELCOME TO THE SAMS DEPARMENTAL STORE                                             +%n");
		System.out.format(
				"+                                           91-A PERIYAR NAGAR ,AMMAPET ,SALEM-636003                                           +%n");
		System.out.format(
				"+-------------------------------------------------------------------------------------------------------------------------------+%n");
		double grand_Total = 0.0;
		System.out.format("Bill_Date:- " + dtf1.format(now)
				+ "                                                                                 Emp_id:- " + emp
				+ "%n");
		System.out.format("Customer ID:- " + mob);
		System.out.format(
				"                                                                                                                                 %n");
		System.out.format(
				"+------------+----------------------+------------------------+----------------------+--------------------+----------------------+%n");
		System.out.format(
				"+   S.no     |     Product ID       |          Name          |     SELLING_PRICE    |        No's        |       ITEM PRICE     +%n");
		System.out.format(
				"+------------+----------------------+------------------------+----------------------+--------------------+----------------------+%n");

		System.out.format(
				"                                                                                                                                 %n");
		// int x=arr.size();
		for (int i = 0; i < arr.size(); i++) {
			int a = Integer.parseInt(arr.get(i).split(",")[0]);
			int b = Integer.parseInt(arr.get(i).split(",")[1]);
			String c = arr.get(i).split(",")[2];
			double d = Double.parseDouble(arr.get(i).split(",")[4]);
			int e = Integer.parseInt(arr.get(i).split(",")[3]);
			int su = sbd1.deductStock(b, e, emp);
			if (su <= 0) {
				System.out.println("\n Stocks Not Updated....PLease Retry again....");
			}
			double it_price = e * d;
			grand_Total = grand_Total + it_price;
			System.out.format(leftAlignFormat, a, b, c, d, e, it_price);
			// bill.setPr_id(b);;

		}
		double gst_c = (grand_Total * (6 / 100));
		double gst_s = (grand_Total * (6 / 100));
		System.out.format(
				"                                                                                                           ----------------------%n");
		System.out.format(
				"                                                                                                                 SGST - "
						+ gst_c + "%n");
		System.out.format(
				"                                                                                                                 CGST - "
						+ gst_s + "%n");
		double Total = grand_Total + gst_c + gst_s;
		System.out.format(
				"                                                                                                          Grand Total:- "
						+ Total + "%n");
		System.out.format(
				"                                      ---@@@@@@---THANK YOU AND VISIT US AGAIN---@@@@@@--                                        %n");
		System.out.println("\n Enter the Payment Method 1)CASH 2)CARD ");
		int pay = sc.nextInt();
		String w = "";
		switch (pay) {
		case 1:
			w = "CASH";
			break;
		case 2:
			w = "CARD";
			break;
		/*
		 * case 3: w = sc.next(); break;
		 */
		}
		int u = sbd1.genBill(emp, mob, w);
		if (u == '1') {
			System.out.println(
					"\n --------------------------------------------BILL GENERATED SUCCESSFULLY--------------------------------------------");

		}
		System.out.println("TO  CONTINUE BILLING PRESS '1' or '2' FOR MAIN MENU");
		int l = sc.nextInt();
		if (l == 1) {
			sbl.bill(emp);
		} else
			e.empSelect(emp);

	}

}
