package hackerrank.w34;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class MaxGcdAndSum {
	private HashMap<NumPair, Integer> gcdMap;
	
	MaxGcdAndSum() {
		gcdMap = new HashMap<>();
	}

	public int maximumGcdAndSum(int[] A, int[] B) {
        // Complete this function
		Set<NumPair> pairs = new TreeSet<>();		
		for(int i=0; i<A.length; i++) {
			for(int j=0; j<B.length; j++) {
				pairs.add(new NumPair(A[i],B[j]));
			}
		}
		
        int maxGcd = Integer.MIN_VALUE;
        int maxNum1 = -1;
        int maxNum2 = -1;

		Iterator<NumPair> itr = pairs.iterator();
		while(itr.hasNext()) {
			NumPair cur = itr.next();
			if(maxGcd!=-1 && (cur.num1*cur.num2)<maxGcd) {
				break;
			}
			if(Math.min(cur.num1, cur.num2)<maxGcd) {
				// skip
				continue;
			}

			int gcd = gcd(cur, maxGcd);
//			System.out.println("gcd "+cur.num1+" "+cur.num2+ " - "+gcd);
            if((maxGcd < gcd) || (maxGcd == gcd && (maxNum1+maxNum2)<(cur.num1+cur.num2))) {
                maxGcd = gcd;
                maxNum1 = cur.num1;
                maxNum2 = cur.num2;
            }
		}
		return maxNum1+maxNum2;		
    }

	public int algo2(int[] A, int[] B) {
		// Complete this function
		int maxGcd = Integer.MIN_VALUE;
		int maxSum = Integer.MIN_VALUE;
		for (int i = 0; i < A.length; i++) {
			for (int j = 0; j < B.length; j++) {
				int g = gcd(A[i], B[j]);
				if (g >= maxGcd) {
					maxSum = (g > maxGcd) ? (A[i] + B[j]) : Math.max(maxSum, A[i] + B[j]);
					maxGcd = g;
				}
			}
		}
		return maxSum;
	}

	int gcd(int a, int b) {
		if (a == 0 || b == 0) {
			return 0;
		}
		if (a == b) {
			return a;
		}
		return (a > b) ? gcd(a - b, b) : gcd(a, b - a);
	}

	private int gcd(NumPair pair, int tryUntil) {
        if(gcdMap.containsKey(pair)) {
            return gcdMap.get(pair);
        }
        int max = Math.max(pair.num1, pair.num2);
        int min = Math.min(pair.num1, pair.num2);

        if(min<tryUntil) {
        	return -1;
        }
        
        int remainder = max%min;
        if (remainder == 0) {
            gcdMap.put(pair, min);
            return min;
        } else {
            int ans = gcd(new NumPair(min, remainder), tryUntil);
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

	private static class NumPair implements Comparable<NumPair>{
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

		@Override
		public int compareTo(NumPair o) {
			long one = ((long) this.num1)*this.num2;
			long two = ((long) o.num1)*o.num2;
			return two>one ? 1 : -1;
		}
    }
}
