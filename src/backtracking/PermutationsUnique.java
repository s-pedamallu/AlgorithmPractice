package backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PermutationsUnique {
	public List<List<Integer>> permuteUnique(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		Map<Integer, Integer> numCount = new HashMap<>();
		for(int num : nums) {
			int c = numCount.containsKey(num) ? numCount.get(num) : 0;
			numCount.put(num, c+1);
		}
		backTrack(nums, numCount, result, new ArrayList<>());
		return result;
	}

	private void backTrack(int[] nums, Map<Integer, Integer> numCount, List<List<Integer>> result, List<Integer> list) {
		if(numCount.isEmpty()) {
			if(!result.contains(list)) {
				result.add(new ArrayList<>(list));
			}
			return;
		}
		for(int num : nums) {
			if(!numCount.containsKey(num)) {
				continue;
			}
			list.add(num);
			int c = numCount.get(num);
			if(c == 1) {
				numCount.remove(num);
			} else {
				numCount.put(num, c-1);
			}
			backTrack(nums, numCount, result, list);
			numCount.put(num, c);
			list.remove(list.size()-1);
		}
	}
}