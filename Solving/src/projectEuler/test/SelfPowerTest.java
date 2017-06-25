package projectEuler.test;

import static org.junit.Assert.*;

import org.junit.Test;

import projectEuler.implementation.SelfPower;

public class SelfPowerTest {

	@Test
	public void selfPower(){
		assertEquals("1",SelfPower.selfPower(1));
		assertEquals("4",SelfPower.selfPower(2));
		assertEquals("27",SelfPower.selfPower(3));
	}
	
	@Test
	public void selfPowerSerie(){
		assertEquals("10405071317",SelfPower.selfPowerSerie(10));
		String result = SelfPower.selfPowerSerie(1000);
		System.out.println(result.substring(result.length() - 10));
	}
}
