package hackerrank.w34;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MaxGcdAndSumTest {
	private MaxGcdAndSum src;

	@Before
	public void setup() {
		src = new MaxGcdAndSum();
	}

	@Test
	public void test0() {
		int[] a = {3, 1, 4, 2, 8};
		int[] b = {5, 2, 12, 8, 3};
		Assert.assertEquals(16, src.maximumGcdAndSum(a, b));
	}

	@Test
	public void test1() {
		int[] a = {4, 6, 12};
		int[] b = {7, 8, 24};
		Assert.assertEquals(36, src.maximumGcdAndSum(a, b));
	}

	@Test
	public void test2() {
		int[] a = {4, 6, 12};
		int[] b = {7, 8, 6};
		Assert.assertEquals(18, src.maximumGcdAndSum(a, b));
	}

	@Test
	public void test3() {
		int[] a = {3, 5, 2};
		int[] b = {4, 14, 7};
		Assert.assertEquals(18, src.maximumGcdAndSum(a, b));
	}
}
