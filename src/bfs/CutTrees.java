package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class CutTrees {


	public int cutOffTree(List<List<Integer>> forest) {
		long start = System.currentTimeMillis();
		int ans = 0;
        List<Integer> nums = new ArrayList<>();        
        sortNumbers(forest, nums);
        int rpos = 0;
        int cpos = 0;
		for(int i=0; i<nums.size(); i++) {
			Node cur = getNode(forest, rpos, cpos, nums.get(i));
			if(cur == null) {
				break;
			}
			ans += cur.steps;
			List<Integer> row = forest.get(cur.r);
			row.set(cur.c, 1);
			rpos = cur.r;
			cpos = cur.c;
		}
		
		if (!isValid(forest)) {
			ans = -1;
		}
		long timeTaken = System.currentTimeMillis() - start;
		System.out.println("Time taken: "+timeTaken+" msecs");
		return ans;
	}

    private void sortNumbers(List<List<Integer>> forest, List<Integer> nums) {
        for(List<Integer> row: forest) {
            for(Integer tree : row) {
                if(tree > 1) {
                    nums.add(tree);
                }
            }
        }
        Collections.sort(nums);
    }

	private Node getNode(List<List<Integer>> forest, int r, int c, int dval) {
		Node n = new Node(r, c, 0);
		LinkedList<Node> q = new LinkedList<>();
		Set<Node> visited = new HashSet<>();
		q.add(n);
		visited.add(n);
		while (!q.isEmpty()) {
			Node cur = q.removeFirst();
			int val = getVal(forest, cur.r, cur.c);
			if (val < 1) {
				continue;
			}
            if (val == dval) {
                return cur;
            }
			Node left = new Node(cur.r, cur.c - 1, cur.steps + 1);
			Node right = new Node(cur.r, cur.c + 1, cur.steps + 1);
			Node up = new Node(cur.r - 1, cur.c, cur.steps + 1);
			Node down = new Node(cur.r + 1, cur.c, cur.steps + 1);
			if (!visited.contains(left)) {
				visited.add(left);
				q.addLast(left);
			}
			if (!visited.contains(right)) {
				visited.add(right);
				q.addLast(right);
			}
			if (!visited.contains(up)) {
				visited.add(up);
				q.addLast(up);
			}
			if (!visited.contains(down)) {
				visited.add(down);
				q.addLast(down);
			}
		}
		return null;
	}

	private int getVal(List<List<Integer>> forest, int r, int c) {
		if (r < 0 || r >= forest.size()) {
			return -1;
		}
		List<Integer> row = forest.get(r);
		if (c < 0 || c >= row.size()) {
			return -1;
		}
		return row.get(c);
	}

	private static class Node {
		int r;
		int c;
		int steps;

		// int v;
		public Node(int r, int c, int s) {
			this.r = r;
			this.c = c;
			this.steps = s;
		}

		@Override
		public String toString() {
			return this.r+" "+this.c+" "+this.steps;
		}

		@Override
		public boolean equals(Object o) {
			if (o instanceof Node) {
				Node other = (Node) o;
				return this.r == other.r && this.c == other.c;
			}
			return false;
		}

		@Override
		public int hashCode() {
			return 31 + 11 * r + 11 * c;
		}
	}

	private boolean isValid(List<List<Integer>> forest) {
		if (forest == null) {
			return true;
		} else if (forest.isEmpty()) {
			return true;
		}
		for (List<Integer> row : forest) {
			for (Integer i : row) {
				if (i != 0 && i != 1) {
					return false;
				}
			}
		}
		return true;
	}

	public static void main(String[] a) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		List<List<Integer>> list = new ArrayList<>();
		String line = br.readLine();
		while(line != null && !line.isEmpty()) {
			String[] tokens = line.split(" ");
			List<Integer> nums = new ArrayList<>();
			for(int i=0; i<tokens.length; i++) {
				nums.add(Integer.valueOf(tokens[i]));
			}
			list.add(nums);
			line = br.readLine();
		}
		CutTrees obj = new CutTrees();
		System.out.println(obj.cutOffTree(list));
	}
}
