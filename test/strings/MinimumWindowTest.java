package strings;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class MinimumWindowTest {
	private MinimumWindow src;

	@Before
	public void init() {
		src = new MinimumWindow();
	}

	@Test
	public void test1() {
		assertEquals("mber", src.minWindow("september", "mre"));
	}

	@Test
	public void test2() {
		assertEquals("september", src.minWindow("september", "mres"));
	}

	@Test
	public void test3() {
		assertEquals("BANC", src.minWindow("ADOBECODEBANC", "BANC"));
	}

	@Test
	public void test4() {
		assertEquals("a", src.minWindow("ab", "a"));
	}

	@Test
	public void test5() {
		assertEquals("cwae", src.minWindow("cabwefgewcwaefgcf", "cae"));
	}
}
