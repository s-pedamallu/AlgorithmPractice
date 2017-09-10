package linkedlists;

public class RandomList {

	class RandomListNode {
		int label;
		RandomListNode next, random;

		RandomListNode(int x) {
			this.label = x;
		}
	};

	public class Solution {
		public RandomListNode copyRandomList(RandomListNode head) {
			int totalElems = getTotalElems(head);
			RandomListNode cloneHead = cloneList(head);
			assignRandomNodes(cloneHead, head, totalElems);
			return cloneHead;
		}

		private int getTotalElems(RandomListNode node) {
			if (node == null) {
				return 0;
			}
			return 1 + getTotalElems(node.next);
		}

		private RandomListNode cloneList(RandomListNode node) {
			if (node == null) {
				return null;
			}
			RandomListNode clone = new RandomListNode(node.label);
			clone.next = cloneList(node.next);
			return clone;
		}

		private RandomListNode getKthElement(RandomListNode node, int k) {
			if (node == null || k == 0) {
				return node;
			}
			return getKthElement(node.next, k - 1);
		}

		private void assignRandomNodes(RandomListNode clone, RandomListNode orig, int totalElems) {
			if (clone == null) {
				return;
			}
			int count = 0;
			RandomListNode cur = clone;
			RandomListNode ocur = orig;
			while (count < totalElems) {
				RandomListNode onext = ocur.random;
				int k = totalElems - getTotalElems(onext);
				cur.random = getKthElement(clone, k);
				cur = cur.next;
				ocur = ocur.next;
				count++;
			}
		}
	}
}
