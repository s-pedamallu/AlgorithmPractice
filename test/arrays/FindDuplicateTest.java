package arrays;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class FindDuplicateTest {

	private FindDuplicate src;
	
	@Before
	public void init() {
		src = new FindDuplicate();
	}

	@Test
	public void test1() {
		int[] arr = {1,2,3,4,4};
		assertEquals(4, src.findDuplicate(arr));
	}

	@Test
	public void test2() {
		int[] arr = {1,3,4,2,2};
		assertEquals(2, src.findDuplicate(arr));
	}
}
