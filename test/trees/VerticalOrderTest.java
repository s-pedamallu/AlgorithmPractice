package trees;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import iterators.BSTIterator.TreeNode;
import testhelper.TestLinkedListHelper;
import testhelper.TestTreeHelper;

public class VerticalOrderTest {
	private VerticalOrder src;

	@Before
	public void init() {
		src = new VerticalOrder();		
	}

	@Test
	public void test1() {
		Integer[] tree = {4,2,1,6,3,null,7,9,null,null,null,13};
		TreeNode testcase = TestTreeHelper.buildTreeFromArray(tree);
		List<List<Integer>> exp = new ArrayList<>();
		exp.add(Arrays.asList(9));
		exp.add(Arrays.asList(6));
		exp.add(Arrays.asList(2));
		exp.add(Arrays.asList(4,3));
		exp.add(Arrays.asList(1,13));
		exp.add(Arrays.asList(7));
		TestLinkedListHelper.validateListsInOrder(exp, src.verticalOrder(testcase));
	}

	@Test
	public void test2() {
		Integer[] tree = {3,9,20,null,null,15,7};
		TreeNode testcase = TestTreeHelper.buildTreeFromArray(tree);
		List<List<Integer>> exp = new ArrayList<>();
		exp.add(Arrays.asList(9));
		exp.add(Arrays.asList(3,15));
		exp.add(Arrays.asList(20));
		exp.add(Arrays.asList(7));
		TestLinkedListHelper.validateListsInOrder(exp, src.verticalOrder(testcase));
	}

	@Test
	public void test3() {
		Integer[] tree = {3,9,8,4,0,1,7,null,null,null,2,5};
		TreeNode testcase = TestTreeHelper.buildTreeFromArray(tree);
		List<List<Integer>> exp = new ArrayList<>();
		exp.add(Arrays.asList(4));
		exp.add(Arrays.asList(9,5));
		exp.add(Arrays.asList(3,0,1));
		exp.add(Arrays.asList(8,2));
		exp.add(Arrays.asList(7));
		TestLinkedListHelper.validateListsInOrder(exp, src.verticalOrder(testcase));
	}
}
