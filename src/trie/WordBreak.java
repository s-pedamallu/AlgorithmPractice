package trie;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordBreak {

	private class LengthComparator implements Comparator<String> {
		@Override
		public int compare(String o1, String o2) {
			if(o1 == null) {
				return -1;
			} else if(o2 == null) {
				return 1;
			}
			return o1.length()-o2.length();
		}
		
	}

	 public boolean wordBreak(String s, List<String> wordDict) {
	        if(s == null || s.isEmpty()) {
	            return false;
	        }
	        boolean[] breakableWords = new boolean[s.length()+1];
	        breakableWords[0] = true;
	        for(int i=0; i<=s.length(); i++) {
	            for(int j=0; j<i; j++) {
	                if(breakableWords[j] && wordDict.contains(s.substring(j, i))) {
	                    breakableWords[i] = true;
	                    break;
	                }
	            }
	        }
	        return breakableWords[s.length()];
	    }
	 
	public boolean wordBreakUsingTrie(String s, List<String> wordDict) {
		BasicTrie trie = new BasicTrie();
		Collections.sort(wordDict, new LengthComparator());
		for (String str : wordDict) {
			Map<TrieNodeString, Boolean> cache = new HashMap<>();
			if (!canBeBroken(str, trie.root, trie.root, cache)) {
				trie.insertString(str);
			}
		}
		Map<TrieNodeString, Boolean> cache = new HashMap<>();
		return canBeBroken(s, trie.root, trie.root, cache);
	}

	private boolean canBeBroken(String s, TrieNode node, TrieNode root, Map<TrieNodeString, Boolean> cache) {
		TrieNodeString t = new TrieNodeString(s, node);
		if (cache.containsKey(t)) {
			return cache.get(t);
		}
		if (s == null || s.isEmpty()) {
			return node.endOfWord;
		} else if (node.endOfWord && canBeBroken(s, root, root, cache)) {
			cache.put(t, true);
			return true;
		}

		char c = s.charAt(0);
		String rest = s.substring(1);
		boolean result = node.cMap.containsKey(c) ? canBeBroken(rest, node.cMap.get(c), root, cache) : false;
		cache.put(t, result);
		return result;
	}

	private class TrieNode {
		Map<Character, TrieNode> cMap = new HashMap<>();
		boolean endOfWord = false;
		
		@Override 
		public int hashCode() {
			return 127+131*cMap.hashCode()+131*(endOfWord ? 1 : 0);
		}

		@Override 
		public boolean equals(Object o) {
			if(o instanceof TrieNode) {
				TrieNode t = (TrieNode) o;
				return this.cMap.equals(t.cMap) && this.endOfWord==t.endOfWord;
			}
			return false;
		}
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

	private class TrieNodeString {
		TrieNode node;
		String str;

		TrieNodeString(String s, TrieNode node) {
			this.node = node;
			this.str = s;
		}

		@Override
		public boolean equals(Object o) {
			if(o instanceof TrieNodeString) {
				TrieNodeString t = (TrieNodeString) o;
				boolean ans = this.node==t.node && this.str.equals(t.str);
				return ans;
			}
			return false;
		}

		@Override
		public int hashCode() {
			return 197+113*node.hashCode()+113*str.hashCode();
		}
	}
}
