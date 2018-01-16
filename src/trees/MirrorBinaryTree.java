package trees;

import iterators.BSTIterator.TreeNode;

public class MirrorBinaryTree {

	public TreeNode getMirrorTree(TreeNode root) {
		return getMirrorTreeRecursive(root);
	}

	private TreeNode getMirrorTreeRecursive(TreeNode node) {
		if(node == null) {
			return null;
		}
		TreeNode result = new TreeNode(node.val);
		result.left = getMirrorTreeRecursive(node.right);
		result.right = getMirrorTreeRecursive(node.left);
		return result;
	}
}
