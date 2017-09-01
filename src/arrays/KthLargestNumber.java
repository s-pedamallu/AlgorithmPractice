package arrays;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KthLargestNumber {
	public int findKthLargest(int[] nums, int k) {
		if (nums == null || nums.length == 0 || k < 0 || k > nums.length) {
			return 0;
		}
		PriorityQueue<Integer> pq = new PriorityQueue<>(k, new IntegerComparator());
		for (int num : nums) {
			if (pq.size() < k) {
				pq.add(num);
			} else if (pq.peek() < num) {
				pq.poll();
				pq.add(num);
			}
		}
		return pq.poll();
	}

	private static class IntegerComparator implements Comparator<Integer> {

		@Override
		public int compare(Integer o1, Integer o2) {
			return o1.compareTo(o2);
		}

	}
}
