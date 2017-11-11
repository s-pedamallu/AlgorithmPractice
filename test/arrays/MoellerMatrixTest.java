package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import testhelper.TestLinkedListHelper;

public class MoellerMatrixTest {

	private MoellerMatrix src;
	
	@Before
	public void init() {
		this.src = new MoellerMatrix();
	}

	@Test
	public void test1() {
		List<List<Integer>> input = new ArrayList<>();
		input.add(Arrays.asList(1,2,3));
		input.add(Arrays.asList(4,5,6));
		input.add(Arrays.asList(9,8,7));
		List<List<Integer>> output = src.diagonal(input);
		List<List<Integer>> expected = new ArrayList<>();
		expected.add(Arrays.asList(1));
		expected.add(Arrays.asList(2,4));
		expected.add(Arrays.asList(3,5,9));
		expected.add(Arrays.asList(6,8));
		expected.add(Arrays.asList(7));
		TestLinkedListHelper.validateListsInOrder(expected, output);
	}

	@Test
	public void test2() {
		List<List<Integer>> input = new ArrayList<>();
		input.add(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8));
		input.add(Arrays.asList(8, 7, 6, 5, 4, 3, 2, 1));
		input.add(Arrays.asList(3, 2, 6, 8, 1, 4, 7, 5));
		List<List<Integer>> output = src.diagonal(input);
		List<List<Integer>> expected = new ArrayList<>();
		expected.add(Arrays.asList(1));
		expected.add(Arrays.asList(2,8));
		expected.add(Arrays.asList(3,7,3));
		expected.add(Arrays.asList(4,6,2));
		expected.add(Arrays.asList(5,5,6));
		expected.add(Arrays.asList(6,4,8));
		expected.add(Arrays.asList(7,3,1));
		expected.add(Arrays.asList(8,2,4));
		expected.add(Arrays.asList(1,7));
		expected.add(Arrays.asList(5));
		TestLinkedListHelper.validateListsInOrder(expected, output);
	}
}
