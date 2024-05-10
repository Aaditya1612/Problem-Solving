package HomeWork.DP_4;

import java.util.Arrays;

// Recursion + memoization
// T.C: O(M*N)
// S.C: O(M*N) + O(N)
class Solution {
    public int countUpaths(int m, int n, int[][] cache){
        if(n == 0 || m == 0){
            return 1;
        }
        if(cache[m][n] != -1){
            return cache[m][n];
        }
        int upCnt = countUpaths(m-1, n, cache);
        int leftCnt = countUpaths(m, n-1, cache);

        return cache[m][n] = upCnt + leftCnt;
    }
    public int uniquePaths(int m, int n) {
        int[][] cache = new int[m][n];
        for(int[] i: cache){
            Arrays.fill(i, -1);
        }
        return countUpaths(m-1, n-1, cache);
    }
}

// Tabulation
// T.C: O(M*N)
// S.C: O(M*N)
class Solution2 {
    public int uniquePaths(int m, int n) {
        int[][] dp =  new int[m][n];

        for(int j=0; j<n; j++){
            dp[0][j] = 1;
        }

        for(int i=0; i<m; i++){
            dp[i][0] = 1;
        }


        for(int i=1; i<m; i++){
            for(int j=1; j<n; j++){
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }

        return dp[m-1][n-1];
    }
}

public class unique_paths {
    
}
