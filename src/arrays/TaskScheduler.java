package arrays;

import java.util.Arrays;

public class TaskScheduler {
    public int leastInterval(char[] tasks, int n) {
        if(tasks == null || tasks.length == 0) {
            return 0;
        } else if (n == 0) {
            return tasks.length;
        }
        int[] arr = new int[26];
        for(char c : tasks) {
            arr[c-'A']++;
        }
        Arrays.sort(arr);
        int cur = 0;
        int elems = 0;
        while(elems < tasks.length) {
            int k = n+1;
            int s = arr.length-1;
            while(arr[s] > 0 && k>0) {
                cur++;
                elems++;
                k--;
                arr[s]--;
                s--;
            }
            if(k>0 && elems < tasks.length) {
                cur+=k;
            }
            Arrays.sort(arr);
        }
        return cur;
    }
}
