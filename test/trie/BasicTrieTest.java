package trie;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import org.junit.Before;
import org.junit.Test;

public class BasicTrieTest {
	private BasicTrie src;

	@Before
	public void init() {
		src = new BasicTrie();
	}

	@Test
	public void insertAndQueryTest() {
		src.insert("Shashank");
		src.insert("Pedamallu");
		src.insert("Sravani");
		src.insert("Sreedhar");
		src.insert("Veni");
		src.insert("Murthy");
		src.insert("Mallikarjun");
		src.insert("Santosh");
		src.insert("Rohit");
		src.insert("Sreekanth");
		src.insert("Akshay");
		src.insert("Pramodh");
		
		assertTrue(src.isPresent("Akshay"));
		assertFalse(src.isPresent("akshay"));
		assertFalse(src.isPresent("Eva"));
		assertFalse(src.isPresent("Malli"));
		assertTrue(src.isPrefixPresent("Malli"));
		assertFalse(src.isPrefixPresent("mallu"));
		assertTrue(src.isPrefixPresent("Ped"));
	}
}
