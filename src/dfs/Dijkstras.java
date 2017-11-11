package dfs;

import java.util.HashSet;
import java.util.Set;

public class Dijkstras {
	int nightRoute(int[][] city) {
	    int R = city.length;
	    int[] dis = new int[R];
	    for(int i=0; i<R; i++) {
	        dis[i] = Integer.MAX_VALUE;
	    }
	    dis[0] = 0;
	    dijkstras(city, 0, dis, new HashSet<>());
	    return dis[R-1];
	}

	private void dijkstras(int[][] city, int pos, int[] dis, Set<Integer> visited) {
	    visited.add(pos);
	    int[] c = city[pos];
	    int min = Integer.MAX_VALUE;
	    int minIdx = -1;
	    for(int i=0; i<c.length; i++) {
	        int n = c[i];
	        if(n>=0 && dis[i]>dis[pos]+n) {
	            dis[i] = dis[pos]+n;
	        }
	    }
	    
	    for(int i=0; i<city.length; i++) {
	    	if(!visited.contains(i) && min>dis[i]) {
	    		minIdx = i;
	    		min = dis[i];
	    	}
	    }
	    if(minIdx!=-1) {
	        dijkstras(city, minIdx, dis, visited);
	    }
	}
}
