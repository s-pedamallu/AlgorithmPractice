package testhelper;

import linkedlists.AddNumbers.ListNode;

public class TestLinkedListHelper {

	public static ListNode buildListFromArray(int[] arr) {
		if(arr == null || arr.length==0) {
			return null;
		}
		ListNode prev = null;
		for(int i=arr.length-1; i>=0; i--) {
			ListNode n = new ListNode(arr[i]);
			n.next = prev;
			prev = n;
		}
		return prev;
	}

	public static boolean areEqualLists(ListNode l1, ListNode l2) {
		if(l1==null && l2==null) {
			return true;
		} else if(l1==null || l2==null) {
			return false;
		} else {
			return areEqualLists(l1.next, l2.next) ? l1.val==l2.val : false;
		}
	}

}
