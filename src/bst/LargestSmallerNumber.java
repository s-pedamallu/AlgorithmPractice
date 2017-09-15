package bst;

import iterators.BSTIterator.TreeNode;

public class LargestSmallerNumber {

	public int getLargestSmallerNumber(TreeNode root, int num) {
		int result = -1;
		while(root != null) {
			if(num > root.val) {
				result = root.val;
				root = root.right;
			} else {
				root = root.left;
			}
		}
		return result;
	}
}
