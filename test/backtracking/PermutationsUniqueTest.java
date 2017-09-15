package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import testhelper.TestLinkedListHelper;

public class PermutationsUniqueTest {
	private PermutationsUnique src;

	@Before
	public void init() {
		src = new PermutationsUnique();		
	}

	@Test
	public void test1() {
		int[] testcase = {1,1,2};
		List<List<Integer>> exp = new ArrayList<>();
		exp.add(Arrays.asList(1,1,2));
		exp.add(Arrays.asList(1,2,1));
		exp.add(Arrays.asList(2,1,1));
		TestLinkedListHelper.validateListsNoOrder(exp, src.permuteUnique(testcase));
	}

}
