package trees;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * https://leetcode.com/problems/kill-process/
 */
public class DescendentsOfProcess {
    class Process {
    	Integer pid;
    	List<Process> children;
    	
    	public Process(int p) {
    		this.pid = p;
    		this.children = new ArrayList<>();
    	}
    	
    	public void addChild(Process p) {
    		this.children.add(p);
    	}
    	
    	public String toString() {
    		return pid + "=>" + children;
    	}
    }
	
	public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
		if(pid == null || ppid == null || pid.size() != ppid.size() || pid.size() == 0) {
			return Collections.EMPTY_LIST;
		}
		Map<Integer, Process> processMap = new HashMap<>();
		Process baseParent = new Process(0);
		processMap.put(0, baseParent);
		
		for(Integer i : pid) {
			Process p = new Process(i);
			processMap.put(i, p);
		}
		
		for(int i=0; i<ppid.size(); i++) {
			Process parent = processMap.get(ppid.get(i));
			parent.addChild(processMap.get(pid.get(i)));
		}
		
		List<Integer> result = new ArrayList<>();
		Queue<Process> q = new LinkedList<>();
		q.offer(processMap.get(kill));
		while(!q.isEmpty()) {
			Process p = q.poll();
			result.add(p.pid);
			q.addAll(p.children);
		}
		return result;
    }
	
}
