package dynamicprogramming;

public class DecodeStringWithRegex {
    private static final int MOD = 1000000007;
    public int numDecodings(String s) {
        if(s == null || s.length() == 0) {
            return 0;
        }
        int[] dp = new int[s.length()+1];
        dp[0] = 1;
        if(s.charAt(0) == '0') {
            dp[1] = 0;
        } else if(s.charAt(0) == '*') {
            dp[1] = 9;
        } else {
            dp[1] = 1;
        }
        for(int i=2; i<=s.length(); i++) {
            char c1 = s.charAt(i-1);
            char c2 = s.charAt(i-2);
            if(c1 == '*') {
                addToIdx(dp, i, dp[i-1]*9l);
                //dp[i] += dp[i-1]*9;
            } else if(c1 != '0') {
                addToIdx(dp, i, dp[i-1]);
                //dp[i] += dp[i-1];
            }
            
            // two-char possibilities
/*            if(c2 == '*' && c1 == '*') {
            	addToIdx(dp, i, dp[i-2]*15l);
            } else if(c2 != '*' && c1 != '*') {
            	if(c2=='1' || (c2=='2' && c1-'0'<=6)) {
                    addToIdx(dp, i, dp[i-2]);
            	}
            } else if(c2 == '*') {
            	if(c1-'0' <= 6) {
                    addToIdx(dp, i, dp[i-2]*2l);
                } else {
                    addToIdx(dp, i, dp[i-2]);                    
                }
            } else {
            	if(c2=='1') {
            		addToIdx(dp, i, dp[i-2]*9l);
            	} else if(c2=='2') {
            		addToIdx(dp, i, dp[i-2]*6l);
            	}
            }*/
            if(c2 == '*') {
                if(c1 == '*') {
                    addToIdx(dp, i, dp[i-2]*15l);
                } else if(c1-'0' <= 6) {
                    addToIdx(dp, i, dp[i-2]*2l);
                } else {
                    addToIdx(dp, i, dp[i-2]);                    
                }
            } else if(c2 != '0') {
                if(c1 == '*' && c2=='1') {
                    addToIdx(dp, i, dp[i-2]*9l);
                } else if(c1=='*' && c2=='2') {
                    addToIdx(dp, i, dp[i-2]*6l);
                } else if(c1!='*' && (c2=='1' || (c2=='2' && c1-'0'<=6))) {
                    addToIdx(dp, i, dp[i-2]);
                } 
            }
        }
        return dp[s.length()];
    }
    
    private void addToIdx(int[] dp, int i, long val) {
        val %= MOD;
        dp[i] = (int) (dp[i]+val)%MOD;
    }
}
