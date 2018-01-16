package dynamicprogramming;

public class DecodeString {
    public int numDecodings(String s) {
        if(s == null || s.length() == 0) {
            return 0;
        }
        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        dp[1] = s.charAt(0) == '0' ? 0 : 1;
        for(int i=2; i<=s.length(); i++) {
            int oneChar = Integer.valueOf(s.substring(i-1,i));
            int twoChars = Integer.valueOf(s.substring(i-2, i));
            if(oneChar > 0) {
                dp[i] += dp[i-1];
            }
            if(twoChars>=10 && twoChars <= 26) {
                dp[i] += dp[i-2];
            }
        }
        return dp[s.length()];
    }
}