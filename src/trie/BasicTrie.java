package trie;

import java.util.HashMap;
import java.util.Map;

public class BasicTrie {
	private class TrieNode {
		private Map<Character, TrieNode> cMap;
		private boolean endOfWord;
		
		TrieNode() {
			cMap = new HashMap<>();
			endOfWord = false;
		}

		public Map<Character, TrieNode> getcMap() {
			return cMap;
		}

		public boolean isEndOfWord() {
			return endOfWord;
		}

		public void setEndOfWord(boolean endOfWord) {
			this.endOfWord = endOfWord;
		}

	}

	private TrieNode root;

	public void insert(String str) {
		if(str==null) {
			return;
		}
		if(root == null) {
			root = new TrieNode();
		}
		if(str.isEmpty()) {
			root.setEndOfWord(true);
		}
		TrieNode nextNode = root;
		for(int i=0; i<str.length(); i++) {
			char c = str.charAt(i);
			nextNode = insertCharAndGetNextNode(c, nextNode);
		}
		nextNode.setEndOfWord(true);
	}

	public boolean isPresent(String str) {
		return isPresent(str, true);
	}

	public boolean isPrefixPresent(String str) {
		return isPresent(str, false);
	}

	private boolean isPresent(String str, boolean isCompleteWord) {
		if(str == null) {
			return false;
		} else if(str.isEmpty()) {
			return root.isEndOfWord();
		} else {
			TrieNode curNode = root;
			for(int i=0; i<str.length(); i++) {
				Map<Character, TrieNode> cMap = curNode.getcMap();
				if(!cMap.containsKey(str.charAt(i))) {
					return false;
				}
				curNode = cMap.get(str.charAt(i));
			}
			return isCompleteWord ? curNode.isEndOfWord() : true;
		}		
	}

	private TrieNode insertCharAndGetNextNode(char c, TrieNode node) {
		Map<Character, TrieNode> cMap = node.getcMap();
		TrieNode result = null;
		if(cMap.containsKey(c)) {
			result = cMap.get(c);
		} else {
			result = new TrieNode();
			cMap.put(c, result);
		}
		return result;
	}
}
