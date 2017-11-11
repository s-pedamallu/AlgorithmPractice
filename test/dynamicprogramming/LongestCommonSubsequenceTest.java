package dynamicprogramming;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class LongestCommonSubsequenceTest {
private LongestCommonSubsequence src;
	
	@Before
	public void init() {
		src = new LongestCommonSubsequence();
	}

	@Test
	public void test1() {
		assertEquals(2, src.lcs("Cat","Bat building"));
	}

	@Test
	public void test2() {
		assertEquals(2, src.lcs("cat","at street"));
	}
}
