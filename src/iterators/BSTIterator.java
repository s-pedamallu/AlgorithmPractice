package iterators;

import java.util.Stack;


public class BSTIterator {

	public static class TreeNode {
		public int val;
		public TreeNode left;
		public TreeNode right;

		public TreeNode(int x) {
			val = x;
		}

		public String toString() {
			return String.valueOf(val);
		}
	}
	 
	private Stack<TreeNode> heightStack;

	public BSTIterator(TreeNode root) {
		heightStack = new Stack<>();
		addNodeToStack(root);
	}

	/** @return whether we have a next smallest number */
	public boolean hasNext() {
		return !heightStack.isEmpty();
	}

	private void addNodeToStack(TreeNode n) {
		if (n != null) {
			heightStack.push(n);
			addNodeToStack(n.left);
		}
	}

	/** @return the next smallest number */
	public int next() {
		if(!hasNext()) {
			return 0;
		}
		TreeNode top = heightStack.pop();
		addNodeToStack(top.right);
		return top.val;
	}

}
