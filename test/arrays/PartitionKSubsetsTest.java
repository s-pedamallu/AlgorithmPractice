package arrays;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import org.junit.Before;
import org.junit.Test;

public class PartitionKSubsetsTest {

	private PartitionKSubsets src;
	
	@Before
	public void init() {
		src = new PartitionKSubsets();
	}

	@Test
	public void test0() {
		int[] arr = {-1,-2,1,2,-1};
		assertTrue(src.canPartitionKSubsets(arr, 7));
	}

	@Test
	public void test1() {
		int[] arr = {4, 3, 2, 3, 5, 2, 1};
		assertTrue(src.canPartitionKSubsets(arr, 4));
	}

	@Test
	public void test2() {
		int[] arr = {4, 3, 2, 3, 5, 2, 1};
		assertFalse(src.canPartitionKSubsets(arr, 36));
	}

	@Test
	public void test3() {
		int[] arr = {1334,4518,1235,1146,3565,64,913,203,1522};
		assertTrue(src.canPartitionKSubsets(arr, 2));
	}

	@Test
	public void test4() {
		int[] arr = {7628, 3147, 7137, 2578, 7742, 2746, 4264, 7704, 9532, 9679, 8963, 3223, 2133, 7792, 5911, 3979};
		assertFalse(src.canPartitionKSubsets(arr, 6));
	}
}
