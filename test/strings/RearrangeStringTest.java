package strings;
import static org.junit.Assert.assertTrue;
import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

public class RearrangeStringTest {

	private RearrangeString src;

	@Before
	public void setup() {
		src = new RearrangeString();
	}

	@Test
	public void test1() {
		int k = 4;
		String input = "abcdabcdabdeac";
		validateOutput(src.rearrangeString(input, k), k);
	}

	private void validateOutput(String output, int k) {
		Map<Character, Integer> map = new HashMap<>();
		for(int i=0; i<output.length(); i++) {
			char c = output.charAt(i);
			if(map.containsKey(c)) {
				assertTrue("'"+c+"' appeared at "+map.get(c)+" and "+i+" with differece of "+(i-map.get(c)), i-map.get(c)>=k);
			}
			map.put(c, i);
		}
	}
}
