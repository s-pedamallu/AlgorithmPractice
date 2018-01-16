package strings;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class RearrangeString {
	private static class CharCount {
		char c;
		int n;
		int idx;

		public CharCount(char c, int n, int i) {
			this.c = c;
			this.n = n;
			this.idx = i;
		}
	}

	public String rearrangeString(String s, int k) {
		if (s == null || s.length() == 0 || k == 0) {
			return s;
		}
		Map<Character, int[]> map = new HashMap<>();
		PriorityQueue<CharCount> pq = new PriorityQueue<>(26, (a, b) -> {
			if (a.n == b.n) {
				return Integer.compare(a.idx, b.idx);
			}
			return Integer.compare(b.n, a.n);
		});
		for (int i = 0; i < s.length(); i++) {
			int[] n = map.getOrDefault(s.charAt(i), new int[] { 0, -1 });
			n[0]++;
			map.put(s.charAt(i), n);
		}
		addElemsToPriorityQueue(pq, map);
		StringBuilder sb = new StringBuilder();
		map = new HashMap<>();
		int tmpk = 0;
		while (!pq.isEmpty()) {
			CharCount cc = pq.poll();
			sb.append(cc.c);
			tmpk++;
			if (cc.n > 1) {
				map.put(cc.c, new int[] { cc.n - 1, sb.length() - 1 });
			}
			if (tmpk == k) {
				tmpk = 0;
				addElemsToPriorityQueue(pq, map);
				map = new HashMap<>();
			}
		}
		System.out.println(sb.toString() + " map: " + map);
		return map.isEmpty() ? sb.toString() : "";
	}

	private void addElemsToPriorityQueue(PriorityQueue<CharCount> pq, Map<Character, int[]> map) {
		for (char c : map.keySet()) {
			int[] meta = map.get(c);
			pq.add(new CharCount(c, meta[0], meta[1]));
		}
	}
}
