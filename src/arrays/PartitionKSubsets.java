package arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PartitionKSubsets {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        Map<Integer, Integer> sumMap = new HashMap<>();
        Map<Integer, List<Integer>> debug = new HashMap<>();
        for(int i=1; i<Math.pow(2,nums.length); i++) {            
            int sum = 0;
//            if((i&1) !=0) {
//            	continue;
//            }
            for(int j=0, mask=1; j<nums.length; j++) {            	
                if((i & mask)>0) {
                    sum+=nums[j];
                }
                mask <<= 1;
                if(mask>i) {
                	break;
                }
            }
            int c = sumMap.containsKey(sum) ? sumMap.get(sum) : 0;
            List<Integer> l = debug.containsKey(sum) ? debug.get(sum) : new ArrayList<>();
            l.add(i);
            sumMap.put(sum, c+1);
            debug.put(sum, l);
            if(c+1 >= k) {
            	System.out.println(sumMap);
            	System.out.println(debug);
                return true;
            }
        }
        System.out.println(sumMap);
    	System.out.println(debug);
        return false;
    }
}
