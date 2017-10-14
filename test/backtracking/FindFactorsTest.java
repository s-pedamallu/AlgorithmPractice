package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import testhelper.TestLinkedListHelper;

public class FindFactorsTest {

	private FindFactors src;

	@Before
	public void init() {
		src = new FindFactors();
	}

	@Test
	public void test1() {
		int n = 12;
		List<List<Integer>> exp = new ArrayList<>();
		exp.add(Arrays.asList(2,6));
		exp.add(Arrays.asList(2,2,3));
		exp.add(Arrays.asList(3,4));
		TestLinkedListHelper.validateListsNoOrder(exp, src.getFactors(n));
	}

}
