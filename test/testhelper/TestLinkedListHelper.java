package testhelper;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.util.Arrays;
import java.util.List;

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

	public static void validateListsNoOrder(List<List<Integer>> exp, List<List<Integer>> act) {
		assertEquals(exp.size(), act.size());
		for(int i=0; i<exp.size(); i++) {
			Object[] earr = exp.get(i).toArray();
			boolean found = false;
			for(int j=0; j<act.size(); j++) {
				Object[] aarr = act.get(j).toArray();
				if(Arrays.deepEquals(earr, aarr)) {
					found = true;
					break;
				}
			}
			if(!found) {
				assertFalse("Not found "+exp.get(i)+" in the result", true);
			}
		}
	}

	public static void validateListsInOrder(List<List<Integer>> exp, List<List<Integer>> act) {
		assertEquals("Size of the expected array did not match with the actual output array", exp.size(), act.size());
		for (int i = 0; i < exp.size(); i++) {
			Object[] earr = exp.get(i).toArray();
			Object[] aarr = act.get(i).toArray();
			if (!Arrays.deepEquals(earr, aarr)) {
				assertFalse("Expected " + exp.get(i) + ", but found " + act.get(i) + " at pos " + i, true);
				break;
			}
		}
	}
}
