package trees;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class SegmentTreeRangeMinimumTest {
	private SegmentTreeRangeMinimum src;

	@Test
	public void test1() {
		int[] input = { 2, 1, 9, -8, 6, 4, 0 };
		src = new SegmentTreeRangeMinimum(input);
		assertEquals(1, src.getMin(0, 2));
		assertEquals(-8, src.getMin(1, 6));
		assertEquals(0, src.getMin(4, 6));
		assertEquals(4, src.getMin(4, 5));
		assertEquals(2, src.getMin(0, 0));
	}
}
