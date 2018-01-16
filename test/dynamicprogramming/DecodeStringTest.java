package dynamicprogramming;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class DecodeStringTest {
	private DecodeString src;

	@Before
	public void setup() {
		src = new DecodeString();
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
}
