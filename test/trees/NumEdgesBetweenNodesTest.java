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
}