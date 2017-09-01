package sets;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class RandomizedSet {

	private List<Integer> src;
	private Map<Integer, Integer> map;

    /** Initialize your data structure here. */
    public RandomizedSet() {
    	src = new ArrayList<>();
        map = new HashMap<>();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
    	//System.out.println("Came here");
        if(map.containsKey(val)) {
        	return false;
        }
        map.put(val, src.size());
        src.add(val);
        return true;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if(map.containsKey(val)) {
        	// swap last element with this val
        	int idx = map.get(val);
        	int lastVal = src.get(src.size()-1);
        	map.remove(val);
			src.remove(src.size() - 1);
			if (val != lastVal) {
				src.set(idx, lastVal);
				map.put(lastVal, idx);
			}
        	return true;
        }
        return false;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        Random r = new Random();
        return src.get(r.nextInt(src.size()));
    }

    /*
["RandomizedSet","insert","remove","insert","remove","getRandom","getRandom","getRandom","getRandom","getRandom","getRandom","getRandom","getRandom","getRandom","getRandom"]
[[],[0],[0],[-1],[0],[],[],[],[],[],[],[],[],[],[]]
     */
    public static void main(String[] args) {
    	RandomizedSet r = new RandomizedSet();
    	r.insert(0);
    	r.remove(0);
    	r.insert(-1);
    	r.remove(0);
    	System.out.println("Random elem: "+r.getRandom());
    	System.out.println("Random elem: "+r.getRandom());
    	System.out.println("Random elem: "+r.getRandom());
    	System.out.println("Random elem: "+r.getRandom());
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
