package test.java.projectEuler;

import static org.junit.Assert.*;

import org.junit.Test;

import main.java.projectEuler.CountingSunday;
import main.java.projectEuler.CountingSunday.Day;
import main.java.projectEuler.CountingSunday.Month;



public class CountingSundayTest {
	
	@Test
	public void isLeapYear(){
		assertEquals(false,CountingSunday.isLeapYear(1000));
		assertEquals(true,CountingSunday.isLeapYear(1200));
		assertEquals(false,CountingSunday.isLeapYear(10));
		assertEquals(true,CountingSunday.isLeapYear(20));
	}
	
	@Test
	public void isCenturyAnd400Mul(){
		assertEquals(false,CountingSunday.isCenturyAnd400Mul(1000));
		assertEquals(true,CountingSunday.isCenturyAnd400Mul(1200));
	}
	
	@Test
	public void firstDayNextMonth(){
		assertEquals(Day.MONDAY,CountingSunday.firstDayNextMonth(Day.MONDAY,Month.February));
		assertEquals(Day.THURSDAY,CountingSunday.firstDayNextMonth(Day.MONDAY,Month.January));
		assertEquals(Day.SATURDAY,CountingSunday.firstDayNextMonth(Day.WEDNESDAY,Month.January));
	}
	
	@Test
	public void monthStartedWithSundayinYear(){
		Day startDay = Day.MONDAY;
		System.out.println(CountingSunday.monthStartedWithSundayinYear(startDay,false) + "," + startDay);
	}
	
}
