// TabooTest.java
// Taboo class tests -- nothing provided.
package assign1;

import static org.junit.Assert.*;

import org.junit.Test;
import java.util.*;
public class TabooTest {
	@Test
	public void testnoFollow1() {
		Taboo<String> t = new Taboo<String>( Arrays.asList("a", "c", "a", "b"));
		// basic List<Integer> cases
		Set<String> res1 = new HashSet<String>(); 
		res1.add("c");
		res1.add("b");
		assertEquals(res1, t.noFollow("a"));
		
		Set<String> res2 = new HashSet<String>(); 
		res2.add("a");
		assertEquals(res2, t.noFollow("c"));
		
		Set<String> res3 = new HashSet<String>(); 
		assertEquals(res3, t.noFollow("b"));		
	}
	
	@Test
	public void testReduce1() {
		Taboo<String> t = new Taboo<String>( Arrays.asList("a", "c", "a", "b"));
		List<String> ls = new ArrayList<String>();
		ls.addAll(Arrays.asList("a", "a", "b", "c", "c"));
		
		List<String> res = new ArrayList<String>();
		res.addAll(Arrays.asList("a", "a"));
		t.reduce(ls);
		assertEquals(res, ls);
	}
	
	// TODO ADD TESTS
}
