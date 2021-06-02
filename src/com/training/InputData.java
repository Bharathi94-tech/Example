package com.training;

import java.util.Scanner;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.InputMismatchException;

public class InputData {
	Scanner sc;
	UserData obj;
	int exit;
	int n;
	Db access;
	boolean r2 = false;
	HashMap<Integer, UserData> stu = new HashMap<Integer, UserData>();

	void reg() throws SQLException {
		try {
			sc = new Scanner(System.in);
			obj = new UserData();
			System.out.println("Enter the Student Id: ");
			obj.setRoll_no(sc.nextInt());
			System.out.println("Enter the Student Name: ");
			obj.setName(sc.next().toUpperCase());
			System.out.println("Enter the Student Place: ");
			obj.setPlace(sc.next().toUpperCase());
			System.out.println("Enter the Student Age: ");
			obj.setAge(sc.nextInt());
			System.out.println("enter the Sex: ");
			obj.setSex(sc.next().toUpperCase().charAt(0));
			System.out.println("Enter the mobile number of Student: ");
			obj.setMob_nnum(sc.nextLong());
			access = new Db();
			access.reg(obj);
			// in(obj);
		} catch (InputMismatchException ip) {
			System.out.println("Input Mismatch and Please try again");
		}

	}

	void in(UserData obj) {
		if (obj.getRoll_no() != 0) {
			stu.put(obj.getRoll_no(), obj);
		} else
			System.out.println("The given Roll Number is Invalid" + obj.getRoll_no());

	}

	/*
	 * void print(int roll) {
	 * 
	 * System.out.println("\n=======================================");
	 * System.out.println("Student id is : " + stu.get(roll).getRoll_no());
	 * System.out.println("Student Name is :" + stu.get(roll).getName());
	 * System.out.println("Student Age is  :" + stu.get(roll).getAge());
	 * System.out.println("Student place is :" + stu.get(roll).getPlace());
	 * System.out.println("Student Sex is :" + stu.get(roll).getSex());
	 * System.out.println("Student Mobile Number is :" +
	 * stu.get(roll).getMob_nnum());
	 * System.out.println("=======================================\n"); }
	 */

	void showAll() throws SQLException {
		access = new Db();
		access.showAll();
		/*
		 * for (Integer roll : stu.keySet()) { print(roll); }
		 */

	}

	int option() {
		try {
			sc = new Scanner(System.in);
			System.out.println(
					"Enter the below given option\n 1:New\n 2:Update\n 3:Delete\n 4:Show All Data\n 5:Display One Student Data\n 6:Exit\n");
			n = sc.nextInt();
			if (n > 7) {
				System.out.println("\nEnter the above proper option\n");
			}

		} catch (InputMismatchException im) {
			System.out.println("\nEnter the proper option in Numbers..");
		}
		return n;
	}

	void delete() throws SQLException {
		access = new Db();
		sc = new Scanner(System.in);
		System.out.println("Enter the Student ID to Delete");
		int key = sc.nextInt();
		access.del(key);
		/*
		 * for (Integer temp : stu.keySet()) { if (temp == key) { stu.remove(temp); }
		 * else System.out.println("Entered Student ID is not Present\n"); }
		 */
	}

	void update() throws SQLException {

		sc = new Scanner(System.in);
		access = new Db();
		System.out.println("Enter the Student Id to get Edit");
		int x = sc.nextInt();
		r2 = access.idcheck(x);
		if (r2 == true) {
			System.out.println("\nMention Id is : " + x);

			/*
			 * if (stu.isEmpty()) {
			 * System.out.println("No Data Present\n Please try again\n"); }
			 */
			try {
				/*
				 * for (Integer temp : stu.keySet()) if (temp == x) {
				 */
				System.out.println("Enter the below options to Edit and Update the Student Information\n");
				System.out.println("\n1:Name \n2:Place \n3:Age \n4:Sex \n5:Mobile NUmber\n");
				int option = sc.nextInt();
				switch (option) {
				case 1:
					System.out.println("Enter the Name of the Student");
					String a = sc.next();
					access.updName(x, a);
					/*
					 * System.out.println("Enter the Name of the Student"); String a = sc.next();
					 * access.upd(a); //stu.get(x).setName(a);
					 */
					break;

				case 2:
					System.out.println("Enter Place of the Student");
					String b = sc.next();
					access.updPlace(x, b);
					/*
					 * System.out.println("Enter Place of the Student"); String b = sc.next();
					 * stu.get(x).setPlace(b);
					 */
					break;

				case 3:
					System.out.println("Enter Age of the Student");
					int c = sc.nextInt();
					access.updAge(x, c);

					/*
					 * System.out.println("Enter Age of the Student"); int c = sc.nextInt();
					 * stu.get(x).setAge(c);
					 */
					break;

				case 4:
					System.out.println("Enter the Sex of the Student");
					char d = sc.next().toUpperCase().charAt(0);
					if (d == 'F' || d == 'M')
						access.updSex(x, d);
					/*
					 * System.out.println("Enter the Sex of the Student"); char d =
					 * sc.next().toUpperCase().charAt(0); if (d == 'F' || d == 'M')
					 * stu.get(x).setSex(d);
					 */
					break;

				case 5:
					System.out.println("Enter Mobile Number of the Student");
					long e = sc.nextLong();
					access.updMob(x, e);
					/*
					 * System.out.println("Enter Mobile Number of the Student"); long e =
					 * sc.nextLong(); stu.get(x).setMob_nnum(e);
					 */
				}
			}
			/* } */

			catch (InputMismatchException ie) {
				System.out.println("Input Mismatch Occures\n Please Try Again\n");
			}
		} else {
			System.out.println("Mention Id is Not Present in Our Data Base : " + x);
		}
	}

	void oneStudent() throws SQLException {
		access = new Db();
		sc = new Scanner(System.in);
		System.out.println("\nEnter the Studend Id to display the Details");
		int x = sc.nextInt();
		access.one(x);
		/*
		 * for (Integer temp : stu.keySet()) if (temp == x) {
		 * System.out.println("The Student Information for the ID : " + temp);
		 * print(temp); } else
		 * System.out.println("Provided Student ID is Not Present \n Please Try Again\n"
		 * );
		 */
	}

	void selection(int x) throws SQLException {

		switch (x) {
		case 1:
			reg();
			break;

		case 2:
			update();
			break;

		case 3:
			delete();
			break;

		case 4:
			showAll();
			/*
			 * if (stu.isEmpty()) {
			 * System.out.println("\nNo Data in Present\n Please try Again\n"); }
			 */
			break;

		case 5:
			oneStudent();
			break;

		case 6:
			exit = 1;
			break;

		}

	}

	public static void main(String[] args) throws SQLException {

		InputData ip = new InputData();
		ip.exit = 0;
		do {
			int x = ip.option();
			ip.selection(x);
		} while (ip.exit != 1);

		System.out.println("\nExecuted");

	}

}
