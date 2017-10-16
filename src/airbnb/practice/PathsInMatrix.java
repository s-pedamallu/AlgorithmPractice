package airbnb.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PathsInMatrix {
    static int numberOfPaths(int[][] a) {    
        if(a == null || a.length==0 || a[0].length==0) {
            return 0;
        }
        int m = a.length;
        int n = a[0].length;
        int[][] paths = new int[m][n];
        if(a[m-1][n-1]==0) {
            return 0;
        }
        dfs(a, paths, 0, 0, m, n);
        return paths[0][0];
    }

    static int dfs(int[][] arr, int[][] paths, int fromR, int fromC, int m, int n) {
        if(fromR >= m || fromC>=n || arr[fromR][fromC] == 0) {
            return 0;
        } else if(paths[fromR][fromC] > 0) {
            return paths[fromR][fromC];
        } else if(fromR==m-1 && fromC==n-1) {
            return 1;
        } else {
            paths[fromR][fromC] += dfs(arr, paths, fromR+1, fromC, m, n);
            paths[fromR][fromC] += dfs(arr, paths, fromR, fromC+1, m, n);
            return paths[fromR][fromC];
        }
    }

    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	String line = br.readLine();
    	String[] tokens = line.split(" ");
    	int m = Integer.valueOf(tokens[0]);
    	int n = Integer.valueOf(tokens[1]);
    	int[][] arr = new int[m][n];
    	for(int i=0; i<m; i++) {
    		line = br.readLine();
    		tokens = line.split(" ");
    		for(int j=0; j<n; j++) {
    			arr[i][j] = Integer.valueOf(tokens[j]);
    		}
    	}
    	System.out.println(numberOfPaths(arr));
    }
}
