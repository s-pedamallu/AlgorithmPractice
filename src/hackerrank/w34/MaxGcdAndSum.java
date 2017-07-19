package hackerrank.w34;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class MaxGcdAndSum {
	private HashMap<NumPair, Integer> gcdMap;
	
	MaxGcdAndSum() {
		gcdMap = new HashMap<>();
	}

	public int maximumGcdAndSum(int[] A, int[] B) {
        // Complete this function
        Arrays.sort(A);
        Arrays.sort(B);
        int maxGcd = Integer.MIN_VALUE;
        int maxNum1 = -1;
        int maxNum2 = -1;
        int i = A.length-1;
        int j = B.length-1;
        while(i>=0 && j>=0) {
            int gcd = gcd(new NumPair(A[i],B[j]));
            if((maxGcd < gcd) || (maxGcd == gcd && (maxNum1+maxNum2)<(A[i]+B[j]))) {
                maxGcd = gcd;
                maxNum1 = A[i];
                maxNum2 = B[j];
                if(maxGcd == Math.max(A[i], B[j])) {
                    break;
                }
            }
            if (A[i]==Math.max(A[i],B[j])) {
                i--;
            } else {
                j--;
            }
        }
        return maxNum1+maxNum2;
    }

	private int gcd(NumPair pair) {
        if(gcdMap.containsKey(pair)) {
            return gcdMap.get(pair);
        }
        int max = Math.max(pair.num1, pair.num2);
        int min = Math.min(pair.num1, pair.num2);
        int remainder = max%min;
        if (remainder == 0) {
            gcdMap.put(pair, min);
            return min;
        } else {
            int ans = gcd(new NumPair(min, remainder));
            gcdMap.put(pair, ans);
            return ans;
        }
    }

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] A = new int[n];
		for (int A_i = 0; A_i < n; A_i++) {
			A[A_i] = in.nextInt();
		}
		int[] B = new int[n];
		for (int B_i = 0; B_i < n; B_i++) {
			B[B_i] = in.nextInt();
		}
		MaxGcdAndSum obj = new MaxGcdAndSum();
		int res = obj.maximumGcdAndSum(A, B);
		System.out.println(res);
	}

	private static class NumPair {
        int num1;
        int num2;
        
        @Override
        public boolean equals(Object o) {
            if (o!=null && o instanceof NumPair) {
                NumPair other = (NumPair) o;
                return (this.num1==other.num1 && this.num2==other.num2) || (this.num1==other.num2 && this.num2==other.num1);
            }
            return false;
        }

        NumPair(int a, int b) {
            this.num1=a;
            this.num2=b;
        }
    }
}
