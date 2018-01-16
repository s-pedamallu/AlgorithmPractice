package trees;

import iterators.BSTIterator.TreeNode;

public class Diameter {
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int[] ans = deepestElement(root, 0);
        return ans[1];
    }

    private int[] deepestElement(TreeNode n, int depth) {
        int[] min = new int[]{depth,0};
        if(n == null) {
            return min;
        }
        int[] l = min;
        int[] r = min;
        if(n.left != null) {
            l = deepestElement(n.left, depth+1);
        }
        if(n.right != null) {
            r = deepestElement(n.right, depth+1);
        }
        return new int[]{Math.max(l[0], r[0]), Math.max(l[0]+r[0]-2*depth, Math.max(l[1], r[1]))};
    }
}
