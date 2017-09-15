package trees;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertArrayEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import iterators.BSTIterator.TreeNode;
import testhelper.TestTreeHelper;

public class ZigZagLevelOrderTest {
	private ZigZagLevelOrder src;

	@Before
	public void init() {
		src = new ZigZagLevelOrder();		
	}

	@Test
	public void test1() {
		Integer[] tree = {4,2,1,6,3,null,7,9,null,null,null,13};
		TreeNode testcase = TestTreeHelper.buildTreeFromArray(tree);
		List<List<Integer>> exp = new ArrayList<>();
		exp.add(Arrays.asList(4));
		exp.add(Arrays.asList(1,2));
		exp.add(Arrays.asList(6,3,7));
		exp.add(Arrays.asList(13,9));
		validateLists(exp, src.zigzagLevelOrder(testcase));
	}

	private void validateLists(List<List<Integer>> exp, List<List<Integer>> act) {
		assertEquals(exp.size(), act.size());
		for(int i=0; i<exp.size(); i++) {
			Object[] e = exp.get(i).toArray();
			Object[] a = act.get(i).toArray();
			assertArrayEquals(e,a);
		}
	}
}
