package bfs;

import java.util.LinkedList;

public class WallsAndGates {
    public void wallsAndGates(int[][] rooms) {
        if(rooms == null || rooms.length==0 || rooms[0].length==0) {
            return;
        }
        int R = rooms.length;
        int C = rooms[0].length;
        for(int i=0; i<rooms.length; i++) {
            for(int j=0; j<rooms[i].length; j++) {
                if(rooms[i][j]>0) {
//                    rooms[i][j] = bfs(rooms, i, j);
                	dfs(rooms, i, j, new boolean[R][C], R, C);
                }
            }
        }
/*        for(int i=0; i<rooms.length; i++) {
            for(int j=0; j<rooms[i].length; j++) {
                if(rooms[i][j]==-2) {
                    rooms[i][j] = Integer.MAX_VALUE;
                }
            }
        }*/
    }

    private int dfs(int[][] rooms, int i, int j, boolean[][] visited, int R, int C) {
    	visited[i][j]=true;
    	if(rooms[i][j] == 0) {
    		return 0;
    	} else if(rooms[i][j]!=Integer.MAX_VALUE) {
    		return rooms[i][j];
    	} else {
    		int l = Integer.MAX_VALUE;
    		int r = Integer.MAX_VALUE;
    		int u = Integer.MAX_VALUE;
    		int d = Integer.MAX_VALUE;
            if(i>0 && !visited[i-1][j] && rooms[i-1][j]>=0) {
                int x = dfs(rooms, i-1, j, visited, R, C);
                u = x!=u ? x+1 : x;
            }
            if(i<R-1 && !visited[i+1][j] && rooms[i+1][j]>=0) {
            	int x = dfs(rooms, i+1, j, visited, R, C);
            	d = x!=d ? x+1 : x;
            }
            if(j>0 && !visited[i][j-1] && rooms[i][j-1]>=0) {
            	int x = dfs(rooms, i, j-1, visited, R, C);
            	l = x!=l ? x+1 : x;
            }
            if(j<C-1 && !visited[i][j+1] && rooms[i][j+1]>=0) {
                int x= dfs(rooms, i, j+1, visited, R, C);
                r = x!=r ? x+1 : x;
            }
            rooms[i][j] = Math.min(Math.min(l, r), Math.min(u, d));
            return rooms[i][j];
    	}
    }
    private int bfs(int[][] rooms, int i, int j) {
        int R = rooms.length;
        int C = rooms[0].length;
        int[][] visited = new int[R][C];        
        LinkedList<int[]> q = new LinkedList<>();
        q.addLast(new int[]{i, j, 0});
        int steps = 0;
        while(!q.isEmpty()) {
            int[] cur = q.removeFirst();
            i = cur[0];
            j = cur[1];
            visited[cur[0]][cur[1]] = 1;
            if(rooms[cur[0]][cur[1]] == 0) {
                return cur[2];
            }
            if(i>0 && visited[i-1][j]==0 && rooms[i-1][j]>=0) {
                q.add(new int[]{i-1, j, cur[2]+1});
            }
            if(i<R-1 && visited[i+1][j]==0 && rooms[i+1][j]>=0) {
                q.add(new int[]{i+1, j, cur[2]+1});
            }
            if(j>0 && visited[i][j-1]==0 && rooms[i][j-1]>=0) {
                q.add(new int[]{i, j-1, cur[2]+1});
            }
            if(j<C-1 && visited[i][j+1]==0 && rooms[i][j+1]>=0) {
                q.add(new int[]{i, j+1, cur[2]+1});
            }
        }
        return -2;
    }
}
