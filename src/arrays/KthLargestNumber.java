package arrays;

import java.util.PriorityQueue;
import java.util.Random;

public class KthLargestNumber {
	public int findKthLargest2(int[] nums, int k) {
		if (nums == null || nums.length == 0 || k < 0 || k > nums.length) {
			return 0;
		}
		PriorityQueue<Integer> pq = new PriorityQueue<>();
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

	public int findKthLargest(int[] nums, int k) {
		if (nums == null || nums.length == 0 || k < 0 || k > nums.length) {
			return 0;
		}
		return findKthLargest(nums, k, 0, nums.length-1);
	}

	private int findKthLargest(int[] nums, int k, int from, int to) {
		Random rand = new Random();
		System.out.println("from: "+from+" to: "+to);
		int rIdx = from+rand.nextInt(to-from+1);
		System.out.print("Pivot: "+nums[rIdx]+" at idx: "+rIdx+" before partition: ");
		printArr(nums);
		swap(nums, rIdx, to);
		int i = from-1;
		int j = from;
		while(j < to) {
			if(nums[j]<nums[to]) {
				i++;
				swap(nums, i, j);
			}
			j++;
		}
		swap(nums, i+1, to);
		int pivotIdx = i+1;
		System.out.print("pivotIdx: "+pivotIdx+" After partition: ");
		printArr(nums);
		int desiredIdx = nums.length-k; 
		if(pivotIdx == desiredIdx) {
			printArr(nums);
			return nums[pivotIdx];			
		}
		if(pivotIdx > desiredIdx) {
			return findKthLargest(nums, k, from, pivotIdx-1);
		} else {
			return findKthLargest(nums, k, pivotIdx+1, to);
		}
	}

	private void swap(int[] arr, int idx1, int idx2) {
		int t = arr[idx1];
		arr[idx1] = arr[idx2];
		arr[idx2] = t;
	}

	private void printArr(int[] nums) {		
		for(int num: nums) {
			System.out.print(num+" ");
		}
		System.out.println();
	}
}
