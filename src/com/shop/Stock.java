package com.shop;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class Stock {
	// Stock stt=new Stock();
	Date d = Calendar.getInstance().getTime();
	DateTimeFormatter dtf1 = DateTimeFormatter.ofPattern("dd/MM/YYYY HH:mm:ss");
	DateFormat tf = new SimpleDateFormat("MMM-YYYY");
	LocalDateTime now = LocalDateTime.now();
	Calendar cl = Calendar.getInstance();
	ShopDB sbd;
	Employee e;
	Scanner sc;
	StcAndCust stc;
	Welcome wl;
	Stock stk;
	Shop1DB sbd1;

	ResultSet stView(int a) throws SQLException {
		sbd = new ShopDB();
		sbd1 = new Shop1DB();
		e = new Employee();
		stk = new Stock();
		int s = sbd.empStatus(a);

		if (s == 1) {
			System.out.println("\n Stocks in Range are:- \n");
			ResultSet rs = sbd1.viewStock();
			// aString [] tableHeaders=
			// {"ID","NAME","STOCK_STATUS","QUANTITY_REAMINING","SELLING_PRICE","EXPIRY","CREATE_ID","DATE"};
			stk.printStock(rs);
		} else
			System.out.println("\n Employee Not in Active Status");
		e.empSelect(a);
		return null;

	}
	// "%-15s %15s %n" %-15s%-15s%-15s%n

	void printStock(ResultSet r) throws SQLException {
		// String leftAlignFormat = "|%-9s|%-15s|%-25s|%-18s|%-21s|%-15s|%-15s|%-15s%n";
		String leftAlignFormat = "%-15s %-15s %15s %15s %20s %25s %20s %20s %n";
		System.out.format(
				"+------------+----------------------+--------------------+-------------------+----------------------+-----------------+-------------------+--------------+%n");
		System.out.format(
				"| ID         | Name                 | STOCK_STATUS       | QUANTIT_REM       | SELLING_PRICE        | EXPIRY          | CREATE_ID         | DATE         |%n");
		System.out.format(
				"+------------+----------------------+--------------------+-------------------+----------------------+-----------------+-------------------+--------------+%n");
		while (r.next()) {
			System.out.format(leftAlignFormat, r.getInt(1), r.getString(2), r.getString(3), r.getInt(4), r.getDouble(5),
					r.getString(6), r.getInt(7), r.getDate(8));
		}
	}
	
	void printOneStock(String r) throws SQLException {
		// String leftAlignFormat = "|%-9s|%-15s|%-25s|%-18s|%-21s|%-15s|%-15s|%-15s%n";
		String leftAlignFormat = "%-15s %-15s %15s %15s %20s %n";
		System.out.format(
				"+------------+----------------------+--------------------+-------------------+----------------------+%n");
		System.out.format(
				"| ID         | Name                 | STOCK_STATUS       | QUANTIT_REM       | SELLING_PRICE        |%n");
		System.out.format(
				"+------------+----------------------+--------------------+-------------------+----------------------+%n");
		System.out.format(leftAlignFormat,r.split(",")[0],r.split(",")[1],r.split(",")[2],r.split(",")[3],r.split(",")[4]);
		}

	void stDel(int a, String sel) throws SQLException {
		sbd1 = new Shop1DB();
		String x = "";
		sc = new Scanner(System.in);
		System.out.println("\nEnter the Product ID to Delete the Stock :- ");
		int s = sc.nextInt();
		x = sbd1.checkStockAvail(s);
		// System.out.println(x);
		String sp = x.split(",")[1];
		// System.out.println(sp);
		if (x.startsWith("failure")) {
			System.out.println("\n Entered Product (" + sp + ")  of Id " + s + "is Not Available");
		} else {
			System.out.println("\nEntered Prodcut (" + sp + ") is Available in Stocks:- ");
			System.out.println("\nIf You Wish to Contiue enter 'Y' else 'N'");
			char c = sc.next().toUpperCase().charAt(0);
			if (c == 'Y') {
				int r = sbd1.stockDel(s);
				if (r == 0) {
					System.out.format("+---------------------------------------------------------+%n");
					System.out.format("+********Product " + sp + " is Deleted Successful********+%n");
					System.out.format("+---------------------------------------------------------+%n");
					// stk.stockSel(a, sel);
				} else
					System.out.format("\n+---------------------------------------------------------+%n");
				System.out.format("\n+*******Product " + sp + " is Deleted UnSuccessful*******+%n");
				System.out.format("\n+---------------------------------------------------------+%n");
			}

		}

	}

	void stAdd(int a, String sel) throws SQLException {
		sbd1 = new Shop1DB();
		stk = new Stock();
		stc = new StcAndCust();
		sc = new Scanner(System.in);
		System.out.println("\nPlease Enter the below Details to Add the Products");
		System.out.println("\n Enter the Prodcut_id");
		stc.setProduct_id(sc.nextInt());
		int r = sbd1.checkSt(stc.getProduct_id());
		if (r == 0) {
			System.out.println("\nProduct Already Present..Please Confirm");

			stk.stockSel(a, sel);

		}
		if (r == 1) {

			System.out.println("\n Enter the Product_Name");
			stc.setProduct_name(sc.next().toUpperCase());
			System.out
					.println("\n Select the Prodcut Category as \n1) Cosmetics \n2) Edibles \n3) HomeCare \n4) Frutis");
			int x = sc.nextInt();
			switch (x) {
			case 1:
				stc.setProd_category("COSMO");
				cl.add(Calendar.MONTH, 18);
				stc.setExpiry_date(tf.format(cl.getTime()));
				break;

			case 2:
				stc.setProd_category("EDI");
				cl.add(Calendar.MONTH, 4);
				stc.setExpiry_date(tf.format(cl.getTime()));
				break;

			case 3:
				stc.setProd_category("HMCRE");
				cl.add(Calendar.MONTH, 18);
				stc.setExpiry_date(tf.format(cl.getTime()));
				break;

			case 4:
				stc.setProd_category("FRU");
				cl.add(Calendar.DATE, 5);
				stc.setExpiry_date(tf.format(cl.getTime()));
				break;
			}

			System.out.println("\n Enter the Price in Rupess");
			stc.setPrice(sc.nextDouble());
			System.out.println("\n Enter the Quantity");
			stc.setQuantity(sc.nextInt());
			System.out.println("\n Enter the Stock Availability :-");
			stc.setStock_status(sc.next().toUpperCase());
			System.out.println("Ente the Selling Price");
			stc.setSelling_price(sc.nextDouble());
			System.out.println("\n Enter the Agency");
			stc.setAgent(sc.next().toUpperCase());
		}
		boolean s = sbd1.addStock(stc, a);

		if (s == false) {
			System.out.println("\n Stocks Entered Successfully\n");
			stockSel(a, sel);
		} else
			System.out.println("\n Error in Adding the Stocks...Please Try Again");
		stockSel(a, sel);

	}

	void stockUpd(int a, String sel) throws SQLException {
		sc = new Scanner(System.in);
		sbd1 = new Shop1DB();
		stk = new Stock();
		wl = new Welcome();
		System.out.println("\n Enter the Product_id to Edit:- ");
		int r = sc.nextInt();
		stk.printOneStock(sbd1.viewOneprod(r));
		int p1 = sbd1.checkPrdo(r);
		// System.out.println(p1);
		if (p1 == 1) {
			System.out.println(
					"\n Enter the below  Options to Update:- \n1) Quantity \n2) Selling Price \n3) Back \n4) Log Out");
			int f = sc.nextInt();

			switch (f) {
			case 1:
				System.out.println("\n Enter the below Options to Update:- ");
				System.out.println("\n1) To Add \n2) To Reduce");
				int se = sc.nextInt();
				if (se == 1) {
					System.out.println("\nEnter the  Quantity to add:- ");
					int d = sc.nextInt();
					int q = sbd1.checkQty(r);
					d = d + q;
					sbd1.updqty(r, d,a);
					stk.stockSel(a, sel);
				}
				if (se == 2) {
					System.out.println("\nEnter the  Quantity to Reduce:- ");
					int d = sc.nextInt();
					int q = sbd1.checkQty(r);
					d = q - d;
					sbd1.updqty(r, d,a);
					stk.stockSel(a, sel);
				}

			case 2:
				System.out.println("\nEnter the Selling Price to Update:- ");
				double x = sc.nextDouble();
				int re = sbd1.updSellp(r,x,a);
				if (re == 1) {
					System.out.println("\n Updated the Selling Price");
					stk.stockSel(a, sel);
				} else
					System.out.println("\n Updating the Selling Price is Unscuccessful");
				stk.stockSel(a, sel);

			case 3:
				stk.stockSel(a, sel);
				break;

			case 4:
				wl.w1();
			}
		} else
			System.out.println("\n Entered Product ID is Invalid or Product not present in the Stock Room");

	}

	void stockSel(int a, String sel) throws SQLException {
		sc = new Scanner(System.in);
		sbd = new ShopDB();
		wl = new Welcome();
		e = new Employee();
		stk = new Stock();
		System.out.println(
				"\n Enter the below options to Continue :- \n1) Add Stock \n2) View All Stock Info \n3) Update Stock \n4) Delete a Product from Stock \n5) Exit Stock Room. \n6) Log Out");
		int x = sc.nextInt();
		int r = sbd.empStatus(a);
		//System.out.println(r);
		switch (x) {
		case 1:
			if (sel.equals("PRIM") && (r == 1)) {
				stk.stAdd(a, sel);
				stk.stockSel(a, sel);
			} else
				System.out.println("\n Employe ID :-" + a + " is not having the Required Permission to add the Stock");

		case 2:
			stk.stView(a);
			stk.stockSel(a, sel);

		case 3:
			if (sel.equals("PRIM") && (r == 1)) {
				stk.stockUpd(a, sel);
				stk.stockSel(a, sel);
			} else
				System.out.println("\n Employe ID :-" + a + " is not having the Required Permission to add the Stock");
		case 4:
			if (sel.equals("PRIM") && (r == 1)) {
			stk.stDel(a, sel);
			stk.stockSel(a, sel);
			}else System.out.println("\n Employe ID :-" + a + " is not having the Required Permission to add the Stock");
		case 5:
			e.empSelect(a);
		case 6:
			wl.w1();

		}

	}
}
