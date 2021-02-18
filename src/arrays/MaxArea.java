package arrays;

/**
 * Prob: https://leetcode.com/problems/container-with-most-water/
 */
public class MaxArea {	
	
	public int maxArea(int[] height) {
		return maxAreaOptimized(height);
	}
	
	private int maxAreaOptimized(int[] height) {
		int s = 0;
		int e = height.length-1;
		int ans = Integer.MIN_VALUE;
		while(e-s>0) {
			ans = Math.max(ans, Math.min(height[s], height[e])*(e-s));
			if(height[s]<=height[e]) {
				s++;
			} else {
				e--;
			}
		}
		return ans;
	}

	private int maxAreaBruteForce(int[] height) {
        int ans = Integer.MIN_VALUE;
        for (int i=1; i<height.length; i++) {
            for(int j=0; j<i; j++) {
                ans = Math.max(ans, Math.min(height[i], height[j])*(i-j));
            }
        }
        return ans;
    }

}
