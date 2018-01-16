package trees;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import iterators.BSTIterator.TreeNode;
import testhelper.TestTreeHelper;

public class DiameterTest {
	private Diameter src;
	
	@Before
	public void setup() {
		src = new Diameter();
	}

	@Test
	public void test1() {
		Integer[] srcArr = {1,2,3,4,5};
		TreeNode srcTree = TestTreeHelper.buildTreeFromArray(srcArr);
		Assert.assertEquals(3, src.diameterOfBinaryTree(srcTree));
	}
}
