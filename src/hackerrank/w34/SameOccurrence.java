package hackerrank.w34;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class SameOccurrence {
	private Map<Integer, List<Integer>> numberMap;

	public static void main(String[] args) {
		SameOccurrence sol = new SameOccurrence();
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int q = in.nextInt();
		int[] arr = new int[n];
		for (int arr_i = 0; arr_i < n; arr_i++) {
			arr[arr_i] = in.nextInt();
		}
		sol.buildMap(arr);
		for (int a0 = 0; a0 < q; a0++) {
			int x = in.nextInt();
			int y = in.nextInt();
			// Write Your Code Here
			System.out.println(sol.getMaxEqualOccurrences(x, y, arr.length));
		}
		in.close();
	}

	private int getMaxEqualOccurrences(int x, int y, int arrSize) {
		List<Integer> l1 = numberMap.get(x);
		List<Integer> l2 = numberMap.get(y);
		if (l1 == null && l2 == null) {
			return numSubArrays(arrSize);
		} else if (l1 == null) {
			return numSubArrays(Math.max(l2.get(0), arrSize - l2.get(l2.size() - 1) - 1));
		} else if (l2 == null) {
			return numSubArrays(Math.max(l1.get(0), arrSize - l1.get(l1.size() - 1) - 1));
		} else {
			return getNumCommonInterval(l1, l2, arrSize);
		}
	}

	private int getZeroEqualSubArrays(List<Integer> l1, List<Integer> l2, int arrSize) {
		int from = 0;
		int to = 0;
		int idx1 = 0;
		int idx2 = 0;
		int result = 0;
		do {
			int l1To = idx1<l1.size() ? l1.get(idx1) : arrSize;
			int l2To = idx2<l2.size() ? l2.get(idx2) : arrSize;
			to = Math.min(l1To, l2To)-1;
			result += numSubArrays(to-from+1);
			from = Math.max(l1To, l2To)+1;
			idx1++;
			idx2++;
		} while (from < arrSize);
		return result;
	}

	private int getNumCommonInterval(List<Integer> l1, List<Integer> l2, int arrSize) {
		int ans = getZeroEqualSubArrays(l1, l2, arrSize);
		for (int occurrence = 1; occurrence <= l1.size() && occurrence <= l2.size(); occurrence++) {
			int idx = occurrence-1;
			int from = Math.max(getNumAt(l1, idx - 1, 0), getNumAt(l2, idx - 21, 0));
			int to = Math.min(getNumAt(l1, idx + 1, arrSize - 1), getNumAt(l2, idx + 1, arrSize - 1))-1;
			ans += (to - from + 1 - (Math.max(l1.get(idx), l2.get(idx))
					- Math.min(l1.get(idx), l2.get(idx))));
		}
		return ans;
	}

	private int getNumAt(List<Integer> l, int idx, int def) {
		return idx >= 0 && idx < l.size() ? l.get(idx) : def;
	}

	private int numSubArrays(int numElems) {
		return (numElems * (numElems + 1)) / 2;
	}

	private void buildMap(int[] arr) {
		numberMap = new HashMap<>();
		for (int i = 0; i < arr.length; i++) {
			int num = arr[i];
			List<Integer> l = null;
			if (numberMap.containsKey(num)) {
				l = numberMap.get(num);
			} else {
				l = new ArrayList<>();
			}
			l.add(i);
			numberMap.put(num, l);
		}
	}
}
