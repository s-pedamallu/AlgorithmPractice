package testhelper;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

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
			if(count<arr.length && arr[count++] != null) {
				TreeNode right = new TreeNode(arr[count-1]);
				node.right = right;
				q.offerLast(right);
			}
		}
		return root;
	}

	public static Integer[] buildArrayFromTree(TreeNode tree) {
		List<Integer> list = new ArrayList<>();
		LinkedList<TreeNode> q = new LinkedList<>();
		q.addLast(tree);
		while(!q.isEmpty()) {
			TreeNode n = q.removeFirst();
			if(n == null) {
				list.add(null);
				continue;
			}
			list.add(n.val);
			q.addLast(n.left);
			q.addLast(n.right);
		}
		// Delete trailing nulls
		while(list.get(list.size()-1) == null) {
			list.remove(list.size()-1);
		}
		Integer[] result = new Integer[list.size()];
		for(int i=0; i<list.size(); i++) {
			result[i] = list.get(i);
		}
		return result;
	}
}
