/*
 HW1 Taboo problem class.
 Taboo encapsulates some rules about what objects
 may not follow other objects.
 (See handout).
*/
package assign1;

import java.util.*;

public class Taboo<T> {
	private HashMap<T, Set<T>> map;
	/**
	 * Constructs a new Taboo using the given rules (see handout.)
	 * @param rules rules for new Taboo
	 */
	public Taboo(List<T> rules) {
		map = new HashMap<T, Set<T>>();
		//Itereate over rules list
		for(int i = 0; i < rules.size() - 1; i++) {
			T currentElem = rules.get(i);
			if(map.containsKey(currentElem)) {
				Set<T> tmp = map.get(currentElem);
				tmp.add(rules.get(i + 1));
				map.put(currentElem, tmp);
			} else {
				Set<T> tmp = new HashSet<T>();
				tmp.add(rules.get(i + 1));
				map.put(currentElem, tmp);
			}
		}
		
		//Last elem
		Set<T> tmp = new HashSet<T>();
		map.put(rules.get(rules.size() - 1), tmp);
	}
	
	/**
	 * Returns the set of elements which should not follow
	 * the given element.
	 * @param elem
	 * @return elements which should not follow the given element
	 */
	public Set<T> noFollow(T elem) {
		Set<T> s= map.get(elem);
		return s; // TODO YOUR CODE HERE
	}
	
	/**
	 * Removes elements from the given list that
	 * violate the rules (see handout).
	 * @param list collection to reduce
	 */
	public void reduce(List<T> list) {
		for(int i = 0; i < list.size() - 1; i++) {
			T currentElem = list.get(i);
			T next = list.get(i + 1);
			if(map.get(currentElem).contains(next)) {
				list.remove(i + 1);
				i--;
			}
		}		
	}
}
