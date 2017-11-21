package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class ConfRooms {
	
	public static class Interval {
		int start;
		int end;

		Interval() {
			start = 0;
			end = 0;
		}

		Interval(int s, int e) {
			start = s;
			end = e;
		}
		@Override
		public String toString() {
			return "("+start+","+end+")";
		}
	}

    public int minMeetingRooms(Interval[] intervals) {
        if(intervals == null || intervals.length == 0) {
            return 0;
        }
        Arrays.sort(intervals, (a,b)->Integer.compare(a.start, b.start));
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(intervals[0].end);
        int j = 1;
        while(j<intervals.length) {
            if(pq.peek() <= intervals[j].start) {
                pq.remove();                    
            }
            pq.add(intervals[j].end);
            j++;
        }
        return pq.size();
    }

    public int minMeetingRooms2(Interval[] intervals) {
        if(intervals == null || intervals.length == 0) {
            return 0;
        }
        Arrays.sort(intervals, (a,b)->Integer.compare(a.start, b.start));
        List<Integer> endTimes = new ArrayList<>();
        endTimes.add(intervals[0].end);
//        int i = 0;
//        while(i<intervals.length) {
        	int j = 1;
            while(j<intervals.length) {
            	boolean found = false;
            	for(int k=0; k<endTimes.size(); k++) {
            		if(endTimes.get(k)<=intervals[j].start) {
            			found = true;
            			endTimes.set(k, intervals[j].end);
            			break;
            		}
            	}
            	if(!found) {
	                endTimes.add(intervals[j].end);
            	}
                j++;
            }
//            i = j;
//        }
        return endTimes.size();
    }
}
