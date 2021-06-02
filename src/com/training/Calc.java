package com.training;

import java.util.Scanner;

public class Calc {
	int a, b, result, m, d, s;
	Scanner sc;

	void getInput() {
sc=new Scanner(System.in);
		System.out.println("Enter the Number 'A'");
		a = sc.nextInt();
		System.out.println("Enter the Number 'B'");
		b = sc.nextInt();
	}

	int choose() {
		System.out.println(
				"Enter the action to perform :\n 1:- Addition\n 2:- Subraction\n 3:- Multiplication\n 4:- Division\n 5:- All Operations\n 6:- Exit\n");
		sc = new Scanner(System.in);
		int n = sc.nextInt();
		return n;
	}

	void selection(int x, int a, int b) {
		switch (x) {
		case 1:
			System.out.println("Addition of A adn B is :" + add(a, b));
			break;

		case 2:
			System.out.println("Subratction of A and B is :" + sub(a, b));
			break;

		case 3:
			System.out.println("Multiplication of A and B is :" + mul(a, b));
			break;

		case 4:
			System.out.println("Division of A and B is :" + div(a, b));
			break;

		case 5:
			System.out.println("Addition is : " + add(a, b));
			System.out.println("Subraction is : " + sub(a, b));
			System.out.println("Multiplication is : " + mul(a, b));
			System.out.println("Division is : " + div(a, b));
			break;

		case 6:
			System.exit(0);

		}
	}

	int add(int a, int b) {
		int result = a + b;
		return result;
	}

	int sub(int a, int b) {
		int s = a - b;
		return s;
	}

	int mul(int a, int b) {
		int m = a * b;
		return m;
	}

	int div(int a, int b) {
		int d = 0;
		if (a >= b) {
			d = a / b;
		} else
			d = b / a;

		return d;
	}

	public static void main(String args[]) {
		Calc c = new Calc();
		c.getInput();
		int x = c.choose();
		c.selection(x, c.a, c.b);

	}

}
