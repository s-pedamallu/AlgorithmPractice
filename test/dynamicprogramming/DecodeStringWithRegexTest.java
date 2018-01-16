package dynamicprogramming;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class DecodeStringWithRegexTest {
	private DecodeStringWithRegex src;

	@Before
	public void setup() {
		src = new DecodeStringWithRegex();
	}

	@Test
	public void test1() {
		String input = "121";
		assertEquals(3, src.numDecodings(input));
	}

	@Test
	public void test2() {
		String input = "";
		assertEquals(0, src.numDecodings(input));
	}

	@Test
	public void test3() {
		String input = "0";
		assertEquals(0, src.numDecodings(input));
	}

	@Test
	public void test4() {
		String input = "01";
		assertEquals(0, src.numDecodings(input));
	}

	@Test
	public void test5() {
		String input = "128";
		assertEquals(2, src.numDecodings(input));
	}

	@Test
	public void test6() {
		String input = "1*";
		assertEquals(18, src.numDecodings(input));
	}

	@Test
	public void test7() {
		String input = "*";
		assertEquals(9, src.numDecodings(input));
	}

	@Test
	public void test8() {
		String input = "3*";
		assertEquals(9, src.numDecodings(input));
	}

	@Test
	public void test9() {
		String input = "**";
		assertEquals(96, src.numDecodings(input));
	}

	@Test
	public void test10() {
		String input = "*3";
		assertEquals(11, src.numDecodings(input));
	}

	@Test
	public void test11() {
		String input = "*8";
		assertEquals(10, src.numDecodings(input));
	}

	@Test
	public void test12() {
		String input = "**********";
		assertEquals(483456820, src.numDecodings(input));
	}
}
