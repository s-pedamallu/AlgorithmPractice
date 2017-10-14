package strings;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

public class ShortestSubstringWithGivenCharsTest {

	private ShortestSubstringWithGivenChars src;

	@Before
	public void init() {
		src = new ShortestSubstringWithGivenChars();
	}

	@Test
	public void test1() {
		char[] arr = {'m','r','e'};
		assertEquals("mber", src.substringWithChars("september", arr));
	}

	@Test
	public void test2() {
		char[] arr = {'m','r','e','s'};
		assertEquals("september", src.substringWithChars("september", arr));
	}

	@Test
	public void test3() {
		char[] arr = {'m','r','e','v'};
		assertEquals("", src.substringWithChars("september", arr));
	}
}
