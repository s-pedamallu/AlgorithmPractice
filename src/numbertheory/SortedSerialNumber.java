package numbertheory;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SortedSerialNumber {

    public static final int MOD = 1000003;
    private static Map<Integer, Integer> factMap = new HashMap<>();

	public int findRank(String s) {
		int ans = 1;
		factMap.put(1, 1);
		for(int i=0; i<s.length(); i++) {
			char[] arr = s.substring(i).toCharArray();
			Arrays.sort(arr);
			int times = charPos(arr, s.charAt(i));
			int remLength = s.length()-i-1;
			if(times == 0 || remLength==0) {
				continue;
			}
			int add = times*numPerms(remLength);
			ans=(ans+add)%MOD;
		}
		return ans;
	}

	private int charPos(char[] arr, char c) {
		for(int i=0; i<arr.length; i++) {
			if(arr[i]==c){
				return i;
			}
		}
		return -1;
	}

	private int numPerms(int a) {
		if(factMap.containsKey(a)) {
			return factMap.get(a);
		} else {
			int result = (a*numPerms(a-1))%MOD;
			factMap.put(a, result);
			return result;
		}
	}
}
