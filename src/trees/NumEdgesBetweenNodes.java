package trees;

import iterators.BSTIterator.TreeNode;

/**
 * Problem: https://leetcode.com/problems/find-distance-in-a-binary-tree/
 * */
public class NumEdgesBetweenNodes {
    public int findDistance(TreeNode root, int p, int q) {
        if(p == q) {
            return 0;
        }
        int a = Math.min(p, q);
        int b = Math.max(p, q);
        return recurseDistance(root, a, b, 0);
    }
    
    private int recurseDistance(TreeNode root, int a, int b, int depth) {
        int retVal = depth;
        if(root == null) {
            retVal = 0;
        } else if(root.val == a || root.val == b) {
        	retVal = Math.max(retVal, 
        			Math.max(recurseDistance(root.left,a,b,1), recurseDistance(root.right, a, b, 1)));
            retVal = recurseDistance(root.right, a, b, 0);
        } else {
            retVal =  recurseDistance(root.left, a, b, depth+1) + 
            		recurseDistance(root.right, a, b, depth+1);
        }
        return retVal;
    }
}
