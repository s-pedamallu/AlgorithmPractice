package bitmanipulation;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

public class MaxXorTwoElemsInArrayTest {
	private MaxXorTwoElemsInArray src;

	@Before
	public void init() {
		src = new MaxXorTwoElemsInArray();
	}

	@Test
	public void test1() {
		int[] arr = { 11, 14, 10, 15 };
		assertEquals(5, src.findMaximumXOR(arr));
	}

	@Test
	public void test2() {
		int[] arr = { 11, 14, 7, 2 };
		assertEquals(12, src.findMaximumXOR(arr));
	}

	@Test
	public void test3() {
		int[] arr = { 3, 10, 5, 25, 2, 8 };
		assertEquals(28, src.findMaximumXOR(arr));
	}
}