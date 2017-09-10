package trees;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import iterators.BSTIterator.TreeNode;
import testhelper.TestTreeHelper;

public class LeavesListTest {
	private LeavesList src;
	@Before
	public void init() {
		this.src = new LeavesList();
	}

	@Test
	public void test1() {
		Integer[] arr = { 10, 4, null, 1, 7, null, 3, 6, 8, 2, null, 5, null, null, 9 };
		TreeNode testCase = TestTreeHelper.buildTreeFromArray(arr);
		List<List<Integer>> expected = new ArrayList<>();
		expected.add(Arrays.asList(2,5,9));
		expected.add(Arrays.asList(3,6,8));
		expected.add(Arrays.asList(1,7));
		expected.add(Arrays.asList(4));
		expected.add(Arrays.asList(10));
		validateAnswer(expected, src.findLeaves(testCase));
	}

	@Test
	public void test2() {
		Integer[] arr = { 1, 2, 3, 4, 5 };
		TreeNode testCase = TestTreeHelper.buildTreeFromArray(arr);
		List<List<Integer>> expected = new ArrayList<>();
		expected.add(Arrays.asList(4,5,3));
		expected.add(Arrays.asList(2));
		expected.add(Arrays.asList(1));
		validateAnswer(expected, src.findLeaves(testCase));
	}

	private void validateAnswer(List<List<Integer>> e, List<List<Integer>> a) {
		if(e.isEmpty()) {
			assertTrue(a.isEmpty());
		} else {
			Iterator<List<Integer>> eitr = e.iterator();
			Iterator<List<Integer>> aitr = a.iterator();
			while(eitr.hasNext()) {
				assertTrue(aitr.hasNext());
				List<Integer> el = eitr.next();
				List<Integer> al = aitr.next();
				assertEquals(el.size(), al.size());
				for(int i=0; i<el.size(); i++) {
					assertEquals(el.get(i), al.get(i));
				}
			}
		}
	}
}
