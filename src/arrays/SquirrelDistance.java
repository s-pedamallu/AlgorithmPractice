package arrays;

// Source problem: https://leetcode.com/explore/challenge/card/february-leetcoding-challenge-2021/584/week-1-february-1st-february-7th/3624/
public class SquirrelDistance {
    public int minDistance(int height, int width, int[] tree, int[] squirrel, int[][] nuts) {
        int allNutsTreesDist = 0;
        int minOffset = Integer.MAX_VALUE;
        int minNut = -1;
        for (int i=0; i<nuts.length; i++) {
            allNutsTreesDist += 2*(distBtwPoints(tree, nuts[i]));
            int offset = distBtwPoints(squirrel, nuts[i]) - distBtwPoints(tree, nuts[i]);
            if(tree[0]==nuts[i][0] && tree[1]==nuts[i][1]) {
            	continue; // same location as tree. skip
            } else if ( (minNut == -1) || (minOffset > offset)) { 
                minOffset = offset;
                minNut = i;
            }
        }
        if(minNut == -1) {
            return 0;
        }
        return (allNutsTreesDist + minOffset);                
    }
    
    private int distBtwPoints(int[] a, int[] b) {
        return (Math.abs(b[0]-a[0]) + Math.abs(b[1]-a[1]));
    }
    
    private int distSNT(int[] sPos, int[] tPos, int[] nPos) {
        return distBtwPoints(sPos, nPos) + distBtwPoints(nPos, tPos);
    }
}
