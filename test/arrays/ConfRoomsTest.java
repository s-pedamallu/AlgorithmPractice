package arrays;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import arrays.ConfRooms.Interval;

public class ConfRoomsTest {

	private ConfRooms src;
	
	@Before
	public void init() {
		src = new ConfRooms();
	}

	//[[0, 30],[5, 10],[15, 20]]
	@Test
	public void test1() {
		Interval[] arr = {new Interval(0,30), new Interval(5,10), new Interval(15,20)};
		assertEquals(2, src.minMeetingRooms(arr));
	}

	//[[9,10],[4,9],[4,17]]
	@Test
	public void test2() {
		Interval[] arr = {new Interval(9,10), new Interval(4,9), new Interval(4,17)};
		assertEquals(2, src.minMeetingRooms(arr));
	}

	// [[2,15],[36,45],[9,29],[16,23],[4,9]]
	@Test
	public void test3() {
		Interval[] arr = { new Interval(2, 15), new Interval(36, 45), new Interval(9, 29), new Interval(16, 23),
				new Interval(4, 9) };
		assertEquals(2, src.minMeetingRooms(arr));
	}

	//[[1,5],[8,9],[8,9]]
	@Test
	public void test4() {
		Interval[] arr = {new Interval(1,5), new Interval(8,9), new Interval(8,9)};
		assertEquals(2, src.minMeetingRooms(arr));
	}
}
