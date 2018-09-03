package test.java.projectEuler;

import static org.junit.Assert.*;

import org.junit.Test;

import main.java.projectEuler.FactorialDigitSum;


public class FactorialDigitSumTest {

	@Test
	public void stringMultNumber(){
		assertEquals("4", FactorialDigitSum.stringMultNumber("2",2));
		assertEquals("220", FactorialDigitSum.stringMultNumber("22",10));
	}
	
	@Test
	public void factorial(){
		assertEquals("6",FactorialDigitSum.stringFactorial(3));
		assertEquals("24",FactorialDigitSum.stringFactorial(4));
		assertEquals("3628800",FactorialDigitSum.stringFactorial(10));
		assertEquals("39916800",FactorialDigitSum.stringFactorial(11));
		assertEquals("479001600",FactorialDigitSum.stringFactorial(12));		
		System.out.println(FactorialDigitSum.stringFactorial(100));		
	}
	
	@Test
	public void factorialdigitSum(){
		assertEquals(27,FactorialDigitSum.factorialdigitSum(10));
		assertEquals(36,FactorialDigitSum.factorialdigitSum(11));
		assertEquals(27,FactorialDigitSum.factorialdigitSum(12));
		System.out.println(FactorialDigitSum.factorialdigitSum(100));
	}
	
}
