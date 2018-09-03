package test.java.projectEuler;

import static org.junit.Assert.*;

import org.junit.Test;

import main.java.projectEuler.ConsecutivePrimeSum;


public class ConsecutivePrimeSumTest {

	
	 @Test
	 public void consecutivePrimeSum(){
		 assertEquals(6,ConsecutivePrimeSum.consecutivePrimeSum(100));
		 assertEquals(21,ConsecutivePrimeSum.consecutivePrimeSum(1000));
		 ConsecutivePrimeSum.consecutivePrimeSum(10000);
//		 ConsecutivePrimeSum.consecutivePrimeSum(100000);
//		 ConsecutivePrimeSum.consecutivePrimeSum(1000000);
	 }
}
