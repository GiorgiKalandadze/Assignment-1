package assign1;

import java.util.*;
import java.util.Map.Entry;

public class Appearances {
	private static final Integer DEFAULT_VALUE = 1;
	/**
	 * Returns the number of elements that appear the same number
	 * of times in both collections. Static method. (see handout).
	 * @return number of same-appearance elements
	 */
	public Appearances() {
		
	}
	public static <T> int sameCount(Collection<T> a, Collection<T> b) {
		
		HashMap<T, Integer> h1 = new HashMap<T, Integer>();
		HashMap<T, Integer> h2 = new HashMap<T, Integer>();
		
		countElements(a, h1);
		countElements(b, h2);
		
		int result = 0;
		for (Entry<T, Integer> entry : h1.entrySet()) {
		    T key = entry.getKey();
		    Integer firstValue = entry.getValue();
		    Integer secondValue = h2.get(key);
		    if(firstValue == secondValue) result++;
		}
		return result; // TODO ADD CODE HERE
	}

	
	private static <T> void countElements(Collection<T> c, HashMap<T, Integer> hm) {
        Iterator<T> iterator = c.iterator();
        while (iterator.hasNext()) {
        	T elem = iterator.next();
       
        	if(hm.containsKey(elem)) {
        		Integer newValue = hm.get(elem) + 1;
        		hm.put(elem, newValue);
        	} else {
        		hm.put(elem, DEFAULT_VALUE);
        	}
        }
	}
	
}
