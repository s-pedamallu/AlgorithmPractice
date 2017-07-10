package stacks;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MaxRectangleHistogramTest {

	@Test
	public void testcase1() {
		int[] arr = {0,1,2,4,3,2,3};
		MaxRectangleHistogram histogram = new MaxRectangleHistogram(arr);
		assertEquals(10, histogram.maxAreaRectangle());
	}

	@Test
	public void testcase2() {
		int[] arr = {1,2,4};
		MaxRectangleHistogram histogram = new MaxRectangleHistogram(arr);
		assertEquals(4, histogram.maxAreaRectangle());
	}

	@Test
	public void testcase3() {
		int[] arr = {2,1,2,3,1};
		MaxRectangleHistogram histogram = new MaxRectangleHistogram(arr);
		assertEquals(5, histogram.maxAreaRectangle());
	}
}
