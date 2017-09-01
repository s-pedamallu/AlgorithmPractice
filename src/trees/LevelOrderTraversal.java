package trees;

import java.util.ArrayList;
import java.util.List;

import iterators.BSTIterator.TreeNode;

public class LevelOrderTraversal {
	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> result = new ArrayList<>();
		getLevelOrderResult(root, result, 0);
		return result;
	}

	private void getLevelOrderResult(TreeNode node, List<List<Integer>> result, int curLevel) {
		if (node == null) {
			return;
		}
		List<Integer> ls = result.size()<=curLevel ? new ArrayList<>() : result.get(curLevel);
		ls.add(node.val);
		if(result.size()<=curLevel)  
			result.add(ls);
		else
			result.set(curLevel, ls);
		getLevelOrderResult(node.left, result, curLevel+1);
		getLevelOrderResult(node.right, result, curLevel+1);
	}

}
