package trees;

import static org.junit.Assert.assertArrayEquals;
import org.junit.Before;
import org.junit.Test;

import testhelper.TestTreeHelper;

public class TreeFromTraversalsTest {
	private TreeFromTraversals src;

	@Before
	public void init() {
		src = new TreeFromTraversals();		
	}

	@Test
	public void test1() {
		Integer[] exp = {20,9, 25, 5,12, null, null, null, null, 11, 14};
		int[] pre = {20, 9, 5, 12, 11, 14, 25};
		int[] in = {5, 9, 11, 12, 14, 20, 25};
		Integer[] act = TestTreeHelper.buildArrayFromTree(src.buildTreeFromTraversals(pre, in));
		assertArrayEquals(exp, act);
	}
}
