package test.java.algorithms.greedy;

import java.util.List;

import org.junit.Test;

import main.java.algorithms.greedy.ActivitySelection;

public class ActivitySelectionTest {

	@Test
	public void test(){
		List<Integer> result = ActivitySelection.recursiveActivitySelector(0, 12);
		for(int e : result){
			System.out.println(e);
		}
	}
	
	@Test
	public void testIter(){
		List<Integer> result = ActivitySelection.GreedyActivitySelector(12);
		for(int e : result){
			System.out.println(e);
		}
	}
}
