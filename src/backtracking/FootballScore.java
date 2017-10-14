package backtracking;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class FootballScore {

	static int maxDepth = 0;
	static int americanFootball2(int score) {
	    Map<Integer, Integer> cache = new HashMap<>();
	    int ans =  helper2(score, cache, 0);
	    System.out.println("cache size: "+cache.size());
	    return ans;
	}

	static int helper2(int score, Map<Integer, Integer> cache, int depth) {
	    int MOD = 1000000007;
	    if(cache.containsKey(score)) {
	    	maxDepth = Math.max(depth, maxDepth);
	        return cache.get(score);
	    } else if(score < 0) {
	    	maxDepth = Math.max(depth, maxDepth);
	        return 0;
	    } else if(score == 0) {
	    	maxDepth = Math.max(depth, maxDepth);
	        return 1;
	    } else {
	        int ans = helper2(score-8, cache, depth+1) % MOD;	ans%=MOD; if(ans<0) System.out.println("Score1: "+score);
	        ans += helper2(score-7, cache, depth+1) % MOD; ans%=MOD; if(ans<0) System.out.println("Score2: "+score);
	        ans += helper2(score-6, cache, depth+1) % MOD; ans%=MOD; if(ans<0) System.out.println("Score3: "+score);
	        ans += helper2(score-3, cache, depth+1) % MOD; ans%=MOD; if(ans<0) System.out.println("Score4: "+score);
	        ans += helper2(score-2, cache, depth+1) % MOD; if(ans<0) System.out.println("Score5: "+score);
	        cache.put(score, ans%MOD);
	        return ans%MOD;
	    }
	}

	static int americanFootball(int score) {
	    Map<Integer, Integer> cache = new HashMap<>();
	    int ans = 0;
	    for(int i=2; i<=score; i++) {
	    	if(i == 45634) {
	    		System.out.println("NOP");
	    	}
	    	ans =  helper(i, cache, 0);
	    }
	    
	    System.out.println("cache size: "+cache.size());
	    return ans;
	}

	static int helper(int score, Map<Integer, Integer> cache, int depth) {
	    int MOD = 1000000007;
	    if(cache.containsKey(score)) {
	    	maxDepth = Math.max(depth, maxDepth);
	    	if(maxDepth == 5706) {
	    		System.out.println("NOP2");
	    	}
	        return cache.get(score);
	    } else if(score < 0) {	    	
	    	maxDepth = Math.max(depth, maxDepth);
	    	if(maxDepth == 5706) {
	    		System.out.println("NOP3");
	    	}
	        return 0;
	    } else if(score == 0) {
	    	maxDepth = Math.max(depth, maxDepth);
	    	if(maxDepth == 5706) {
	    		System.out.println("NOP4");
	    	}
	        return 1;
	    } else {
	        int ans = helper(score-8, cache, depth+1) % MOD;	ans%=MOD; if(ans<0) System.out.println("Score1: "+score);
	        ans += helper(score-7, cache, depth+1) % MOD; ans%=MOD; if(ans<0) System.out.println("Score2: "+score);
	        ans += helper(score-6, cache, depth+1) % MOD; ans%=MOD; if(ans<0) System.out.println("Score3: "+score);
	        ans += helper(score-3, cache, depth+1) % MOD; ans%=MOD; if(ans<0) System.out.println("Score4: "+score);
	        ans += helper(score-2, cache, depth+1) % MOD; if(ans<0) System.out.println("Score5: "+score);
	        cache.put(score, ans%MOD);
	        return ans%MOD;
	    }
	}
	
	public static void main(String[] args) {		
		Scanner sc = new Scanner(System.in);
		int inputScore = sc.nextInt();
		long start = System.currentTimeMillis();
		System.out.println(americanFootball(inputScore));
		System.out.println("Time taken: "+(System.currentTimeMillis()-start)+" msecs");
		System.out.println("maxDepth: "+maxDepth);
	}

}
