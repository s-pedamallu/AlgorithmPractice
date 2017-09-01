package testhelper;

import java.util.LinkedList;

import iterators.BSTIterator.TreeNode;

public class TestTreeHelper {

	public static TreeNode buildTreeFromArray(Integer[] arr) {
		if (arr == null || arr.length == 0) {
			return null;
		}
		LinkedList<TreeNode> q = new LinkedList<TreeNode>();
		TreeNode root = new TreeNode(arr[0]);
		q.offerLast(root);
		int count = 1;
		while(count<arr.length) {
			TreeNode node = q.pollFirst();
			if(arr[count++] != null) {
				TreeNode left = new TreeNode(arr[count-1]);
				node.left = left;
				q.offerLast(left);
			}
			if(arr[count++] != null) {
				TreeNode right = new TreeNode(arr[count-1]);
				node.right = right;
				q.offerLast(right);
			}
		}
		return root;
	}
}
