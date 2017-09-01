package linkedlists;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import linkedlists.AddNumbers.ListNode;
import testhelper.TestLinkedListHelper;

public class AddNumbersTest {
	private AddNumbers src;

	@Before
	public void init() {
		src = new AddNumbers();
	}

	@Test
	public void test1() {
		int[] input = {2,3,4};
		int[] expected = {4,3,2};
		assertTrue(TestLinkedListHelper.areEqualLists(TestLinkedListHelper.buildListFromArray(expected),
				src.reverseListInPlace(TestLinkedListHelper.buildListFromArray(input), null)));
	}

	@Test
	public void test2() {
		int[] one = {4,5,6};
		int[] two = {1,2,3,4};
		int[] expected = {1,6,9,0};
		ListNode l1 = TestLinkedListHelper.buildListFromArray(one);
		ListNode l2 = TestLinkedListHelper.buildListFromArray(two);
		ListNode el = TestLinkedListHelper.buildListFromArray(expected);
		assertTrue(TestLinkedListHelper.areEqualLists(el, src.addTwoNumbers(l1, l2)));
		assertTrue(TestLinkedListHelper.areEqualLists(TestLinkedListHelper.buildListFromArray(one), l1));
	}

	@Test
	public void test3() {
		int[] one = {2,4,3};
		int[] two = {5,6,4};
		int[] expected = {7,0,8};
		ListNode l1 = TestLinkedListHelper.buildListFromArray(one);
		ListNode l2 = TestLinkedListHelper.buildListFromArray(two);
		ListNode el = TestLinkedListHelper.buildListFromArray(expected);
		assertTrue(TestLinkedListHelper.areEqualLists(el, src.addTwoNumbers(l1, l2)));
		assertTrue(TestLinkedListHelper.areEqualLists(TestLinkedListHelper.buildListFromArray(one), l1));
	}
}
