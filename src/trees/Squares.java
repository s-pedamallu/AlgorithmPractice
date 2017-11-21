package trees;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Squares {
    private int[] segTree;
    public List<Integer> fallingSquares(int[][] positions) {
        if(positions == null || positions.length == 0 || positions[0].length==0) {
            return Collections.emptyList();
        }
        int minL = Integer.MAX_VALUE;
        int maxL = Integer.MIN_VALUE;
        for(int[] p : positions) {
            minL = Math.min(minL, p[0]);
            maxL = Math.max(maxL, p[0]+p[1]-1);
        }
        int l = maxL-minL+1;
        int mask = 1;
        while(mask<l) {
            mask<<=1;            
        }
        segTree = new int[2*mask-1];
        List<Integer> result = new ArrayList<>();
        int maxH = 0;
        for(int i=0; i<positions.length; i++) {
            int[] p = positions[i];
            int min = p[0];
            int max = p[0]+p[1]-1;
            int h = getMax(min,max,minL,maxL,0) + p[1];
            maxH = Math.max(h, maxH);
            result.add(maxH);
            updateIdx(min,max,h,minL,maxL,0);
        }
        return result;
    }

    private int getMax(int qfrom, int qto, int rfrom, int rto, int pos) {
        if(rfrom>=qfrom && rto<=qto) {
            return segTree[pos];
        } else if(inRange(qfrom, rfrom, rto) || inRange(rfrom, qfrom, qto)) {
            int mid = (rfrom+rto)/2;
            return Math.max(getMax(qfrom, qto, rfrom, mid, 2*pos+1), 
                           getMax(qfrom, qto, mid+1, rto, 2*pos+2));
        } else {
            return 0;
        }
    }

    private int updateIdx(int fidx, int tidx, int newVal, int rfrom, int rto, int pos) {
        if(rfrom==rto && inRange(rfrom,fidx,tidx)) {
            segTree[pos] = newVal;            
        } else if(inRange(fidx,rfrom,rto) || inRange(rfrom, fidx, tidx)) {
            int mid = (rfrom + rto)/2;
            segTree[pos] = Math.max(updateIdx(fidx, tidx, newVal, rfrom, mid, 2*pos+1),
                                    updateIdx(fidx, tidx, newVal, mid+1, rto, 2*pos+2));
        }
        return segTree[pos];
    }

    private boolean inRange(int idx, int from, int to) {
        return idx>=from && idx<=to;
    }
    
}