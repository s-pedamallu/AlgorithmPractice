package iterators;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import iterators.BSTIterator.TreeNode;

import testhelper.TestTreeHelper;
public class BSTIteratorTest {

	@Test
	public void test1() {
		Integer[] arr = { 10, 4, null, 1, 7, null, 3, 6, 8, 2, null, 5, null, null, 9 };
		TreeNode testCase = TestTreeHelper.buildTreeFromArray(arr);
		BSTIterator src = new BSTIterator(testCase);
		int[] expected = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		List<Integer> actual = new ArrayList<>();
		while (src.hasNext()) {
			assertTrue(src.hasNext());
			actual.add(src.next());
		}
		assertAnswer(expected, actual);
	}

	@Test
	public void test2() {
		Integer[] arr = { 4 };
		TreeNode testCase = TestTreeHelper.buildTreeFromArray(arr);
		BSTIterator src = new BSTIterator(testCase);
		int[] expected = { 4 };
		List<Integer> actual = new ArrayList<>();
		while (src.hasNext()) {
			actual.add(src.next());
		}
		assertAnswer(expected, actual);
	}

	@Test
	public void test3() {
		Integer[] arr = { 3, 1, 4 };
		TreeNode testCase = TestTreeHelper.buildTreeFromArray(arr);
		BSTIterator src = new BSTIterator(testCase);
		int[] expected = { 1, 3, 4 };
		List<Integer> actual = new ArrayList<>();
		while (src.hasNext()) {
			actual.add(src.next());
		}
		assertAnswer(expected, actual);
	}

	@Test
	public void test4() {
		Integer[] arr = { 10, 4, null, 1, 7, null, 3, 6, 8, 2, null, 5, null, null, 9 };
		TreeNode testCase = TestTreeHelper.buildTreeFromArray(arr);
		BSTIterator src = new BSTIterator(testCase);
		int[] expected = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		int count = 0;
		while (count < 10) {
			int got = src.next();
			assertEquals("Expected " + expected[count] + " at position " + count + " but found " + got, expected[count],
					got);
			count++;
		}
		assertFalse(src.hasNext());
	}

	private void assertAnswer(int[] expected, List<Integer> actual) {
		assertEquals("Expected " + expected.length + " result but found result of size " + actual.size(),
				expected.length, actual.size());
		for (int i = 0; i < actual.size(); i++) {
			assertEquals("Expected " + expected[i] + " at position " + i + " but found " + actual.get(i), expected[i],
					actual.get(i).intValue());
		}
	}

}
