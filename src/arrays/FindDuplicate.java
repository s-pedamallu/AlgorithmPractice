package arrays;

/**
 * Question Link:
 * https://leetcode.com/problems/find-the-duplicate-number/description/
 * @author spedamallu
 *
 */
public class FindDuplicate {
    public int findDuplicate(int[] nums) {
        if(nums == null || nums.length==0) {
            return 0;            
        }
        int slow = nums[0];
        int fast = nums[nums[0]];
        while(slow != fast) {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        slow = nums[0];
        while(slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }
}
