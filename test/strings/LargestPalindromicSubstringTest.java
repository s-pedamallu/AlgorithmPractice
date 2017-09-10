package strings;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class LargestPalindromicSubstringTest {

	private LargestPalindromicSubstring src;

	@Before
	public void init() {
		src = new LargestPalindromicSubstring();
	}

	@Test
	public void test1() {
		String input = "babad";
		assertEquals("bab", src.largestPalindromicSubstring(input));
	}

	@Test
	public void test2() {
		String input = "abaxabaxabb";
		assertEquals("baxabaxab", src.largestPalindromicSubstring(input));
	}

	@Test
	public void test3() {
		String input = "abaxabaxabybaxabyb";
		assertEquals("baxabybaxab", src.largestPalindromicSubstring(input));
	}

	@Test
	public void test4() {
		String input = "abaab";
		assertEquals("baab", src.largestPalindromicSubstring(input));
	}
}
