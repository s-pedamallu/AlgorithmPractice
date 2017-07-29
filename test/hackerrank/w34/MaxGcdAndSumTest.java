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
		Assert.assertEquals(16, src.maximumGcdAndSum(a, b));
	}

	@Test
	public void test4() {
		int[] a = {5, 1, 2, 9};
		int[] b = {16, 15, 6, 12};
		Assert.assertEquals(20, src.maximumGcdAndSum(a, b));
	}

	@Test
	public void test5() {
		int[] a = {18, 6, 10, 17, 13};
		int[] b = {5, 12, 27, 26, 19};
		Assert.assertEquals(39, src.maximumGcdAndSum(a, b));
	}

	@Test
	public void test6() {
		int[] a = {4, 21, 8, 13};
		int[] b = {18, 25, 22, 19};
		Assert.assertEquals(39, src.maximumGcdAndSum(a, b));
	}

	@Test
	public void test7() {
		int[] a = {180, 153, 3, 141, 325, 105, 160, 109, 279, 295, 293, 187};
		int[] b = {373, 102, 48, 161, 145, 262, 118, 91, 71, 155, 163, 31};
		Assert.assertEquals(413, src.maximumGcdAndSum(a, b));
	}

	@Test
	public void test8() {
		int[] a = {2, 7, 25, 26, 8, 2, 25, 18, 10, 5};
		int[] b = {373, 102, 48, 161, 145, 262, 118, 91, 71, 155, 163, 31};
		Assert.assertEquals(117, src.maximumGcdAndSum(a, b));
	}

}
