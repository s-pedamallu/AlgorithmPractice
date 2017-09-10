package bfs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
		q.addLast(new BFSNode(beginWord, 0));
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
