package HomeWork.Graph_2;
import java.util.*;


// Use BFS to travel all the newighbours of the currently rotten orange, keep increasing time by 1. The maxmimum time will be answer.
// Also the neighbours which are closer to the already rotten orange will get rotten first that's the speciality of the BFS.
// In case when we haven't travesed any fresh orange in the entire BFS traversal then we will return -1


// T.C: O(N*M) + O(N*M) + O(N*M)
// S.C: O(N*M) -> we can reduce this space as well if we mark the rotten oranges in place instead of maintaining one extra vis array. 
// and that totally depends on interviewer if he/she allows us to modify given matrix or not
class Solution {
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int[][] vis = new int[n][m];
        Queue<int[]> q = new LinkedList<>();
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(grid[i][j]==2){
                    vis[i][j] = 1;
                    q.add(new int[]{i, j, 0});
                }
            }
        }

        int min = 0;
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        while(!q.isEmpty()){
            int[] curr = q.remove();
            int t = curr[2];
            min = Math.max(min, t);
            for(int d=0; d<4; d++){
                int i = curr[0] + dx[d];
                int j = curr[1] + dy[d];

                if(i>=0 && i<n && j>=0 && j<m && vis[i][j]!=1 && grid[i][j]==1){
                    q.add(new int[]{i, j, t+1});
                    vis[i][j] = 1;
                }
            }
        }

        for(int i=0;i<n; i++){
            for(int j=0; j<m; j++){
                if(vis[i][j]!=1 && grid[i][j]==1){
                    return -1;
                }
            }
        }

        return min;
    }
}
public class rotting_oranges {
    
}
