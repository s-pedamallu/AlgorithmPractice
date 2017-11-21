package trees;

public class SegmentTreeRangeSum {
    private int[] segTree;
    private int origArrLength;

    public SegmentTreeRangeSum(int[] nums) {
        this.origArrLength = nums.length;
        int mask = 1;
        while(mask < nums.length) {
            mask<<=1;
        }
        segTree = new int[2*mask-1];
        constructSegTree(nums, 0, nums.length-1, 0);
    }
    
    public void update(int i, int val) {
        recursiveUpdate(i, 0, origArrLength-1, 0, val);
    }
    
    public int sumRange(int i, int j) {
        return recursiveSumRange(i, j, 0, origArrLength-1, 0);
    }

    private int recursiveUpdate(int idx, int nFrom, int nTo, int pos, int newVal) {        
        if(nFrom == idx && nTo == idx) {    // leaf
            segTree[pos] = newVal;
        } else if(inRange(idx, nFrom, nTo)) { // in path
            int mid = (nFrom + nTo) / 2;
            segTree[pos] = recursiveUpdate(idx, nFrom, mid, 2*pos+1, newVal) +
                recursiveUpdate(idx, mid+1, nTo, 2*pos+2, newVal);
        }
        return segTree[pos];
    }

    private int recursiveSumRange(int qFrom, int qTo, int nFrom, int nTo, int pos) {
        if(nFrom>=qFrom && nTo<=qTo) { // node total overlap
            return segTree[pos];
        } else if(inRange(qFrom, nFrom, nTo) || inRange(qTo, nFrom, nTo)) { // partial overlap
            int mid = (nFrom + nTo)/2;
            return recursiveSumRange(qFrom, qTo, nFrom, mid, 2*pos+1) +
                recursiveSumRange(qFrom, qTo, mid+1, nTo, 2*pos+2);
        } else {    // no overlap
            return 0;
        }
    }
    
    private int constructSegTree(int[] arr, int from, int to, int pos) {
        if(from == to) {
            segTree[pos] = arr[from];            
        } else {
            int mid = (from+to)/2;
            segTree[pos] = constructSegTree(arr,from, mid, 2*pos+1) + 
                constructSegTree(arr, mid+1, to, 2*pos+2);
        }
        return segTree[pos];
    }

    private boolean inRange(int idx, int nFrom, int nTo) {
        return idx>=nFrom && idx<=nTo;
    }
}
