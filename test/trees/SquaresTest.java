package trees;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class SquaresTest {
	private Squares src;

	@Before
	public void init() {
		src = new Squares();
	}

	@Test
	public void test1() {
		int[][] input = {{1,2},{2,3},{6,1}};
		List<Integer> exp = new ArrayList<>();
		exp.add(2);
		exp.add(5);
		exp.add(5);
		List<Integer> act = src.fallingSquares(input);
		assertEquals(exp.size(), act.size());
		for(int i=0; i<exp.size(); i++) {
			assertEquals("Difference at idx: "+i, exp.get(i), act.get(i));
		}
	}

	@Test
	public void test2() {
		int[][] input = {{3, 3},{6, 3}};
		List<Integer> exp = new ArrayList<>();
		exp.add(3);
		exp.add(3);
		List<Integer> act = src.fallingSquares(input);
		assertEquals(exp.size(), act.size());
		for(int i=0; i<exp.size(); i++) {
			assertEquals("Difference at idx: "+i, exp.get(i), act.get(i));
		}
	}

	@Test
	public void test3() {
		int[][] input = {{9,7},{1,9},{3,1}};
		List<Integer> exp = new ArrayList<>();
		exp.add(7);
		exp.add(16);
		exp.add(17);
		List<Integer> act = src.fallingSquares(input);
		assertEquals(exp.size(), act.size());
		for(int i=0; i<exp.size(); i++) {
			assertEquals("Difference at idx: "+i, exp.get(i), act.get(i));
		}
	}
}