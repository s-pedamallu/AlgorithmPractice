package bitmanipulation;

import java.util.HashSet;
import java.util.Set;

public class MaxXorTwoElemsInArray {
    public int findMaximumXOR(int[] nums) {
        int max = 0;
        int mask = 0;
        // from left to right, get max xor taking one bit at a time
        for(int i=31; i>=0; i--) {
            Set<Integer> numbers = new HashSet<>();
            mask |= 1 << i;
            for(int num : nums) {
                numbers.add(num & mask);
            }

            int tmp = max | (1 << i);
            for(int num : numbers) {
                if(numbers.contains(num ^ tmp)) {
                    max = tmp;
                    break;
                }
            }
        }
        return max;
    }
}
