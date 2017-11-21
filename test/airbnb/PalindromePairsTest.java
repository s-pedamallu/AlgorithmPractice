package airbnb;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import testhelper.TestLinkedListHelper;

public class PalindromePairsTest {
	private PalindromePairs src;
	
	@Before
	public void init() {
		src = new PalindromePairs();
	}

	@Test
	public void test1() {
		String[] input = {"cat", "bat", "race", "rat", "tab", "car"};
		List<List<Integer>> exp = new ArrayList<>();
		exp.add(Arrays.asList(1,4));
		exp.add(Arrays.asList(2,5));
		exp.add(Arrays.asList(4,1));
		TestLinkedListHelper.validateListsNoOrder(exp, src.palindromePairs(input));
	}

	@Test
	public void test2() {
		String[] input = {"abcd", "dcba", "lls", "s", "sssll"};
		List<List<Integer>> exp = new ArrayList<>();
		exp.add(Arrays.asList(0,1));
		exp.add(Arrays.asList(1,0));
		exp.add(Arrays.asList(3,2));
		exp.add(Arrays.asList(2,4));
		TestLinkedListHelper.validateListsNoOrder(exp, src.palindromePairs(input));
	}
}