package backtracking;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

public class AddOperatorsTest {
	private AddOperators src;
	
	@Before
	public void init() {
		src = new AddOperators();
	}

	@Test
	public void test1() {
		List<String> exp = new ArrayList<>();
		exp.add("2*3+2");
		exp.add("2+3*2");
		validate(exp, src.addOperators("232", 8));
	}

	private void validate(List<String> expected, List<String> act) {
		Set<String> exp = new HashSet<>(expected);
		assertEquals(exp.size(), act.size());
		for(String s : act) {
			assertTrue(exp.contains(s));
		}
	}
}
