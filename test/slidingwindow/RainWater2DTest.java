package slidingwindow;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class RainWater2DTest {

	private RainWater2D obj;
	
	@Before
	public void setup() {
		obj = new RainWater2D();
	}
	
	@Test
	public void test1() {
		int[] arr = {1,8,6,2,5,4,8,3,7};
		assertEquals(19, obj.trap(arr));
	}
	
	@Test
	public void test2() {
		int[] arr = {1,1};
		assertEquals(0, obj.trap(arr));
	}
	
	@Test
	public void test3() {
		int[] arr = {4,2,0,3,2,5};
		assertEquals(9, obj.trap(arr));
	}

	@Test
	public void test4() {
		int[] arr = {0,1,0,2,1,0,1,3,2,1,2,1};
		assertEquals(6, obj.trap(arr));
	}
}
