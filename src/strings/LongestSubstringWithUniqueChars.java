package strings;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithUniqueChars {

	public int lengthOfLongestSubstring(String s) {
        int ans = 0;
        if(s==null || s.length() == 0) {
        	return ans;
        }
        int r = 0;
        int l = 0;
        Set<Character> set = new HashSet<>();
        while(r<s.length()) {
        	char c = s.charAt(r);
        	if(set.contains(c)) {
        		ans = Math.max(ans, set.size());
        		while(l<r && s.charAt(l)!=c) {
        			set.remove(s.charAt(l));
        			l++;
        		}
        		set.remove(s.charAt(l));
        		l++;
        	}
        	set.add(c);
        	r++;
        }
        ans = Math.max(ans, set.size());
        return ans;
    }
}
