package trees;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

public class DescendentsOfProcessTest {

	private DescendentsOfProcess obj;
	
	@Before
	public void init() {
		obj = new DescendentsOfProcess();
	}
	
	@Test
	public void test1() {
		List<Integer> pids = Arrays.asList(1, 3, 10, 5);
		List<Integer> ppids = Arrays.asList(3, 0, 5, 3);
		
		Set<Integer> expected = new HashSet(Arrays.asList(5,10));
		validateSet(expected, obj.killProcess(pids, ppids, 5));
	}
	
	private void validateSet(Set<Integer> expected, List<Integer> actual) {
		if(actual.size()!=expected.size()) {
			assertEquals("Sizes not same. Expected size: "+expected.size()+
					"; Actual size: "+actual.size(), expected.size(), actual.size());
		}
		for(Integer i : actual) {
			assertTrue("Unexpected value - "+i, expected.contains(i));
		}
	}
}
