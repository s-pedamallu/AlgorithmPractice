package numbertheory;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class SortedSerialNumberTest {
	private SortedSerialNumber src;

	@Before
	public void init() {
		src = new SortedSerialNumber();
	}

	@Test
	public void test1() {
		assertEquals(2, src.findRank("acb"));
	}
	
	@Test
	public void test2() {
		assertEquals(4, src.findRank("bca"));
	}

	@Test
	public void test3() {
		assertEquals(15, src.findRank("VIEW"));
	}
}
