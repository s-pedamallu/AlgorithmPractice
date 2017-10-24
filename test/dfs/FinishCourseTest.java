package dfs;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import org.junit.Before;
import org.junit.Test;

public class FinishCourseTest {

	private FinishCourse src;

	@Before
	public void init() {
		src = new FinishCourse();
	}

	@Test
	public void test1() {
		int numCourses = 8;
		int[][] arr = { { 1, 0 }, { 2, 6 }, { 0, 5 }, { 1, 7 }, { 6, 4 }, { 7, 0 } };
		assertTrue(src.canFinish(numCourses, arr));
	}

	@Test
	public void test2() {
		int numCourses = 2;
		int[][] arr = { { 1, 0 }, { 0, 1 } };
		assertFalse(src.canFinish(numCourses, arr));
	}
}
