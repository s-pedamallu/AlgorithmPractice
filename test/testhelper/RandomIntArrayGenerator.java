package testhelper;

import java.util.Random;
import java.util.Scanner;

public class RandomIntArrayGenerator {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int reqSize = sc.nextInt();
		int minNum = sc.nextInt();
		int maxNum = sc.nextInt();

		Random r = new Random();
		int numPossible = maxNum-minNum-1;
		for(int i=0; i<reqSize; i++) {			
			System.out.print(r.nextInt(numPossible)+minNum+" ");
		}
	}

}
// 136 257 252 628 276 630 773 787 382 934  
// 2 7 25 26 8 2 25 18 10 5   