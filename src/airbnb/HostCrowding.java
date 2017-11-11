package airbnb;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class HostCrowding {
    static String[] paginate(int num, String[] results) {
        List<Result> resultList = new ArrayList<>();
        for(String s : results) {
            resultList.add(new Result(s));
        }
        Collections.sort(resultList);
        HashSet<Integer> hostsInPage = new HashSet<>();
        List<String> ans = new ArrayList<>();
        int pageCount = 0;
		while (!resultList.isEmpty()) {
			Iterator<Result> itr = resultList.iterator();
			hostsInPage = new HashSet<>();
			while (itr.hasNext()) {
				Result r = itr.next();
				if (hostsInPage.contains(r.host_id)) {
					continue;
				} else {
					ans.add(r.raw);
					itr.remove();
					pageCount++;
					hostsInPage.add(r.host_id);
					if (pageCount == num) {
						pageCount = 0;
						hostsInPage = new HashSet<>();
						itr = resultList.iterator();
						ans.add("");
					}
				}
			}
		}
        String[] finalResult = ans.toArray(new String[resultList.size()]);      
        return finalResult;
    }


    static String[] paginate2(int num, String[] results) {
    	if(results == null || results.length == 0 || num <= 0) {
    		String[] empty = {};
    		return empty;
    	}
    	String[] paginatedResult = new String[results.length + results.length/num];
    	int counter = 0;
    	int pageCount = 0;
        HashSet<Integer> hostsInPage = new HashSet<>();
    	for(int i = 0; i<results.length; i++) {
    		if(pageCount == num) {
    			paginatedResult[counter++] = "";
    			pageCount = 0;
    			i=-1;
    			hostsInPage = new HashSet<>();
    			continue;
    		}
    		if("".equals(results[i])) {
    			continue;
    		}
    		String[] tokens = results[i].split(",");
    		int host_id = Integer.valueOf(tokens[0]);
    		if(hostsInPage.contains(host_id)) {
    			continue;
    		}
    		hostsInPage.add(host_id);
    		paginatedResult[counter++] = results[i];
    		results[i] = "";
    		pageCount++;
    	}
    	
        for(String r : results) {
        	if("".equals(r)) {
        		continue;
        	}
            if(pageCount == num) {
                paginatedResult[counter++] = "";
                pageCount = 0;
            }
            paginatedResult[counter++] = r;
            pageCount++;
        }
        return paginatedResult;
    }

    static class Result implements Comparable<Result>{
        int host_id;
        int listing_id;
        double score;
        String city;
        String raw;
        
        Result(String s) {
            String[] tokens = s.split(",");
            this.host_id = Integer.valueOf(tokens[0]);
            this.listing_id = Integer.valueOf(tokens[1]);
            this.score = Double.valueOf(tokens[2]);
            this.city = tokens[3];
            this.raw = s;
        }
        
        @Override
        public int compareTo(Result r) {
            if(this.score > r.score) {
                return -1;
            } else if(this.score < r.score) {
                return 1;
            } else {
                return 0;
            }
        }
    }

    /*
Sample Input 1:
5 13
1,28,300.6,San Francisco
4,5,209.1,San Francisco
20,7,203.4,Oakland
6,8,202.9,San Francisco
6,10,199.8,San Francisco
1,16,190.5,San Francisco
6,29,185.3,San Francisco
7,20,180.0,Oakland
6,21,162.2,San Francisco
2,18,161.7,San Jose
2,30,149.8,San Jose
3,76,146.7,San Francisco
2,14,141.8,San Jose

Expected output 1:
1,28,300.6,San Francisco
4,5,209.1,San Francisco
20,7,203.4,Oakland
6,8,202.9,San Francisco
7,20,180.0,Oakland

6,10,199.8,San Francisco
1,16,190.5,San Francisco
2,18,161.7,San Jose
3,76,146.7,San Francisco
6,29,185.3,San Francisco

6,21,162.2,San Francisco
2,30,149.8,San Jose
2,14,141.8,San Jose
------------------
Sample Input 2:
5 14
1,28,300.6,San Francisco
4,5,209.1,San Francisco
20,7,203.4,Oakland
6,8,202.9,San Francisco
6,10,199.8,San Francisco
1,16,190.5,San Francisco
6,29,185.3,San Francisco
7,20,180.0,Oakland
6,21,162.2,San Francisco
2,18,161.7,San Jose
2,30,149.8,San Jose
3,76,146.7,San Francisco
2,14,141.8,San Jose
3,45,139.6,Fremont

Expected output 2:
1,28,300.6,San Francisco
4,5,209.1,San Francisco
20,7,203.4,Oakland
6,8,202.9,San Francisco
7,20,180.0,Oakland

6,10,199.8,San Francisco
1,16,190.5,San Francisco
2,18,161.7,San Jose
3,76,146.7,San Francisco
6,29,185.3,San Francisco

6,21,162.2,San Francisco
2,30,149.8,San Jose
3,45,139.6,Fremont
2,14,141.8,San Jose
     */
    public static void main(String[] a) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	String line = br.readLine();
    	String[] tokens = line.split(" ");
    	int m = Integer.valueOf(tokens[0]);
    	int n = Integer.valueOf(tokens[1]);
    	String[] arr = new String[n];
    	for(int i=0; i<n; i++) {
    		arr[i] = br.readLine();
    	}
    	String[] result = paginate(m, arr);
    	System.out.println("------ Output ------");
    	for(String r : result) {
    		System.out.println(r);
    	}
    }
}
