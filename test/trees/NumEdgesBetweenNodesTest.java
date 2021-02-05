package trees;

import org.junit.Before;
import org.junit.Test;

import iterators.BSTIterator.TreeNode;
import testhelper.TestTreeHelper;

import org.junit.Assert;

public class NumEdgesBetweenNodesTest {
	private NumEdgesBetweenNodes obj;

	@Before
	public void init() {
		obj = new NumEdgesBetweenNodes();
	}

	@Test
	public void test1() {
		Integer[] bst = {3,5,1,6,2,0,8,null,null,7,4};
		TreeNode root = TestTreeHelper.buildTreeFromArray(bst);
		Assert.assertEquals(3, obj.findDistance(root, 5, 0));
	}
	
	@Test
	public void test2() {
		Integer[] bst = {3,5,1,6,2,0,8,null,null,7,4};
		TreeNode root = TestTreeHelper.buildTreeFromArray(bst);
		Assert.assertEquals(2, obj.findDistance(root, 5, 4));
	}

	@Test
	public void test3() {
		Integer[] bst = {3,5,1,6,2,0,8,null,null,7,4};
		TreeNode root = TestTreeHelper.buildTreeFromArray(bst);
		Assert.assertEquals(4, obj.findDistance(root, 6, 8));
	}

	@Test
	public void test4() {
		Integer[] bst = {3,5,1,6,2,0,8,null,null,7,4};
		TreeNode root = TestTreeHelper.buildTreeFromArray(bst);
		Assert.assertEquals(3, obj.findDistance(root, 6, 7));
	}

	@Test
	public void test5() {
		Integer[] bst = {1,2,null,null,3,4,null,5,null,6,null,null,7,null,20,8,null,10,null,9,null,11,null,12,null,13};
		TreeNode root = TestTreeHelper.buildTreeFromArray(bst);
		Assert.assertEquals(2, obj.findDistance(root, 20, 10));
	}
}