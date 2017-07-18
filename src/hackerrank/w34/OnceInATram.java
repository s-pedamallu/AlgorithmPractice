package hackerrank.w34;

import java.util.Scanner;

public class OnceInATram {

	public String getNextLuckyTicket(String num) {
        Integer trialInt = Integer.valueOf(num)+1;
        while(true) {
            String trial = trialInt.toString();
            int firstSum = getSum(trial.substring(0,3));
            int lastSum = getSum(trial.substring(3,6));
            if (firstSum == lastSum) {
                return trial;
            }
            trialInt++;
        }
	}

	private int getSum(String num) {
		int ans = 0;
        for(int i=0; i<num.length(); i++) {
            char c = num.charAt(i);
            ans += c-'0';
        }
        return ans;
	}

	public static void main(String[] args) {
	    Scanner in = new Scanner(System.in);
	    String x = in.nextLine();
	    OnceInATram onceInATram = new OnceInATram();
	    String result = onceInATram.getNextLuckyTicket(x);
	    System.out.println(result);
	}
}
