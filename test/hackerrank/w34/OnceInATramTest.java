package hackerrank.w34;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class OnceInATramTest {
	private OnceInATram src;

	@Before
	public void setup() {
		src = new OnceInATram();
	}

	@Test
	public void test555555() {
		Assert.assertEquals("555564", src.getNextLuckyTicket("555555"));
	}

	@Test
	public void test599896() {
		Assert.assertEquals("599959", src.getNextLuckyTicket("599896"));
	}

	@Test
	public void test100124() {
		Assert.assertEquals("101002", src.getNextLuckyTicket("100124"));
	}

	@Test
	public void test100093() {
		Assert.assertEquals("100100", src.getNextLuckyTicket("100093"));
	}

	@Test
	public void test100006() {
		Assert.assertEquals("100010", src.getNextLuckyTicket("100006"));
	}	

	@Test
	public void test112999() {
		Assert.assertEquals("113005", src.getNextLuckyTicket("112999"));
	}
}
