package strings;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MinimumWindow {
    public String minWindow(String s, String t) {
        if(s==null || t == null || s.length()==0 || t.length()==0) {
            return "";
        }
        Map<Character, Integer> req = new HashMap<>();
        Map<Character, Integer> act = new HashMap<>();
        for(int i=0; i<t.length(); i++) {
            int c = req.getOrDefault(t.charAt(i), 0);
            req.put(t.charAt(i), c+1);
        }
        Set<Character> pending = new HashSet<>(req.keySet());
        int l = 0;
        int r = 0;
        String ans = "";
        while(r<s.length()) {
            while(r<s.length() && !pending.isEmpty()) {
                if(req.keySet().contains(s.charAt(r))) {
                    int prev = act.getOrDefault(s.charAt(r), 0);
                    act.put(s.charAt(r), prev+1);
                    if(act.get(s.charAt(r)) >= req.get(s.charAt(r))) {
                        pending.remove(s.charAt(r));
                    }
                }
                r++;
            }
            while(l<s.length() && pending.isEmpty()) {
            	if(ans.isEmpty() || ans.length()>(r-l)) {
            		ans = s.substring(l, r);
            	}
                if(ans.length() == t.length()) {
                    return ans;
                }
                if(act.keySet().contains(s.charAt(l))) {
                    int prev = act.get(s.charAt(l));
                    act.put(s.charAt(l), prev-1);
                    if(act.getOrDefault(s.charAt(l), 0) < req.get(s.charAt(l))) {
                        pending.add(s.charAt(l));
                    }
                }
                l++;
            }
        }
        return ans;
    }
}
