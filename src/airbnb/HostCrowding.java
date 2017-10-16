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
        Iterator<Result> itr = resultList.iterator();
        HashSet<Integer> hostsInPage = new HashSet<>();
        List<String> ans = new ArrayList<>();
        int pageCount = 0;
        while(itr.hasNext()) {
            Result r = itr.next();
            if(hostsInPage.contains(r.host_id)) {
                continue;
            } else {
                ans.add(r.raw);
                itr.remove();
                pageCount++;
                hostsInPage.add(r.host_id);
                if(pageCount == num) {
                    pageCount = 0;
                    hostsInPage = new HashSet<>();
                    itr = resultList.iterator();
                    ans.add("");
                }
            }
        }
        for(Result r : resultList) {
            ans.add(r.raw);
            pageCount++;
            if(pageCount == num) {
                pageCount = 0;
                ans.add("");
            }
        }
        String[] finalResult = ans.toArray(new String[resultList.size()]);      
        return finalResult;
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
