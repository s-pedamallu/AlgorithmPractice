package trees;

import iterators.BSTIterator.TreeNode;

public class TreeFromTraversals {

	public TreeNode buildTreeFromTraversals(int[] preOrder, int[] inOrder) {
		if(preOrder.length == 0 || inOrder.length == 0) {
			return null;
		}
		return buildTreeRecursively(preOrder, 0, preOrder.length-1, inOrder, 0, inOrder.length-1);
	}

	private TreeNode buildTreeRecursively(int[] preOrder, int s1, int e1, int[] inOrder, int s2, int e2) {
		if (s1 >= preOrder.length || e1 < 0 || s2 >= inOrder.length || e2 < 0) {
			return null;
		}
		TreeNode root = new TreeNode(preOrder[s1]);
		int rootIdxInOrder = getIdx(inOrder, preOrder[s1]);
		int numLeftElems = rootIdxInOrder - s2;
		int numRightElems = e2 - rootIdxInOrder;
		root.left = numLeftElems > 0
				? buildTreeRecursively(preOrder, s1 + 1, s1 + numLeftElems, inOrder, s2, rootIdxInOrder - 1) : null;
		root.right = numRightElems > 0 ? buildTreeRecursively(preOrder, s1 + numLeftElems + 1,
				s1 + numLeftElems + numRightElems - 1, inOrder, rootIdxInOrder + 1, e2) : null;
		return root;
	}

	private int getIdx(int[] arr, int elem) {
		for(int i=0; i<arr.length; i++) {
			if(arr[i] == elem) return i;
		}
		return -1;
	}
}
