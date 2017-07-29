package hackerrank.w34;

import java.util.Random;

public class MaxGcdAndSumValidityTester {

	private static int[] getArr(int s, int maxNum, int minNum) {
		Random r = new Random();
		int numPossible = maxNum-minNum-1;
		int[] res = new int[s];
		for(int i=0; i<s; i++) {			
			res[i] = r.nextInt(numPossible)+minNum;
		}
		return res;
	}

	public static void main(String[] args) {
		MaxGcdAndSum obj = new MaxGcdAndSum();
		int attempts = 0;
		int ans1=0;
		int ans2=0;
		int[] i1=null;
		int[] i2=null;
		do {
			attempts++;
			System.out.println(attempts);
			i1 = getArr(5, 200, 1);
			i2 = getArr(5, 200, 1);
			ans1 = obj.maximumGcdAndSum(i1, i2);
			ans2 = obj.algo2(i1, i2);
		} while(ans1 == ans2);
		System.out.println("attempts: "+attempts);
		printArr(i1);
		printArr(i2);
		System.out.println("ans1: "+ans1+" ans2: "+ans2);
	}

	private static void printArr(int[] arr) {
		for(int i=0; i<arr.length; i++) {
			System.out.print(arr[i]+" ");
		}
		System.out.println(" ");
	}
}
