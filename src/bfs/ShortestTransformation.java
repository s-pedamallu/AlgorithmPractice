package bfs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Question Link:
 * https://leetcode.com/problems/word-ladder/description/
 * @author spedamallu
 *
 */
public class ShortestTransformation {
	public int ladderLength(String beginWord, String endWord, List<String> wordList) {
		wordList.add(beginWord);
		Map<String, List<String>> map = new HashMap<>();
		for (int i = 0; i < wordList.size() - 1; i++) {
			for (int j = i + 1; j < wordList.size(); j++) {
				String a = wordList.get(i);
				String b = wordList.get(j);
				if (isOneCharDiff(a, b)) {
					List<String> one = map.containsKey(a) ? map.get(a) : new ArrayList<>();
					List<String> two = map.containsKey(b) ? map.get(b) : new ArrayList<>();
					one.add(b);
					two.add(a);
					map.put(a, one);
					map.put(b, two);
				}
			}
		}

		// BFS
		Set<String> visited = new HashSet<>();
		LinkedList<BFSNode> q = new LinkedList<>();
		q.addLast(new BFSNode(beginWord, 1));
		visited.add(beginWord);
		while (!q.isEmpty()) {
			BFSNode node = q.removeFirst();
			if (node.s.equals(endWord)) {
				return node.level;
			} else if (map.containsKey(node.s)) {
				List<String> neighbors = map.get(node.s);
				for (String n : neighbors) {
					if (!visited.contains(n)) {
						q.addLast(new BFSNode(n, node.level + 1));
						visited.add(n);
					}
				}
			}
		}
		return 0;
	}

	public int ladderLength3(String beginWord, String endWord, List<String> wordList) {
		if(!wordList.contains(endWord)) {
			return 0;
		}

		// BFS
		Set<String> visited = new HashSet<>();
		LinkedList<BFSNode> q = new LinkedList<>();
		q.addLast(new BFSNode(beginWord, 1));
		visited.add(beginWord);
		while (!q.isEmpty()) {
			BFSNode node = q.removeFirst();
			for (int i = 0; i < node.s.length(); i++) {
				for (int j = 0; j < 26; j++) {
					char[] chars = node.s.toCharArray();
					chars[i] = (char) ('a' + j);
					String ns = new String(chars);
					if (ns.equals(endWord)) {
						return node.level + 1;
					} else if (!visited.contains(ns) && wordList.contains(ns)) {
						visited.add(ns);
						q.addLast(new BFSNode(ns, node.level + 1));
					}
				}
			}
		}
		return 0;
	}

	public int ladderLength2(String beginWord, String endWord, List<String> wordList) {
		Set<String> topSet = new HashSet<>();
		Set<String> visited = new HashSet<>();
		Set<String> bottomSet = new HashSet<>();

		if(!wordList.contains(endWord)) {
			return 0;
		}
		topSet.add(beginWord);
		bottomSet.add(endWord);
		visited.add(beginWord);
		int level = 1;
		while (!topSet.isEmpty()) {
			if(topSet.size() > bottomSet.size()) {
				Set<String> tmp = bottomSet;
				bottomSet = topSet;
				topSet = tmp;
			}

			Set<String> next = new HashSet<>();
			for (String s : topSet) {
				char[] chars = s.toCharArray();
				for (int i = 0; i < s.length(); i++) {
					for (char c = 'a'; c<='z'; c++) {
						char old = chars[i];
						chars[i] = c;
						String ns = new String(chars);
						if(bottomSet.contains(ns)) {
							return level + 1;
						} else if(!visited.contains(ns) && wordList.contains(ns)) {
							next.add(ns);
							visited.add(ns);
						}
						chars[i] = old;
					}
				}
			}
			topSet = next;
			level++;
		}
		return 0;
	}

	private static class BFSNode {
		String s;
		int level;

		public BFSNode(String s, int level) {
			this.s = s;
			this.level = level;
		}
	}

	private boolean isOneCharDiff(String s1, String s2) {
		int numDiff = 0;
		for (int i = 0; i < s1.length(); i++) {
			if (s1.charAt(i) != s2.charAt(i)) {
				if (numDiff != 0) {
					return false;
				}
				numDiff++;
			}
		}
		return true;
	}

}
