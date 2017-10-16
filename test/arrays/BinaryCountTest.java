package arrays;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class BinaryCountTest {

	private BinaryCount src;
	
	@Before
	public void init() {
		src = new BinaryCount();
	}

	@Test
	public void test1() {
		assertEquals(6, src.countBinarySubstrings("00110011"));
	}

	@Test
	public void test2() {
		assertEquals(4, src.countBinarySubstrings("10101"));
	}

	@Test
	public void test3() {
		assertEquals(3, src.countBinarySubstrings("00110"));
	}

	@Test
	public void test4() {
		assertEquals(2, src.countBinarySubstrings("00100"));
	}
}
