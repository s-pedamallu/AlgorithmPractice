package trie;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordBreak {

	public boolean wordBreak(String s, List<String> wordDict) {
		BasicTrie trie = new BasicTrie();
		for (String str : wordDict) {
			Map<String, Boolean> cache = new HashMap<>();
			if (!canBeBroken(str, trie.root, trie.root, cache)) {
				trie.insertString(str);
			}
		}
		Map<String, Boolean> cache = new HashMap<>();
		return canBeBroken(s, trie.root, trie.root, cache);
	}

	private boolean canBeBroken(String s, TrieNode node, TrieNode root, Map<String, Boolean> cache) {
		if (cache.containsKey(s)) {
			return cache.get(s);
		}
		if (s == null || s.isEmpty()) {
			return node.endOfWord;
		} else if (node.endOfWord && canBeBroken(s, root, root, cache)) {
			cache.put(s, true);
			return true;
		}

		char c = s.charAt(0);
		String rest = s.substring(1);
		boolean result = node.cMap.containsKey(c) ? canBeBroken(rest, node.cMap.get(c), root, cache) : false;
		cache.put(s, result);
		return result;
	}

	private class TrieNode {
		Map<Character, TrieNode> cMap = new HashMap<>();
		boolean endOfWord = false;
	}

	private class BasicTrie {
		TrieNode root;

		public BasicTrie() {
			root = new TrieNode();
		}

		public void insertString(String str) {
			insertIntoNode(str, root);
		}

		private void insertIntoNode(String str, TrieNode n) {
			if (str == null || str.isEmpty()) {
				n.endOfWord = true;
				return;
			}
			char c = str.charAt(0);
			String rest = str.substring(1);
			TrieNode nextNode = n.cMap.get(c);
			if (nextNode == null) {
				nextNode = new TrieNode();
				n.cMap.put(c, nextNode);
			}
			insertIntoNode(rest, nextNode);
		}

	}
}
