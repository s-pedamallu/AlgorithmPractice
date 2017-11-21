package trees;

public class SegmentTreeRangeMinimum {
	private int[] segmentTree;
	private int srcArrLength;

	// Construct segment tree
	SegmentTreeRangeMinimum(int[] src) {
		srcArrLength = src.length;
		int mask = 1;
		while(mask < src.length) {
			mask<<=1;
		}
		segmentTree = new int[2*mask-1];
		for(int i=0; i<segmentTree.length; i++) {
			segmentTree[i] = Integer.MAX_VALUE;
		}
		constructSegmentTree(src, 0, src.length-1, 0);
	}

	public int getMin(int fromIdx, int toIdx) {
		return recursiveGetMin(fromIdx, toIdx, 0, srcArrLength-1, 0);
	}

	public void updateIndex(int idx, int newVal) {
		recursiveUpdateIndex(idx, 0, srcArrLength-1, 0, newVal);
	}

	private int recursiveUpdateIndex(int idx, int rangeFrom, int rangeTo, int cur, int newVal) {
		if(rangeFrom == idx && rangeTo == idx) { // leaf
			segmentTree[cur] = newVal;
		} else if(inRange(idx, rangeFrom, rangeTo)) { // in path
			int mid = (rangeFrom + rangeTo) / 2;
			segmentTree[cur] = Math.min(recursiveUpdateIndex(idx, rangeFrom, mid, cur*2+1, newVal),
			recursiveUpdateIndex(idx, mid + 1, rangeTo, cur*2+2, newVal));
		}
		return segmentTree[cur];		
	}

	private int recursiveGetMin(int from, int to, int rangeFrom, int rangeTo, int cur) {
		if (rangeFrom >= from && rangeTo <= to) { // total overlap
			return segmentTree[cur];
		} else if (inRange(from, rangeFrom, rangeTo) || 
				inRange(to, rangeFrom, rangeTo)) { // partial overlap
			int mid = (rangeFrom + rangeTo) / 2;
			return Math.min(recursiveGetMin(from, to, rangeFrom, mid, 2 * cur + 1),
					recursiveGetMin(from, to, mid + 1, rangeTo, 2 * cur + 2));
		} else { // no overlap
			return Integer.MAX_VALUE;
		}
	}

	private int constructSegmentTree(int[] src, int l, int r, int cur) {
		if(l == r) {
			segmentTree[cur] = src[l];
			return src[l];
		}
		int mid = (l+r)/2;
		segmentTree[cur] = Math.min(constructSegmentTree(src, l, mid, cur*2+1), constructSegmentTree(src, mid+1, r, cur*2+2));
		return segmentTree[cur];
	}
	
	private boolean inRange(int idx, int from, int to) {
		return idx >= from && idx<=to;
	}
}
