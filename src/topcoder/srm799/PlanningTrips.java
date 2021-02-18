package topcoder.srm799;

import java.util.Map;
import java.util.HashMap;

public class PlanningTrips {
	public int find(int a, int[] num) {
		Map<Integer, Integer> powerCounts = new HashMap<>();
		int maxPower = 0;
		for(int n:num) {
			int c = powerCounts.getOrDefault(n,0)+1;
			powerCounts.put(n, c);
			if(n>maxPower) {
				maxPower = n;
			}
		}
		int ans = num.length == 1 ? maxPower : maxPower+1;
		int[] budget = getBuget(a, ans); 
	}
	
	private int[] getBudget(int a, int p) {
		int[] budget = new int[p];
		budget[p-1] = a;
		for(int i=p-2; i>=0; i--) {
			budget[i]= a*budget[i+1];
		}
		return budget;
	}
	
	private void bumpBudget(int a, int fromIndex, int[] budget) {
		for(int i=fromIndex; i>=0; i--) {
			budget[i] *= a;
		}		
	}
}