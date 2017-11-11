package dfs;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CharOrder {
    public String alienOrder(String[] words) {
        if(words == null || words.length==0) {
            return "";
        }
        Map<Character, Set<Character>> map = new HashMap<>();
        Set<Character> allChars = new HashSet<>();
        addChars(allChars, words[0]);
        for(int i=0; i<words.length-1; i++) {
            addChars(allChars, words[i+1]);
            int idx = diffIndex(words[i], words[i+1]);
            if(idx!=-1) {
            	if(isAncestor(map, words[i].charAt(idx), words[i+1].charAt(idx))) {
            		return "";
            	}
                Set<Character> chars = map.getOrDefault(words[i+1].charAt(idx), new HashSet<>());
                chars.add(words[i].charAt(idx));
                map.put(words[i+1].charAt(idx), chars);
            }
        }
        String ans = getOrderedChars(map, allChars);
        if(ans.length() == allChars.size()) {
            return ans;
        } else {
            return "";
        }
    }

	private String getOrderedChars(Map<Character, Set<Character>> map, Set<Character> allChars) {
		StringBuilder sb = new StringBuilder();
		Set<Character> visited = new HashSet<>();
		for (char c : allChars) {
			if (!visited.contains(c)) {
				visited.add(c);
				if (map.containsKey(c)) {
					for (char p : map.get(c)) {
						if (!visited.contains(p)) {
							getParents(map, p, visited, sb);
						}
					}
				}
				sb.append(c);
			}
		}
		return sb.toString();
	}
    
	private void getParents(Map<Character, Set<Character>> map, char c, Set<Character> visited, StringBuilder sb) {
		visited.add(c);
		if (map.containsKey(c)) {
			for (Character p : map.get(c)) {
				if (!visited.contains(p)) {
					getParents(map, p, visited, sb);
				}
			}
		}
		sb.append(c);
	}

	private boolean isAncestor(Map<Character, Set<Character>> map, char c, char p) {
		if(p == c) {
			return true;
		}
		if(map.containsKey(c)) {
			for(Character a : map.get(c)) {
				if(isAncestor(map, a, p)) {
					return true;
				}
			}
		}
		return false;
	}
    private int diffIndex(String s1, String s2) {
        int l = Math.min(s1.length(), s2.length());
        int ans = -1;
        for(int i=0; i<l; i++) {
            if(s1.charAt(i)!=s2.charAt(i)) {
                ans = i;
                break;
            }
        }
        return ans;
    }
    
    private void addChars(Set<Character> set, String s) {
        for(int i=0; i<s.length(); i++) {
            set.add(s.charAt(i));
        }        
    }
}
