package arrays;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MoellerMatrix {

	public List<List<Integer>> diagonal(List<List<Integer>> a) {
		List<List<Integer>> ans = new ArrayList<>();
	    if(a==null||a.isEmpty()) {
	        return ans;
	    }
	    int rows = a.size();
	    int cols = a.get(0).size();
	    int numRows = 2*(rows-1)+cols-(rows-1);
	    int sr = 0;
	    int sc = 0;
	    for(int i=0; i<numRows; i++) {
	        ArrayList<Integer> rowList = new ArrayList<>();
	        int r = sr;
	        int c = sc;
	        while(r<rows && c>=0) {
	            rowList.add(a.get(r).get(c));
	            r+=1;
	            c-=1;
	        }
	        if(sc<cols-1) {
	            sc++;
	        } else {
	            sr++;
	        }
	        ans.add(rowList);
	    }
	    return ans;
	}

	public static void main(String[] args) {
		MoellerMatrix m = new MoellerMatrix();
		Scanner sc = new Scanner(System.in);
		List<List<Integer>> src = new ArrayList<>();
		int nRows = sc.nextInt();
		sc.nextLine();
		for(int i=0; i<nRows; i++) {
			String[] tokens = sc.nextLine().split(" ");
			ArrayList<Integer> row = new ArrayList<>();
			for(int j=0; j<tokens.length; j++) {
				row.add(Integer.valueOf(tokens[j]));
			}
			src.add(row);
		}
		List<List<Integer>> ans = m.diagonal(src);
		for(List<Integer> r : ans) {
			for(Integer i : r) {
				System.out.print(i+" ");
			}
			System.out.println("");
		}
	}

}
