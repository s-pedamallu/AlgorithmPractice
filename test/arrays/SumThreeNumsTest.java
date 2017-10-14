package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import testhelper.TestLinkedListHelper;

public class SumThreeNumsTest {

	private SumThreeNums src;
	
	@Before
	public void init() {
		src = new SumThreeNums();
	}

	@Test
	public void test1() {
		int[] arr = {-1,0,1,2,-1,-4};
		List<List<Integer>> exp = new ArrayList<>();
		exp.add(Arrays.asList(-1,-1,2));
		exp.add(Arrays.asList(-1,0,1));
		TestLinkedListHelper.validateListsNoOrder(exp, src.threeSum(arr));
	}

	@Test
	public void test2() {
		int[] arr = {0,0,0,0};
		List<List<Integer>> exp = new ArrayList<>();
		exp.add(Arrays.asList(0,0,0));
		TestLinkedListHelper.validateListsNoOrder(exp, src.threeSum(arr));
	}

	@Test
	public void test3() {
		int[] arr = {-2,0,1,1,2};
		List<List<Integer>> exp = new ArrayList<>();
		exp.add(Arrays.asList(-2,0,2));
		exp.add(Arrays.asList(-2,1,1));
		TestLinkedListHelper.validateListsNoOrder(exp, src.threeSum(arr));
	}
}
