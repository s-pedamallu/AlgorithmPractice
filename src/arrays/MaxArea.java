package arrays;

public class MaxArea {
	
	public int maxArea(int[] height) {
		return maxAreaBruteForce(height);
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
