package arrays;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class WordSearchTest {

	private WordSearch src;
	
	@Before
	public void init() {
		src = new WordSearch();
	}

	@Test
	public void test1() {
		char[][] arr = {{'A','B','C','E'},
				{'S','F','C','S'},
				{'A','D','E','E'}};
		assertTrue(src.exist(arr, "ABCCED"));
		assertTrue(src.exist(arr, "SEE"));
		assertFalse(src.exist(arr, "ABCB"));
	}

	@Test
	public void test2() {
		char[][] arr = {{'A','B','C','E'},
				{'S','F','E','S'},
				{'A','D','E','E'}};
		assertTrue(src.exist(arr, "ABCESEEEFS"));
	}
}
