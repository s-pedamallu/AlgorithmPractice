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

}
