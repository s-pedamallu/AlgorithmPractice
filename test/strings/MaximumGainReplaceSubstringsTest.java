package strings;

import org.junit.Before;
import org.junit.Test;

import org.junit.Assert;

public class MaximumGainReplaceSubstringsTest {
	private MaximumGainReplaceSubstrings obj;
	
	@Before
	public void init() {
		this.obj = new MaximumGainReplaceSubstrings();
	}
	
	@Test
	public void test1() {
		String testString = "cdbcbbaaabab";
		Assert.assertEquals(19, obj.maximumGain(testString, 4, 5));
	}

	@Test
	public void test2() {
		String testString = "aabbaaxybbaabb";
		Assert.assertEquals(20, obj.maximumGain(testString, 5, 4));
	}

	@Test
	public void test3() {
		String testString = "aba";
		Assert.assertEquals(5, obj.maximumGain(testString, 4, 5));
	}
	
	@Test
	public void test4_time_limit() {
		String testString = "aabbrtababbabmaaaeaabeawmvaataabnaabbaaaybbbaabbabbbjpjaabbtabbxaaavsmmnblbbabaeuasvababjbbabbabbasxbbtgbrbbajeabbbfbarbagha";
		Assert.assertEquals(198644, obj.maximumGain(testString, 8484, 4096));
	}
}
