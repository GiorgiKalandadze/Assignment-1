// StringCodeTest
// Some test code is provided for the early HW1 problems,
// and much is left for you to add.

package assign1;

import static org.junit.Assert.*;
import org.junit.Test;

public class StringCodeTest {
	
	//
	// blowup
	//
	@Test
	public void testBlowup1() {
		StringCode code = new StringCode();
		// basic cases
		assertEquals("xxaaaabb", StringCode.blowup("xx3abb"));
		assertEquals("xxxZZZZ", StringCode.blowup("2x3Z"));
		assertEquals("attttxzzz", StringCode.blowup("a3tx2z"));
	}
	
	@Test
	public void testBlowup2() {
		// things with digits
		
		// digit at end
		assertEquals("axxx", StringCode.blowup("a2x3"));
		assertEquals("", StringCode.blowup("3"));
		assertEquals("a", StringCode.blowup("a3"));
		assertEquals("ab", StringCode.blowup("ab3"));
		
		// digits next to each other
		assertEquals("a3331111", StringCode.blowup("a231"));
		assertEquals("22", StringCode.blowup("12"));
		assertEquals("a22", StringCode.blowup("a12"));
		assertEquals("4444aaaaa", StringCode.blowup("34a"));
		
		// try a 0
		assertEquals("aabb", StringCode.blowup("aa0bb"));
		assertEquals("ab", StringCode.blowup("0ab"));
		assertEquals("ab", StringCode.blowup("ab0"));
		assertEquals("ab", StringCode.blowup("a0b"));
	}
	
	@Test
	public void testBlowup3() {
		// weird chars, empty string
		assertEquals("AB&&,- ab", StringCode.blowup("AB&&,- ab"));
		assertEquals("", StringCode.blowup(""));
		assertEquals("%%%%", StringCode.blowup("3%"));
		
		// string with only digits
		assertEquals("", StringCode.blowup("2"));
		assertEquals("333", StringCode.blowup("23"));
	}
	
	
	//
	// maxRun
	//
	@Test
	public void testRun1() {
		assertEquals(2, StringCode.maxRun("hoopla"));
		assertEquals(3, StringCode.maxRun("hoopllla"));
		assertEquals(1, StringCode.maxRun("a"));
		assertEquals(2, StringCode.maxRun("aa"));
		assertEquals(3, StringCode.maxRun("aaa"));
	}
	
	@Test
	public void testRun2() {
		assertEquals(3, StringCode.maxRun("abbcccddbbbxx"));
		//assertEquals(0, StringCode.maxRun(""));
		assertEquals(3, StringCode.maxRun("hhhooppoo"));
		assertEquals(3, StringCode.maxRun("aaabccc"));
		assertEquals(4, StringCode.maxRun("aaabcccc"));
	}
	
	@Test
	public void testRun3() {
		// "evolve" technique -- make a series of test cases
		// where each is change from the one above.
		assertEquals(1, StringCode.maxRun("123"));
		assertEquals(2, StringCode.maxRun("1223"));
		assertEquals(2, StringCode.maxRun("112233"));
		assertEquals(3, StringCode.maxRun("1112233"));
	}

	// TODO Need test cases for stringIntersect
	@Test
	public void testIntersect1() {
		assertEquals(true, StringCode.stringIntersect("giorgi", "gio", 2));
		assertEquals(true, StringCode.stringIntersect("giorgi", "gio", 3));
		assertEquals(false, StringCode.stringIntersect("giorgi", "gio", 4));
		assertEquals(false, StringCode.stringIntersect("", "", 2));
		assertEquals(true, StringCode.stringIntersect("", "", 0));
		assertEquals(true, StringCode.stringIntersect("gio", "giorgi", 2));
		assertEquals(false, StringCode.stringIntersect("gio", "aba", 2));
	}
	
}
