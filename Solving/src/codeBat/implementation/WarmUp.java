package codeBat.implementation;

public class WarmUp {
	/**
	 *	The parameter weekday is true if it is a weekday, 
	 *	and the parameter vacation is true if we are on vacation. 
	 *	We sleep in if it is not a weekday or we're on vacation
	 */
	public static boolean sleepIn(boolean weekday, boolean vacation){
		return !weekday || vacation;
	}
	
	/**
	 * Given an int n, return the absolute difference between n and 21,
	 * except return double the absolute difference if n is over 21.
	 */
	public static int diff21(int n){
		int result = 21 - n;
		if(result > 0)
			return result;
		return Math.abs(result * 2);
	}
	
	/**
	 * Given an int n, return true if it is within 10 of 100 or 200.
	 *  Note: Math.abs(num) computes the absolute value of a number.
	 */
	public static boolean nearHundred(int n){
		return (Math.abs(100 - n) < 11) || (Math.abs(200 - n) < 11) ? true : false ;
	}
	
	/**
	 * Given a non-empty string and an int n, 
	 * return a new string where the char at index n has been removed. 
	 * The value of n will be a valid index of a char in the original string 
	 * (i.e. n will be in the range 0..str.length()-1 inclusive).
	 */
	public static String missingChar(String str, int n){
		return str.substring(0, n) + str.substring(n+1);
	}
	
	/**
	 * Given a string, take the last char and return a new string with the last char added at the front and back, 
	 * so "cat" yields "tcatt". The original string will be length 1 or more.
	 */
	public static String backAround( String str){
		char lastChar = str.charAt(str.length()-1);
		return lastChar + str + lastChar;
	}
	
	/**
	 * Given a string, return true if the string starts with "hi" and false otherwise.
	 */
	public static boolean starHi(String str){
		if(str.length() > 1)
			return str.substring(0, 2).equals("hi");
		return false;
	}
	
	/**
	 *  We'll say that a number is "teen" if it is in the range 13..19 inclusive. 
	 *  Given 3 int values, return true if 1 or more of them are teen.
	 */
	public static boolean hasTeen(int a, int b, int c){
		if( a>12 && a<20 )
			return true;
		if( b>12 && b<20 )
			return true;
		if( c>12 && c<20 )
			return true;
		return false;
	}
	
	/** 
	 * Return true if the given string begins with "mix", except the 'm' can be anything, so "pix", "9ix" .. all count.
	 */
	public static boolean mixStart(String str) {
		return str.matches("^.ix.*");
	}
	
	/**
	 * Given 2 int values, return whichever value is nearest to the value 10, or return 0 in the event of a tie. 
	 * Note that Math.abs(n) returns the absolute value of a number.
	 */
	public static int close10(int a, int b){
		 int diffA = Math.abs(10 - a);
		 int diffB = Math.abs(10 - b);
		if( diffA < diffB ){
			return a;
		} else if (diffA != diffB){
			return b;
		}
		return 0;
	}
	
	
}
