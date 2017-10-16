package arrays;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class ArrayDegreeTest {

	private ArrayDegree src;
	
	@Before
	public void init() {
		src = new ArrayDegree();
	}

	@Test
	public void test1() {
		int[] arr = {1, 2, 2, 3, 1};
		assertEquals(2, src.findShortestSubArray(arr));
	}

	@Test
	public void test2() {
		int[] arr = {1,2,2,3,1,4,2};
		assertEquals(6, src.findShortestSubArray(arr));
	}
}
