package mz;

import java.util.PriorityQueue;

public class WarriorsAndMonster {
	int allianceVersusMonster(int[] healthPoints, int[] attackDamage) {
	    PriorityQueue<int[]> pq = new PriorityQueue<>(healthPoints.length-1, 
	                               (a,b) -> {
	                                   if(a[0]-attackDamage[0] <= 0) {
	                                       return 1;
	                                   } else if(b[0]-attackDamage[0] <= 0) {
	                                       return -1;
	                                   } else {
	                                       return b[1]-a[1];
	                                   }
	                               });
	    for(int i=1; i<healthPoints.length; i++) {
	        pq.add(new int[]{healthPoints[i], attackDamage[i]});
	    }
	    while(!pq.isEmpty() && healthPoints[0]>0) {
	        int[] s = pq.remove();
	        int times = s[0]%attackDamage[0]!=0 ? s[0]/attackDamage[0] : (s[0]/attackDamage[0])-1;
	        times = Math.max(1, times);
	        healthPoints[0]-= s[1]*times;
	        if(healthPoints[0]<=0) {
	        	pq.add(s);
	        	break;
	        }
	        s[0] -= attackDamage[0]*times;
	        if(s[0] > 0) {
	            pq.add(s);
	        }
	    }
	    return pq.size();
	}

}
