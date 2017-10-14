package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutationsUnique {
	public List<List<Integer>> permuteUnique(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		Arrays.sort(nums);
		boolean[] used = new boolean[nums.length];
		backTrack(nums, used, result, new ArrayList<>());
		return result;
	}

	private void backTrack(int[] nums, boolean[] used, List<List<Integer>> result, List<Integer> list) {
		if(list.size() == nums.length) {
			result.add(new ArrayList<>(list));
			return;
		}
		for(int i=0; i<nums.length; i++) {
			if(used[i] || (i>0 && nums[i]==nums[i-1] && !used[i-1])) continue;
			list.add(nums[i]);
			used[i]=true;
			backTrack(nums, used, result, list);
			used[i]=false;
			list.remove(list.size()-1);
		}
	}
}