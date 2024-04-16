
// Find number of different componenets. Here componenets are islands.

// T.C: O(N*M)
// S.C: O(N*M)
class Solution {
    public void dfs(char[][] grid, int i, int j, int n, int m){
        grid[i][j] = '0';

        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};

        for(int d = 0; d < 4; d++){
            int newi = i + dx[d];
            int newj = j + dy[d];

            if(newi<0 || newj<0 || newi>=n || newj>=m || grid[newi][newj] == '0'){
                continue;
            }

            dfs(grid, newi, newj, n, m);
        }
    }
    public int numIslands(char[][] grid) {
        int ans = 0;
        int n = grid.length;
        int m = grid[0].length;

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(grid[i][j] == '1'){
                    ans++;
                    dfs(grid, i, j, n, m);
                }
            }
        }

        return ans;

    }
}

public class number_of_islands {
    
}
