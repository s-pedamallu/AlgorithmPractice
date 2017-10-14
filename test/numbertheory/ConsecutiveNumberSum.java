package numbertheory;

import java.util.Scanner;

public class ConsecutiveNumberSum {

    static int consecutive(long num) {
        int ans = 0;
        for(int i=2; i<=num/2; i++) {
            if(isDivisible(num*2l, i)) {
                ans++;
            }
        }
        return ans;
    }

    static boolean isDivisible(long S, int k) {
        if(S%k != 0) {
            return false;
        }
        long eq = S+(k*k)-k;
        return (eq%(2*k))==0 && (eq/(2*k))>=k;
    }

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long num = sc.nextLong();
		long start = System.currentTimeMillis();
		System.out.println(consecutive(num));
		System.out.println("Time taken: "+(System.currentTimeMillis() - start)+" msecs");
	}

}
