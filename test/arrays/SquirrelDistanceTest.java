package arrays;

import org.junit.Before;
import org.junit.Test;

import org.junit.Assert;

public class SquirrelDistanceTest {
	private SquirrelDistance obj;
	
	@Before
	public void init() {
		obj = new SquirrelDistance();
	}

	@Test
	public void test1() {
		int gridHeight = 5;
		int gridWidth = 7;
		int[] treePos = {2,2};
		int[] squirrelPos = {4,4};
		int[][] nuts = {{3,0}, {2,5}};
		
		int ans = obj.minDistance(gridHeight, gridWidth, treePos, squirrelPos, nuts);
		Assert.assertEquals(12, ans);
	}
	
	@Test
	public void test2() {
		int gridHeight = 5;
		int gridWidth = 5;
		int[] treePos = {3,2};
		int[] squirrelPos = {0,1};
		int[][] nuts = {{2,0},{4,1},{0,4},{1,3},{1,0},{3,4},{3,0},{2,3},{0,2},{0,0},{2,2},{4,2},{3,3},{4,4},{4,0},{4,3},{3,1},{2,1},{1,4},{2,4}};
		
		int ans = obj.minDistance(gridHeight, gridWidth, treePos, squirrelPos, nuts);
		Assert.assertEquals(100, ans);
	}

	@Test
	public void test3() {
		int gridHeight = 9;
		int gridWidth = 9;
		int[] treePos = {7,2};
		int[] squirrelPos = {7,1};
		int[][] nuts = {{3,0},{7,7},{8,8},{0,8},{2,4},{4,5},{3,5},{4,2},{1,8}};
		
		int ans = obj.minDistance(gridHeight, gridWidth, treePos, squirrelPos, nuts);
		Assert.assertEquals(131, ans);
	}
	
	/*
9
9
[7,2]
[7,1]
[[3,0],[7,7],[8,8],[0,8],[2,4],[4,5],[3,5],[4,2],[1,8]]
	 * */
}
