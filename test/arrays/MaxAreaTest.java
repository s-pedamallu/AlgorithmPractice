package arrays;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class MaxAreaTest {

	private MaxArea obj;
	
	@Before
	public void setup() {
		obj = new MaxArea();
	}
	
	@Test
	public void test1() {
		int[] arr = {1,8,6,2,5,4,8,3,7};
		assertEquals(49, obj.maxArea(arr));
	}
	
	@Test
	public void test2() {
		int[] arr = {1,1};
		assertEquals(1, obj.maxArea(arr));
	}
	
	@Test
	public void test3() {
		int[] arr = {4,3,2,1,4};
		assertEquals(16, obj.maxArea(arr));
	}
	
	@Test
	public void test4() {
		int[] arr = {1,2,1};
		assertEquals(2, obj.maxArea(arr));
	}

	@Test
	public void test5() {
		int[] arr = {1,2,3,4,5,6,7};
		assertEquals(12, obj.maxArea(arr));
	}

	@Test
	public void test6() {
		int[] arr = {7,6,5,4,3,2,1};
		assertEquals(12, obj.maxArea(arr));
	}
	
	@Test
	public void test7() {
		int[] arr = {3,1,3,1,1,1,1,1,1,1,1};
		assertEquals(10, obj.maxArea(arr));
	}
}
