package bfs;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class ShortestTransformationTest {
	private ShortestTransformation src;
	
	@Before
	public void init() {
		src = new ShortestTransformation();
	}

	@Test
	public void test1() {
		String beginWord = "hit";
		String endWord = "cog";
		List<String> words = Arrays.asList("hot", "dot", "dog", "log", "lot", "cot", "cog");
		assertEquals(5, src.ladderLength(beginWord, endWord, new ArrayList<>(words)));
	}
}
