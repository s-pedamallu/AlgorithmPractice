package bfs;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class WallsAndGatesTest {
	private WallsAndGates src;
	
	@Before
	public void init() {
		src = new WallsAndGates();
	}

	@Test
	public void test1() {
		int[][] arr = {{2147483647,-1,0,2147483647},
				{2147483647,2147483647,2147483647,-1},
				{2147483647,-1,2147483647,-1},
				{0,-1,2147483647,2147483647}};
		int[][] exp = {{3,-1,0,1}, {2,2,1,-1}, {1,-1,2,-1}, {0,-1,3,4}};
		src.wallsAndGates(arr);
		for(int i=0; i<arr.length; i++) {
			Assert.assertArrayEquals("At row "+i, exp[i], arr[i]);
		}
	}

}
