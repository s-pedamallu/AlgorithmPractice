package trees;

import java.util.ArrayList;
import java.util.List;

import iterators.BSTIterator.TreeNode;

public class ZigZagLevelOrder {

	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        evenLevelNodes(root, 0, result);
        oddLevelNodes(root, 0, result);
        return result;
    }

	private void evenLevelNodes(TreeNode n, int curLevel, List<List<Integer>> result) {
		if(n == null) return;
		List<Integer> l = result.size()>curLevel ? result.get(curLevel) : new ArrayList<>();
		if((curLevel & 1) == 0) {
			l.add(n.val);
		}
		if(curLevel<result.size()) {
			result.set(curLevel, l);
		} else {
			result.add(l);
		}
		evenLevelNodes(n.left, curLevel+1, result);
		evenLevelNodes(n.right, curLevel+1, result);
	}

	private void oddLevelNodes(TreeNode n, int curLevel, List<List<Integer>> result) {
		if(n == null) return;
		List<Integer> l = result.size()>curLevel ? result.get(curLevel) : new ArrayList<>();
		if((curLevel & 1) == 1) {
			l.add(n.val);
			if(curLevel<result.size()) {
				result.set(curLevel, l);
			} else {
				result.add(l);
			}
		}		
		oddLevelNodes(n.right, curLevel+1, result);
		oddLevelNodes(n.left, curLevel+1, result);
	}
}