package trees;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import iterators.BSTIterator.TreeNode;
import testhelper.TestTreeHelper;

public class MirrorBinaryTreeTest {

	private MirrorBinaryTree src;
	
	@Before
	public void setup() {
		src = new MirrorBinaryTree();
	}

	@Test
	public void test1() {
		Integer[] srcArr = {1,2,3,4,5,6,7};
		Integer[] expArr = {1,3,2,7,6,5,4};
		TreeNode srcTree = TestTreeHelper.buildTreeFromArray(srcArr);
		TreeNode act = src.getMirrorTree(srcTree);
		Integer[] actArr = TestTreeHelper.buildArrayFromTree(act);
		Assert.assertArrayEquals(expArr, actArr);
	}
}
