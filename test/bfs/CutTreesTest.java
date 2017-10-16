package bfs;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class CutTreesTest {

	private CutTrees src;
	
	@Before
	public void init() {
		src = new CutTrees();
	}

	@Test
	public void test1() {
		List<List<Integer>> list = new ArrayList<>();
		list.add(Arrays.asList(1,2,3));
		list.add(Arrays.asList(0,0,4));
		list.add(Arrays.asList(7,6,5));
		assertEquals(6, src.cutOffTree(list));
	}

	@Test
	public void test2() {
		List<List<Integer>> list = new ArrayList<>();
		list.add(Arrays.asList(1,2,3));
		list.add(Arrays.asList(0,0,0));
		list.add(Arrays.asList(7,6,5));
		assertEquals(-1, src.cutOffTree(list));
	}

	@Test
	public void test3() {
		List<List<Integer>> list = new ArrayList<>();
		list.add(Arrays.asList(2,3,4));
		list.add(Arrays.asList(0,0,5));
		list.add(Arrays.asList(8,7,6));
		assertEquals(6, src.cutOffTree(list));
	}

	@Test
	public void test4() {
		List<List<Integer>> list = new ArrayList<>();
		list.add(Arrays.asList(4557,6199,7461,2554,6132,7471,7103,4290));
		list.add(Arrays.asList(2034,2301,6733,6040,2603,5697,9541,6678));
		list.add(Arrays.asList(7308,7368,9618,4386,6944,3923,4754,4294));
		list.add(Arrays.asList(0,3016,7242,5284,6631,1897,1767,7603));
		list.add(Arrays.asList(2228,0,3625,7713,2956,3264,3371,6124));
		list.add(Arrays.asList(9195,7804,2787,0,4919,9304,5161,502));
		assertEquals(202, src.cutOffTree(list));
	}
}
