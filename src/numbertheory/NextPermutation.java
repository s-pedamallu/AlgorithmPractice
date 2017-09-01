package numbertheory;

import java.util.Arrays;

public class NextPermutation {
	public void nextPermutation(int[] nums) {
		int idx = -1;
		for (int i = nums.length - 2; i >= 0; i--) {
			if (nums[i] < nums[i + 1]) {
				idx = i;
				break;
			}
		}
		if (idx != -1) {
			int base = nums[idx];
			Arrays.sort(nums, idx, nums.length);
			searchAndSwap(nums, base, idx, idx, nums.length);
		} else {
			// unable to find next permutation => input is sorted, reverse it
			for (int i = 0, j = nums.length - 1; i < j; i++, j--) {
				int tmp = nums[i];
				nums[i] = nums[j];
				nums[j] = tmp;
			}
		}
	}
    
    private void searchAndSwap(int[] nums, int base, int baseIdx, int from, int to) {
        int mid = (from+to)/2;
        if(nums[mid]>base) {
            if(mid==0) {
                System.out.println("Invalid case: "+nums+" base: "+base+" baseIdx: "+baseIdx);
            }
            else if(mid>0 && nums[mid-1]<=base) {
                int tmp = nums[baseIdx];
                nums[baseIdx]=nums[mid];
                nums[mid] = tmp;
                Arrays.sort(nums, baseIdx+1, nums.length);
                return;
            } else {
                searchAndSwap(nums, base, baseIdx, from, mid);
            }
        } else {
            searchAndSwap(nums, base, baseIdx, mid, to);
        }
    }
}
