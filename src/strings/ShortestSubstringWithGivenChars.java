package strings;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class ShortestSubstringWithGivenChars {
	public String substringWithChars(String str, char[] arr) {
		if (arr == null || arr.length == 0 || str == null || str.isEmpty()) {
			return "";
		}
		Set<Character> reqSet = new HashSet<>();
		for (int i = 0; i < arr.length; i++) {
			reqSet.add(arr[i]);
		}
		int l = 0;
		int r = 0;
		String ans = "";
		HashMap<Character, Integer> cCount = new HashMap<>();
		while (l <= r && r < str.length()) {
			while (r < str.length() && cCount.size() < arr.length) {
				char c = str.charAt(r);
				if (reqSet.contains(c)) {
					int count = cCount.containsKey(c) ? cCount.get(c) : 0;
					cCount.put(c, count + 1);
				}
				r++;
			}
			while (cCount.size() == arr.length) {
				char c = str.charAt(l);
				if (reqSet.contains(c)) {
					int count = cCount.get(c);
					if (count == 1) {
						cCount.remove(c);
					} else {
						cCount.put(c, count - 1);
					}
				}
				l++;
			}
			if ((ans.isEmpty() || ans.length() > r - l) && l > 0) {
				ans = str.substring(l - 1, r);
				if (ans.length() == arr.length) {
					break;
				}
			}
		}
		return ans;
	}

}
