package mz;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class WarriorsAndMonsterTest {
	private WarriorsAndMonster src;
	
	@Before
	public void init() {
		src = new WarriorsAndMonster();
	}

	@Test
	public void test1() {
		int[] health = {110, 30, 50};
		int[] attackDamage = {12, 11, 20};
		assertEquals(2, src.allianceVersusMonster(health, attackDamage));
	}

	@Test
	public void test2() {
		int[] health = {10, 3, 3, 3};
		int[] attackDamage = {2, 1, 5, 1};
		assertEquals(3, src.allianceVersusMonster(health, attackDamage));
	}

	@Test
	public void test3() {
		int[] health = {2000000000, 2000000000};
		int[] attackDamage = {1, 1};
		assertEquals(1, src.allianceVersusMonster(health, attackDamage));
	}
}
