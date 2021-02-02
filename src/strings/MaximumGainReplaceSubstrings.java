package strings;

public class MaximumGainReplaceSubstrings {
    public int maximumGain(String s, int x, int y) {
        return backtrack(s, x, y, 0);
    }
    
    private int backtrack(String s, int x, int y, int max) {
        int i = s.indexOf("ab");
        int j = s.indexOf("ba");
        if(i>=0 && i<s.length()-1) {
            max = Math.max(backtrack(s.substring(0,i)+s.substring(i+2), x, y, max+x), max);
        } 
        if (j>=0 && j<s.length()-1) {
            max = Math.max(backtrack(s.substring(0,j)+s.substring(j+2), x, y, max+y), max);
        }
        return max;
    }
}
