package bst;

import iterators.BSTIterator.TreeNode;

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
        } else if(root.val < a) {            
            retVal = recurseDistance(root.right, a, b, 0);
        } else if (root.val == a) {
            retVal = depth + recurseDistance(root, a, b, depth+1);
        } else if (a < root.val && root.val < b) {
            retVal = recurseDistance(root.left, a, b, depth+1) +
                recurseDistance(root.right, a, b, depth+1);
        } else if (root.val == b) {
            retVal = recurseDistance(root.left, a, b, depth+1) + depth;
        } else if (b < root.val) {
            retVal =  recurseDistance(root.left, a, b, 0);
        }
        return retVal;
    }
}
