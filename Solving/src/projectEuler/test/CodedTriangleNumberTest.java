package projectEuler.test;

import static org.junit.Assert.*;

import java.util.Set;

import org.junit.Test;

import projectEuler.implementation.CodedTriangleNumber;

public class CodedTriangleNumberTest {

	
	@Test
	public void triangleNumber(){
		assertEquals(1,CodedTriangleNumber.triangleNumbers(1));
		assertEquals(3,CodedTriangleNumber.triangleNumbers(2));
		assertEquals(6,CodedTriangleNumber.triangleNumbers(3));
		assertEquals(10,CodedTriangleNumber.triangleNumbers(4));
	}
	
	@Test
	public void stringValue(){
		assertEquals(55,CodedTriangleNumber.stringValue("SKY"));
	}
	
	@Test
	public void generateTriangleNumbeSequence(){
		Set<Integer> result = CodedTriangleNumber.generateTriangleNumberSequence(10);
		assertEquals(true,result.contains(10));
		assertEquals(false,result.contains(9));
	}
	
	@Test
	public void getresult(){
		System.out.println(CodedTriangleNumber.wordWithTriangleNumberValue());
	}
}
