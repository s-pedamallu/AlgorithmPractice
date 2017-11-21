package airbnb;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PalindromePairs {
    public List<List<Integer>> palindromePairs(String[] words) {
        if(words == null || words.length == 0) {
            return Collections.emptyList();
        }
        Map<String, Integer> wordMap = new HashMap<>();
        for(int i=0; i<words.length; i++) {
            wordMap.put(words[i], i);
        }
        List<List<Integer>> result = new ArrayList<>();
        for(int i=0; i<words.length; i++) {
/*            StringBuilder sb = new StringBuilder(words[i]);
            String rev = sb.reverse().toString();
            if(wordMap.containsKey(rev) && !rev.equals(words[i])) {
                result.add(Arrays.asList(i, wordMap.get(rev)));
            }*/
            
            for(int j=0; j<=words[i].length(); j++) {
            	String pre = words[i].substring(0, j);
            	String suf = words[i].substring(j);
            	if(isPalindrome(pre)) {
            		StringBuilder sb = new StringBuilder(suf).reverse();
            		if(wordMap.containsKey(sb.toString()) && wordMap.get(sb.toString()) != i) {
            			result.add(Arrays.asList(wordMap.get(sb.toString()), i));            			
            		}
            	} 
            	if(isPalindrome(suf)) {
            		StringBuilder sb = new StringBuilder(pre).reverse();
            		if(wordMap.containsKey(sb.toString()) && !suf.isEmpty() && wordMap.get(sb.toString())!=i) {
            			result.add(Arrays.asList(i, wordMap.get(sb.toString())));            			
            		}
            	}
            }
        }
        return result;
    }

    private boolean isPalindrome(String s) {
        int l = 0;
        int r = s.length()-1;
        while(l<r) {
            if(s.charAt(r--) != s.charAt(l++)) {
                return false;
            }
        }
        return true;
    }
}