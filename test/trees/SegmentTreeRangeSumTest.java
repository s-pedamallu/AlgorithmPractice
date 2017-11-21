package trees;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class SegmentTreeRangeSumTest {
	private SegmentTreeRangeSum src;

	@Test
	public void test1() {
		int[] input = { 1, 3, 5 };
		src = new SegmentTreeRangeSum(input);
		assertEquals(9, src.sumRange(0, 2));
		assertEquals(8, src.sumRange(1, 2));
		assertEquals(4, src.sumRange(0, 1));
		assertEquals(5, src.sumRange(2, 2));
	}

	@Test
	public void test2() {
		int[] input = { 1, 3, 5 };
		src = new SegmentTreeRangeSum(input);
		assertEquals(9, src.sumRange(0, 2));
		src.update(1, 2);
		assertEquals(8, src.sumRange(0, 2));
	}

}
