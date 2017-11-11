package dfs;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class CharOrderTest {
	private CharOrder src;
	
	@Before
	public void init() {
		src = new CharOrder();
	}

	@Test
	public void test1() {
		String[] words = {"wrt", "wrf", "er", "ett", "rftt"};
		assertEquals("wertf", src.alienOrder(words));
	}

	@Test
	public void test2() {
		String[] words = { "z", "x" };
		assertEquals("zx", src.alienOrder(words));
	}

	@Test
	public void test3() {
		String[] words = { "z", "x", "z" };
		assertEquals("", src.alienOrder(words));
	}

	@Test
	public void test4() {
		String[] words = { "wrt", "wrf", "et", "etf", "etb" };
		assertEquals("rtfbwe", src.alienOrder(words));
	}

	@Test
	public void test5() {
		String[] words = { "wnlb" };
		assertEquals("blnw", src.alienOrder(words));
	}
}
