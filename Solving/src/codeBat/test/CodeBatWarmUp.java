package codeBat.test;

import static org.junit.Assert.*;

import org.junit.Test;

import codeBat.implementation.WarmUp;

public class CodeBatWarmUp {
	@Test
	public void warmUp1(){
		assertEquals(WarmUp.sleepIn(false, false),true);
		assertEquals(WarmUp.sleepIn(true, false),false);
		assertEquals(WarmUp.sleepIn(false, true),true);
	}
	
	@Test
	public void warmUp2(){
		int n = 1;
		assertEquals(21 - n , WarmUp.diff21(n) );
		n = 31;
		assertEquals(  Math.abs((21 - n)*2)  , WarmUp.diff21(n) );
	}
	
	@Test
	public void warmUp3(){
		assertEquals(true, WarmUp.nearHundred(99) );
		assertEquals(false, WarmUp.nearHundred(49) );
		assertEquals(true, WarmUp.nearHundred(101) );
		assertEquals(true, WarmUp.nearHundred(201) );
		assertEquals(true, WarmUp.nearHundred(199) );
	}

	@Test
	public void warUp4(){
		assertEquals("ktten",WarmUp.missingChar("kitten", 1));
		assertEquals("itten",WarmUp.missingChar("kitten", 0));
		assertEquals("kittn",WarmUp.missingChar("kitten", 4));
	}
	
	@Test
	public void warmUp5(){
		assertEquals("tcatt",WarmUp.backAround("cat"));
		assertEquals("oHelloo",WarmUp.backAround("Hello"));
		assertEquals("aaa",WarmUp.backAround("a"));
	}
	
	@Test
	public void warmUp6(){
		assertEquals(true,WarmUp.starHi("hi there"));
		assertEquals(false,WarmUp.starHi("hello hi"));
		assertEquals(true,WarmUp.starHi("hi"));
	}
	
	@Test
	public void warmUp7(){
		assertEquals(true,WarmUp.hasTeen(13, 13, 13));
		assertEquals(false,WarmUp.hasTeen(20, 20, 20));
		assertEquals(true,WarmUp.hasTeen(13, 20, 10));
		assertEquals(true,WarmUp.hasTeen(10, 20, 13));
	}
	
	@Test
	public void warmUp8(){
		assertEquals(true,WarmUp.mixStart("mix snack"));
		assertEquals(true,WarmUp.mixStart("pix"));
		assertEquals(false,WarmUp.mixStart("miz"));
	}
	
	@Test
	public void WarmUp8(){
		assertEquals(8,WarmUp.close10(8, 13));
		assertEquals(8,WarmUp.close10(13, 8));
		assertEquals(0,WarmUp.close10(13, 7));

	}
}
