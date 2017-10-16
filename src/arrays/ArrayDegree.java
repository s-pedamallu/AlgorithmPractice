package arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ArrayDegree {
	public int findShortestSubArray(int[] nums) {
		Map<Integer, List<Integer>> map = new HashMap<>();
		int maxFreq = 0;
		int ansFreq = 0;
		int ans = Integer.MAX_VALUE;
		for (int i = 0; i < nums.length; i++) {
			int num = nums[i];
			List<Integer> l = map.containsKey(num) ? map.get(num) : new ArrayList<>();
			l.add(i);
			map.put(num, l);
			maxFreq = Math.max(maxFreq, l.size());
			if (l.size() == maxFreq && ansFreq < maxFreq) {
				ans = l.get(l.size() - 1) - l.get(0) + 1;
				ansFreq = maxFreq;
			} else if (l.size() == maxFreq && ansFreq == maxFreq) {
				ans = Math.min(ans, l.get(l.size() - 1) - l.get(0) + 1);
			}
		}
		return ans;
	}

}
