package arrays;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

public class TaskSchedulerTest {

	private TaskScheduler src;

	@Before
	public void setup() {
		src = new TaskScheduler();
	}

	@Test
	public void test1() {
		char[] input = {'A','A','A','B','B','B'};
		assertEquals(8,src.leastInterval(input, 2));
	}
}
