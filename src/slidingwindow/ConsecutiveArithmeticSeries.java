package slidingwindow;

/**
 * https://leetcode.com/problems/arithmetic-slices/
 */
public class ConsecutiveArithmeticSeries {
	
    public int numberOfArithmeticSlices(int[] A) {
        if(A == null || A.length<3) {
            return 0;
        }
        int ans = 0;
        int l = 0;
        int r = 1;
        int cd = A[r]-A[l];
        while(l < A.length - 1) {
            // grow
            if (r<A.length && (A[r] - A[r-1] == cd)){
                r++;
            } else {
            	// check for possible arithmetic slices
                if((r-l)>=2) {
                    int count = r - l;
                    ans += (((count-2)*(count-1))/2);
                }
                // revise variables
                l = r-1;
                cd = r<A.length ? A[r]-A[l] : 0;
            }
        }
        return ans;
    }
    
}
