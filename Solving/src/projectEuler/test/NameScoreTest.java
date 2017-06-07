package projectEuler.test;

import org.junit.Test;

import projectEuler.implementation.NameScore;

public class NameScoreTest {

	@Test
	public void sumAlfabeticNameValue(){
		System.out.println(NameScore.sumAlfabeticNameValue("COLIN"));
	}
	
	@Test
	public void nameValue(){
		System.out.println(NameScore.nameValue("AB",0));
	}
	
	@Test
	public void nameScore(){
		System.out.println(NameScore.nameScore());
	}
}
