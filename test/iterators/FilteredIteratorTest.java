package iterators;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

import org.junit.Before;
import org.junit.Test;

public class FilteredIteratorTest {

	private FilteredIterator<Integer> src;
	private Filter<Integer> evenFilter;

	private static class FilterIsEven implements Filter<Integer> {
		@Override
		public boolean isValid(Integer t) {
			return (t & 1) == 0;
		}
	}

	@Before
	public void init() {
		evenFilter = new FilterIsEven();
	}

	@Test(expected = NoSuchElementException.class)
	public void test1() {
		List<Integer> numList = Arrays.asList(4, 2, 7, 9, 12, 3, 5);
		src = new FilteredIterator<Integer>(numList.iterator(), evenFilter);
		assertTrue(src.hasNext());
		assertEquals(4, src.next().intValue());
		assertEquals(2, src.next().intValue());
		assertTrue(src.hasNext());
		assertTrue(src.hasNext());
		assertEquals(12, src.next().intValue());
		assertFalse(src.hasNext());
		src.next();
	}
}