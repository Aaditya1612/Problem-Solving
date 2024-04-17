import java.util.*;

// Use BFS, as we have been asked to find the distance from the nearest one.

// T.C: O(N*M) + O(N*M)
// S.C: O(2*(N*M))
class Solution
{
    //Function to find distance of nearest 1 in the grid for each cell.
    public int[][] nearest(int[][] grid)
    {
        int n = grid.length;
        int m = grid[0].length;
        
        int[][] ans = new int[n][m];
        Queue<int[]> q = new LinkedList<>();
        for(int[] i: ans){
            Arrays.fill(i, -1);
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(grid[i][j] == 1){
                    q.add(new int[]{i, j, 0});
                    ans[i][j] = 0;
                }
            }
        }
        
        int dx[] = {0, 0, 1, -1};
	    int dy[] = {1, -1, 0 , 0};
	    
        while(!q.isEmpty()){
            int[] curr =  q.poll();
            int x = curr[0];
            int y = curr[1];
            int dis = curr[2];
            
            for(int i=0; i<4; i++){
                int newx = x + dx[i];
                int newy = y + dy[i];
                
                if(newx < 0 || newy < 0 || newx >= n || newy >= m || ans[newx][newy]!=-1){
                    continue;
                }
                
                q.add(new int[]{newx, newy, dis+1});
                ans[newx][newy] = dis + 1;
            }
        }
        
        return ans;
    }
}


public class distance_of_nearest_cell_having_one {
    
}
