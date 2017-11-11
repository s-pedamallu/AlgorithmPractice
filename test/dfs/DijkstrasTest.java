package dfs;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class DijkstrasTest {
	private Dijkstras src;
	
	@Before
	public void init() {
		src = new Dijkstras();
	}

	@Test
	public void test1() {
		int[][] arr = {{-1, 5, 2, 15},
				{2, -1, 0, 3},
				{1, -1, -1, 9},
				{0, 0, 0, -1}
		};
		assertEquals(8, src.nightRoute(arr));
	}

}
