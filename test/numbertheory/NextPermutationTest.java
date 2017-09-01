package numbertheory;
import static org.junit.Assert.assertArrayEquals;
import org.junit.Before;
import org.junit.Test;

public class NextPermutationTest {
	private NextPermutation src;

	@Before
	public void init() {
		src = new NextPermutation();
	}

	@Test
	public void test1() {
		int[] arr = {1,0,0,0,3,2,0};
		int[] expected = {1,0,0,2,0,0,3};
		src.nextPermutation(arr);
		assertArrayEquals(expected, arr);
	}

	@Test
	public void test3() {
		int[] arr = {1,3,2,0,0,0,0};
		int[] expected = {2,0,0,0,0,1,3};
		src.nextPermutation(arr);
		assertArrayEquals(expected, arr);
	}

	@Test
	public void test2() {
		int[] arr = {3,2,1};
		int[] expected = {1,2,3};
		src.nextPermutation(arr);
		assertArrayEquals(expected, arr);
	}
}