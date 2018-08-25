package math;

import java.math.BigInteger;
import java.security.InvalidParameterException;
import java.util.List;

public class Statistic {

	/**
	 * Calculate the number of permutation of n element with repetition 
	 * @param n, number of element
	 * @param types, list containing the number of object per type
	 * @return
	 */
	public static long permutationWithRepeat(int n, List<Integer> types){
		int sumCheck = 0;
		for(int type : types){
			sumCheck = sumCheck + type;
		}
		if(n == sumCheck){
			BigInteger permMultType = BigInteger.valueOf(1);
			for(int type : types){
				permMultType = permMultType.multiply(Math.factorial(type)) ;
			}
			return Math.factorial(n).divide(permMultType).longValue();
		} else 
			throw new InvalidParameterException(); 
	}
}
