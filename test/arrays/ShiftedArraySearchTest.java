package arrays;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class ShiftedArraySearchTest {

	private ShiftedArraySearch src;

	@Before
	public void init() {
		src = new ShiftedArraySearch();
	}

	@Test
	public void test1() {
		int[] input = { 1, 2 };
		assertEquals(1, src.shiftedArrSearch(input, 2));
	}

	@Test
	public void test2() {
		int[] input = { 4, 5, 6, 7, 0, 1, 2 };
		assertEquals(1, src.shiftedArrSearch(input, 5));
	}
}
