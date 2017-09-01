package linkedlists;

public class AddNumbers {
	public static class ListNode {
		public int val;
		public ListNode next;

		public ListNode(int x) {
			val = x;
		}

		@Override
		public String toString() {
			return val + " -> " + next;
		}
	}

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode rev1 = reverseListInPlace(l1, null);
		ListNode rev2 = reverseListInPlace(l2, null);
		ListNode ans = addNumbers(rev1, rev2, null, 0);
		l1 = reverseListInPlace(rev1, null);
		l2 = reverseListInPlace(l2, null);
		return ans;
	}

	public ListNode reverseListInPlace(ListNode l, ListNode prev) {
		if(l == null) {
			return prev;
		}
		ListNode head = reverseListInPlace(l.next, l);
		l.next = prev;
		return head;
	}

	private ListNode addNumbers(ListNode l1, ListNode l2, ListNode prev, int carry) {
		if(l1 == null && l2 == null) {
			if(carry == 0) {
				return prev;
			}
			ListNode head = new ListNode(carry);
			head.next = prev;
			return head;
		}
		int one = l1==null ? 0 : l1.val;
		int two = l2==null ? 0 : l2.val;
		int sum = one+two+carry;
		ListNode l = new ListNode(sum%10);
		l.next = prev;
		return addNumbers(l1==null ? null : l1.next, l2==null ? null : l2.next, l, sum/10);
	}
}
