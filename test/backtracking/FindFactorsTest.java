package backtracking;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class FindFactorsTest {

	private FindFactors src;

	@Before
	public void init() {
		src = new FindFactors();
	}

	@Test
	public void test1() {
		int n = 12;
		List<List<Integer>> exp = new ArrayList<>();
		exp.add(Arrays.asList(2,6));
		exp.add(Arrays.asList(2,2,3));
		exp.add(Arrays.asList(3,4));
		validateResult(exp, src.getFactors(n));
	}

	private void validateResult(List<List<Integer>> exp, List<List<Integer>> act) {
		assertEquals(exp.size(), act.size());
		for(int i=0; i<exp.size(); i++) {
			Object[] earr = exp.get(i).toArray();
			boolean found = false;
			for(int j=0; j<act.size(); j++) {
				Object[] aarr = act.get(j).toArray();
				if(Arrays.deepEquals(earr, aarr)) {
					found = true;
					break;
				}
			}
			if(!found) {
				assertFalse("Not found "+exp.get(i)+" in the result", true);
			}
		}
	}
}
