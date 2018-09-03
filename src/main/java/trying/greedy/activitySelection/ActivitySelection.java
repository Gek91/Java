package main.java.trying.greedy.activitySelection;

import java.util.ArrayList;
import java.util.List;

/**
 * Scheduling competing activities that require exclusive use of common resource. Goal of selecting the maximum
 * size of mutually compatible activities
 * @author Giacomo Pandini
 *
 */
public class ActivitySelection {

	//Mapactivites (start-end)
		private static final Pair[] activites;
		
		static{
			activites = new Pair[12];
			activites[0] = new Pair(0, 0);
			activites[1] = new Pair(1, 4);
			activites[2] = new Pair(3, 5);
			activites[3] = new Pair(0, 6);
			activites[4] = new Pair(5, 7);
			activites[5] = new Pair(3, 9);
			activites[6] = new Pair(5, 9);
			activites[7] = new Pair(6, 10);
			activites[8] = new Pair(8, 11);
			activites[9] = new Pair(8, 12);
			activites[10] = new Pair(2, 14);
			activites[11] = new Pair(12, 16);
		}
		
		/**
		 * Recursive solution of activity selector
		 * @param k
		 * @param n
		 * @return
		 */
		public static List<Integer> recursiveActivitySelector(int k, int n){
			List<Integer> result = new ArrayList<Integer>();
			int m = k+1;
			while( m < n && activites[m].getS() < activites[k].getF()){
				m = m+1;
			}
			if( m < n){
				result.add(m);
				result.addAll(recursiveActivitySelector(m,n));
			}
			return result;
		}
		
		public static List<Integer> GreedyActivitySelector(int n){
			List<Integer> result = new ArrayList<Integer>();
			result.add(1);
			int k = 1;
			for(int m = 2 ; m<n ; m++){
				if(activites[m].getS() >= activites[k].getF()){
					result.add(m);
					k = m;
				}
			}
			return result;
		}
}

class Pair{
	int s;
	int f;
	
	public Pair(int s, int f){
		this.s = s;
		this.f = f;
	}
	
	public int getS(){ return this.s; }
	public int getF(){ return this.f; }
	public void setS(int s){ this.s = s; }
	public void setF(int f){ this.f = f; }
}
