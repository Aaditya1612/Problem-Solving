class Solution {

    // Memoization solution
    // Theory of this function  is that for any given (i, j) this function
    // will give me the minimum health with which the price should visit (i, j)
    // so that he can reach n-1 and m-1 with health > 0.

    // For each cell I can either go right or down, I will use the minhp() function
    // to find the minimum hp i require if I want to visit I want to vist right and
    // minimum hp for down, I will then do my own contributions and pass the minimum
    // hp with which the prince should visit me to reach the n-1 and m-1 cell.
    // public int minhp(int i, int j, int n, int m, int[][] dungeon, int[][] cache){
    //     if(i == n-1 && j == m-1){
    //         if(dungeon[i][j] < 0){
    //             return Math.abs(dungeon[i][j])+1;
    //         }
    //         return 1;
    //     }

    //     if(i >= n || j>=m){
    //         return (int)1e9;
    //     }

    //     if(cache[i][j] != -1){
    //         return cache[i][j];
    //     }

    //     int right = minhp(i, j+1, n, m, dungeon, cache);
    //     int down = minhp(i+1, j, n, m, dungeon, cache);

    //     int currCellReqForTakingRight = Math.max(1, Math.abs(right)-dungeon[i][j]);
    //     int currCellReqForTakingDown = Math.max(1, Math.abs(down) - dungeon[i][j]);

    //     return cache[i][j] = Math.min(currCellReqForTakingRight, currCellReqForTakingDown);

    // }

    // Iterative solution
    public int calculateMinimumHP(int[][] dungeon) {
        int n = dungeon.length;
        int m = dungeon[0].length;
        int[][] dp = new int[n+1][m+1];

        for(int i=0; i<=n; i++){
            dp[i][m] = (int)1e9;
        }

        for(int j=0; j<=m; j++){
            dp[n][j] = (int)1e9;
        }
        
        dp[n][m-1] = 1;
        dp[n-1][m] = 1;

        for(int i=n-1; i>=0; i--){
            for(int j=m-1; j>=0; j--){
                if(dungeon[i][j] > 0){
                    dp[i][j] = Math.max(1, Math.abs(dp[i+1][j])-dungeon[i][j]);
                    dp[i][j] = Math.min(dp[i][j], Math.max(1, Math.abs(dp[i][j+1])-dungeon[i][j]));
                } else{
                    dp[i][j] = Math.abs(dungeon[i][j]) + dp[i+1][j];
                    dp[i][j] = Math.min(dp[i][j], Math.abs(dungeon[i][j]) + dp[i][j+1]);
                }
            }
        }
        return dp[0][0] == 0 ? 1 : dp[0][0];
    }
}