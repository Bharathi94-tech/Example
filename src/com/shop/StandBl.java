package com.shop;

import java.sql.SQLException;
import java.util.Scanner;

public class StandBl {
	Scanner sc;
	ShopDB sbd;
	Shop1DB sbd1;
	Stock stk;
	StandBl sbl;
	StcAndCust bill;

	/*
	 * void stMg() throws SQLException { sc=new Scanner(System.in); stk=new Stock();
	 * sbd=new ShopDB(); System.out.println("\n Enter the User ID:- "); int
	 * u=sc.nextInt(); System.out.println("\n Enter PassWord:- "); String
	 * pass=sc.nextLine(); String st=sbd.stock(u, "STOCK");
	 * 
	 * if ()
	 * 
	 * 
	 * }
	 */

	void bill() throws SQLException {
		// int q;
		String leftAlignFormat = "%15s %25s %25s %n";
		sbd1 = new Shop1DB();
		sc = new Scanner(System.in);
		String c = " ";
		String e=" ";
	//String bill=" ";
		while(!e.equals("bill")){
			System.out.println("Enter the Product Name to enter into the Cart");
			c = sc.next().toUpperCase();
			if (!c.equals("O")) {
			String g = sbd1.showProd(c);
			String pr_name = g.split(",")[0];
			String pr_id = g.split(",")[1];
			String pr_price = g.split(",")[2];
			System.out.format("+----------------------+--------------------+----------------------+%n");
			System.out.format("+         Name         |     PRODUCT ID     |     SELLING_PRICE    +%n");
			System.out.format("+----------------------+--------------------+----------------------+%n");
			System.out.format(leftAlignFormat, pr_name, pr_id, pr_price);
			System.out.println("Enter the ID to Add in Cart:-");
			int id=sc.nextInt();
			System.out.println("Enter the Quantity to Add in the Cart: -");
			int q = sc.nextInt();
			// bill.setProduct_id(pr_id);
	
	}
			if (c.equals("O")) {
			  e="bill";
	
		}}
		printBill();
	}
	
	
	void printBill() {
		System.out.println("The Bill Genretaed is :-");
		System.out.println("End ofCart");
	}

}
