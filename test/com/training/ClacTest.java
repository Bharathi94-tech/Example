package com.training;


import static org.junit.Assert.*;

import org.junit.Test;

public class ClacTest {

	@Test
	public void testAdd() {
Calc ct=new Calc();
int Expected=50;
int actuals=ct.add(20,30);
assertEquals(Expected,actuals);


	}

	@Test
	public void testSub() {
		Calc ct=new Calc();
		int Expected=-10;
		int actuals=ct.sub(20,30);
		assertEquals(Expected,actuals);
	}

	@Test
	public void testMul() {
		Calc ct=new Calc();
		int Expected=600;
		int actuals=ct.mul(20,30);
		assertEquals(Expected,actuals);
	}

	@Test
	public void testDiv() {
		Calc ct=new Calc();
		int Expected=1;
		int actuals=ct.div(20,30);
		assertEquals(Expected,actuals);
		
	
	}
	@Test
	public void testDiv_Case_1() {
		Calc ct=new Calc();
		int Expected=1;
		int actuals=ct.div(30,20);
		assertEquals(Expected,actuals);

}
}