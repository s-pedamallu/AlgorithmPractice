package trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import iterators.BSTIterator.TreeNode;

public class VerticalOrder {

    public List<List<Integer>> verticalOrder(TreeNode root) {
        int[] cols = colInfo(root, 0);
        int total = cols[1]-cols[0]+1;
        List<List<Integer>> result = new ArrayList<>(total);
        for(int i=0; i<total; i++) {
            result.add(new ArrayList<>());
        }
        LinkedList<BFSNode> q = new LinkedList<>();
        int curCol = 0-cols[0];
        q.add(new BFSNode(root, curCol));
        while(!q.isEmpty()) {
            BFSNode node = q.poll();
            if(node.n == null) {
                continue;
            }
            List<Integer> l = result.get(node.col);
            l.add(node.n.val);
            q.add(new BFSNode(node.n.left, node.col-1));
            q.add(new BFSNode(node.n.right, node.col+1));
        }
        return result;
    }

    private int[] colInfo(TreeNode root, int curCol) {
        if(root == null) {
            return new int[] {0, 0};
        }
        int[] l = colInfo(root.left, curCol-1);
        int[] r = colInfo(root.right, curCol+1);
        int min = Math.min(Math.min(l[0],l[1]), Math.min(r[0],r[1]));
        min = Math.min(min, curCol);
        int max = Math.max(Math.max(l[0],l[1]), Math.max(r[0],r[1]));
        max = Math.max(max, curCol);
        return new int[]{min, max};
    }
    
    private class BFSNode {
        TreeNode n;
        int col;
        
        BFSNode(TreeNode n, int c) {
            this.n = n;
            this.col = c;
        }
    }

}
