package trees;

import iterators.BSTIterator.TreeNode;

public class InorderSuccessor {

    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        TreeNode ans = null;
        if(p.right != null) {
            ans = p.right;
            while(ans.left != null) {
                ans = root.left;
            }
        } else {            
            while(root!=null && (root.left!=p || root.right!=p)) {
                if(p.val < root.val) {
                    ans = root;
                    root = root.left;
                } else {
                    root = root.right;
                }
            }
        }
        return ans;
    }
}
