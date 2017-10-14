package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SumThreeNums {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        if(nums!=null && nums.length>0) {
            for(int i=0; i<nums.length-1; i++) {
                if(i==0 || nums[i]!=nums[i-1]) {
                    int sum = 0-nums[i];
                    int l = i+1;
                    int r = nums.length-1;
                    while(l<r) {
                        if(nums[l]+nums[r] == sum) {
                            result.add(Arrays.asList(nums[i], nums[l], nums[r]));
                            while(l<r && nums[l]==nums[l+1]) l++;
                            while(l<r && nums[r]==nums[r-1]) r--;
                        }
                        if(nums[l]+nums[r] < sum) {
                            l++;
                        } else {
                            r--;
                        }
                    }
                }
            }
        }
        return result;
    }
}
