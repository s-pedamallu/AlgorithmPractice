package strings;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

public class LongestSubstringWithUniqueCharsTest {

	private LongestSubstringWithUniqueChars src;
	
	@Before
	public void init() {
		src = new LongestSubstringWithUniqueChars();
	}

	@Test
	public void test1() {
		assertEquals(8, src.lengthOfLongestSubstring("shashankpedamallu"));
	}

	@Test
	public void test2() {
		assertEquals(3, src.lengthOfLongestSubstring("pwwkew"));
	}

	@Test
	public void test3() {
		assertEquals(12, src.lengthOfLongestSubstring("thisisaveryveryverylongxamp"));
	}

}
