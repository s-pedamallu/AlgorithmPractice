package arrays;

import java.util.Stack;

/**
 * Problem: https://leetcode.com/problems/trapping-rain-water/
 */
public class RainWater2D {
	public int trap(int[] height) {
		return trapOptimized(height);
	}
	
	private int trapOptimized(int[] height) {
		int left = 0;
		int right = height.length-1;
		int lMax = Integer.MIN_VALUE;
		int rMax = Integer.MIN_VALUE;
		int ans = 0;
		while(right-left>0) {
            lMax = Math.max(lMax, height[left]);
            rMax = Math.max(rMax, height[right]);
			if(height[left] <= height[right]) {
				ans += Math.min(lMax, rMax) - height[left];
				left++;
			} else {
				ans += Math.min(lMax, rMax) - height[right];
				right--;
			}
		}
		return ans;
	}

    private int trapStack(int[] height) {
        int ans = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        for(int i=1; i<height.length; i++) {
        	int popIdx = -1;
            while(!stack.isEmpty() && height[stack.peek()] < height[i]) {
                popIdx = stack.pop();
            }
            if(popIdx!=-1 || !stack.isEmpty()) {
            	popIdx = stack.isEmpty() ? popIdx : stack.peek();
                int fillHeight=Math.min(height[i], height[popIdx]);
                for(int j=popIdx+1; j<i;j++) {
                    ans += fillHeight - height[j];
                    height[j] = fillHeight;
                }                
            }
            stack.push(i);
        }
        return ans;
    }
    
}
