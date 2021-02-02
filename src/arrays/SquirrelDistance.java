package arrays;

// Source problem: https://leetcode.com/explore/challenge/card/february-leetcoding-challenge-2021/584/week-1-february-1st-february-7th/3624/
public class SquirrelDistance {
    public int minDistance(int height, int width, int[] tree, int[] squirrel, int[][] nuts) {
        int allNutsTreesDist = 0;
        int minSquirrelNut = Integer.MAX_VALUE;
        int minNut = -1;
        for (int i=0; i<nuts.length; i++) {
            allNutsTreesDist += 2*(distBtwPoints(tree, nuts[i]));
            int squirrelDist = distBtwPoints(squirrel, nuts[i]);
            System.out.println("i - "+i+" ; dT - " + distBtwPoints(tree, nuts[i]) +
            		" ; dS - "+squirrelDist+" ; dST - " + distSNT(squirrel, tree, nuts[i]));
            if(tree[0]==nuts[i][0] && tree[1]==nuts[i][1]) {
            	continue; // same location as tree. skip
            } else if (squirrelDist < minSquirrelNut) { 
                minSquirrelNut = squirrelDist;
                minNut = i;
            } else if ((squirrelDist == minSquirrelNut) && 
            		(distBtwPoints(nuts[minNut], tree) < distBtwPoints(tree, nuts[i]))){
                minSquirrelNut = squirrelDist;
                minNut = i;            	
            }
        }
        if(minNut == -1) {
            return 0;
        }
        return (allNutsTreesDist + minSquirrelNut - distBtwPoints(tree, nuts[minNut]));                
    }
    
    private int distBtwPoints(int[] a, int[] b) {
        return (Math.abs(b[0]-a[0]) + Math.abs(b[1]-a[1]));
    }
    
    private int distSNT(int[] sPos, int[] tPos, int[] nPos) {
        return distBtwPoints(sPos, nPos) + distBtwPoints(nPos, tPos);
    }
}
