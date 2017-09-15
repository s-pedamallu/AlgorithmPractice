package bst;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

import iterators.BSTIterator.TreeNode;
import testhelper.TestTreeHelper;

public class LargestSmallerNumberTest {

	private LargestSmallerNumber src;
	private TreeNode testBst;
	
	@Before
	public void init() {
		src = new LargestSmallerNumber();
		Integer[] arr = {20, 9, 25, 5, 12, null, null, null, null, 11, 14};
		testBst = TestTreeHelper.buildTreeFromArray(arr);
	}

	@Test
	public void test1() {
		assertEquals(14, src.getLargestSmallerNumber(testBst, 17));
	}

	@Test
	public void test2() {
		assertEquals(9, src.getLargestSmallerNumber(testBst, 10));
	}

	@Test
	public void test3() {
		assertEquals(5, src.getLargestSmallerNumber(testBst, 9));
	}

	@Test
	public void test4() {
		assertEquals(12, src.getLargestSmallerNumber(testBst, 13));
	}

	@Test
	public void test5() {
		assertEquals(-1, src.getLargestSmallerNumber(testBst, 4));
	}

	@Test
	public void test6() {
		assertEquals(-1, src.getLargestSmallerNumber(testBst, 5));
	}
}
