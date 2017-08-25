package strings;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

public class MaxAbsolutePathLengthTest {

	private MaxAbsolutePathLength src;
	
	@Before
	public void init() {
		src = new MaxAbsolutePathLength();
	}

	@Test
	public void test1() {
		assertEquals(20, src.lengthLongestPath("dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext"));
	}

	@Test
	public void test2() {
		assertEquals(40, src.lengthLongestPath("dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext\nThisIsAVeryVeryVeryVeryLongFile.someFile"));
	}
}
