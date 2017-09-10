package trees;

import java.util.ArrayList;
import java.util.List;

import iterators.BSTIterator.TreeNode;

public class LeavesList {
	/**
	 * Definition for a binary tree node.
	 * public class TreeNode {
	 *     int val;
	 *     TreeNode left;
	 *     TreeNode right;
	 *     TreeNode(int x) { val = x; }
	 * }
	 */
	public List<List<Integer>> findLeaves(TreeNode root) {
		List<List<Integer>> result = new ArrayList<>();
		getHeightAndAddLeaves(root, result);
		return result;
	}

	private int getHeightAndAddLeaves(TreeNode node, List<List<Integer>> l) {
		if (node == null) {
			return -1;
		}
		int curLevel = Math.max(getHeightAndAddLeaves(node.left, l), getHeightAndAddLeaves(node.right, l)) + 1;
		if (curLevel < l.size()) {
			List<Integer> existing = l.get(curLevel);
			existing.add(node.val);
		} else {
			List<Integer> now = new ArrayList<>();
			now.add(node.val);
			l.add(now);
		}
		return curLevel;
	}

}
