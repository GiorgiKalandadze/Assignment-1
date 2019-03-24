package assign1;

import java.util.HashSet;
import java.util.Set;

import sun.security.x509.IssuingDistributionPointExtension;
 
// CS108 HW1 -- String static methods

public class StringCode {
	public StringCode() {
		
	}
	/**
	 * Given a string, returns the length of the largest run.
	 * A a run is a series of adajcent chars that are the same.
	 * @param str
	 * @return max run length
	 */
	public static int maxRun(String str) {
		int current = 1;
		int max = current;
		for(int i = 0; i < str.length() - 1; i++) {
			if(str.charAt(i) == str.charAt(i + 1)) {
				current++;
			} else {
				current = 1;
			}
			if(current > max) { //Update maximum run
				max = current;
			}
		}
		return max; // TODO ADD YOUR CODE HERE
	}

	
	/**
	 * Given a string, for each digit in the original string,
	 * replaces the digit with that many occurrences of the character
	 * following. So the string "a3tx2z" yields "attttxzzz".
	 * @param str
	 * @return blown up string
	 */
	public static String blowup(String str) {
		String result = "";
		if(str.length() > 0 && Character.isLetter(str.charAt(0))) {
			result += str.charAt(0);
		} 
		
		for(int i = 1; i < str.length(); i++) {
			char currentChar = str.charAt(i);
			if(Character.isDigit(str.charAt(i - 1))) {
				for(int j = 0; j <= (str.charAt(i - 1) - '0'); j++) {
					result += currentChar;
				}	
			} else if(!Character.isDigit(currentChar)){
				result += currentChar;
			}
		}
		return result; // TODO ADD YOUR CODE HERE
	}
	
	/**
	 * Given 2 strings, consider all the substrings within them
	 * of length len. Returns true if there are any such substrings
	 * which appear in both strings.
	 * Compute this in linear time using a HashSet. Len will be 1 or more.
	 */
	public static boolean stringIntersect(String a, String b, int len) {
		if(len == 0) return true;
		
		HashSet<String> hs1 = new HashSet<String>();
		
		for(int i = 0; i < a.length() - len; i++) {
			hs1.add(a.substring(i, i + len));
		}
		
		for(int j = 0; j <= b.length() - len; j++) {
			String current = b.substring(j, j + len);
			if(hs1.contains(current)) return true;
		}
		
		return false; // TO DO ADD YOUR CODE HERE
	}
}
