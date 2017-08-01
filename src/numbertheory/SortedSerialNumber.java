package numbertheory;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SortedSerialNumber {

    public static final int MOD = 1000003;
	public int findRank(String a) {
		a = a.toLowerCase();
	    char[] arr = new char[a.length()];
	    for(int i=0; i<a.length(); i++) {
	        arr[i] = a.charAt(i);
	    }
	    Arrays.sort(arr);
	    Map<Character, Integer> oMap = new HashMap<>();
	    Map<Character, Integer> sMap = new HashMap<>();
	    for(int i=0; i<a.length(); i++) {
	        oMap.put(a.charAt(i), i);
	        sMap.put(arr[i], i);
	    }

        int ans = 1;
        int ref = 0;
        for(int i=0; i<a.length(); i++) {
            int m = oMap.get(arr[ref]);
//            int n = 
            if(i<m) {
                int n = sMap.get(a.charAt(i));
                int remLength = a.length()-i-1;
                ans+= (n-ref) * numPerms(remLength);
                ans %= MOD;
            } else {
            	ref++;
            }
        }
        return ans;
	}

	private int numPerms(int a) {
		if(a<1) {
			return 0;
		} else if(a==1) {
			return 1;
		} else {
			return a*(a-1);
		}
	}
}
