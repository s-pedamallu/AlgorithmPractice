package dfs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Leet code link: https://leetcode.com/problems/course-schedule/description/
 * @author spedamallu
 *
 */
public class FinishCourse {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(numCourses <= 0) {
            return true;
        }
        boolean[] visited = new boolean[numCourses];
        Map<Integer, List<Integer>> preMap = new HashMap<>();
        for(int[] pre : prerequisites) {
            List<Integer> l = preMap.containsKey(pre[0]) ? preMap.get(pre[0]) : new ArrayList<>();
            l.add(pre[1]);
            preMap.put(pre[0], l);
        }
        for(int i=0; i<numCourses; i++) {
            if(!visited[i] && !canComplete(i, preMap, new HashSet<Integer>(), visited)) {
                return false;
            }
        }
        return true;
    }

    private boolean canComplete(int courseNum, Map<Integer, List<Integer>> preReqs, Set<Integer> stack, boolean[] visited) {
    	if(stack.contains(courseNum)) {
    		return false;
    	} else if(!preReqs.containsKey(courseNum)) {
    		return true;
    	}
    	stack.add(courseNum);
    	for(int num : preReqs.get(courseNum)) {
    		if(!visited[courseNum] && !canComplete(num, preReqs, stack, visited)) {
    			stack.remove(courseNum);
    			return false;
    		}
    	}
    	visited[courseNum] = true;
    	stack.remove(courseNum);
    	return true;
    }

    private boolean isCyclePresent(Map<Integer, List<Integer>> map, int c, Set<Integer> visited) {
        if(!map.containsKey(c)) {
            return false;
        }        
        if(visited.contains(c)) {
            return true;
        }
        visited.add(c);
        for(Integer i : map.get(c)) {
            if(isCyclePresent(map, i, visited)) {
                return true;
            }
        }
        return false;
    }

}
