#include<bits/stdc++.h>
using namespace std;
// Recursion + Memoization
// T.C: O(N*M)
// S.C: O(N*M) + O(N)
class Solution {
public:
    int countPath(vector<vector<int>>& grid, int n, int m, int i, int j, vector<vector<int>>& cache){
        
        if(i == n || j == m){
            return 0;
        }
        
        if(i == n-1 && j == m-1){
            return grid[i][j] == 1 ? 0 : 1;
        }

        if(grid[i][j] == 1){
            return 0;
        }

        if(cache[i][j] != -1){
            return cache[i][j];
        }

        int down = countPath(grid, n, m, i+1, j, cache);
        int right = countPath(grid, n, m, i, j+1, cache);

        return cache[i][j] = down + right;
    }
    int uniquePathsWithObstacles(vector<vector<int>>& obstacleGrid) {
        int n = obstacleGrid.size();
        int m = obstacleGrid[0].size();
        vector<vector<int>> cache(n, vector<int>(m, -1));

        return countPath(obstacleGrid, n, m, 0, 0, cache);
    }
};


// Tabulated solution
// T.C: O(N*M)
// S.C: O(N*M)

class Solution {
public:
    int uniquePathsWithObstacles(vector<vector<int>>& obstacleGrid) {
        if(obstacleGrid[0][0] == 1){
            return 0;
        }
        int n = obstacleGrid.size();
        int m = obstacleGrid[0].size();
        vector<vector<int>> dp(n, vector<int>(m, -1));
        // dp[i][j] -> number of valid paths to i, j from 0, 0

        dp[0][0] = 1;

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(i==0 && j==0){
                    continue;
                }
                dp[i][j] = 0;
                if(i>0){
                    dp[i][j] += dp[i-1][j]; // number of ways to reach from top
                }
                if(j>0){
                    dp[i][j] += dp[i][j-1]; // number of ways to reach from the left cell
                }

                if(obstacleGrid[i][j] == 1){
                    dp[i][j] = 0;
                }
            }
        }

        
        return dp[n-1][m-1]; // valid paths to reach n-1, m-1 from 0, 0
    }
};