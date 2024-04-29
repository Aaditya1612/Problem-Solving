package HomeWork.DP1;
import java.util.*;

// Memoization Solution
// T.C: O(N)
// S.C: O(N) + O(N)
class Solution{
    static int helper(int N, int mat[][], int[] cache){
        
        if(N <= 0){
            return 0;
        }
        if(cache[N] != -1) return cache[N];
        int ans = 0;
        
        ans = Math.max(ans, mat[0][N-1] + helper(N-2, mat, cache));
        ans = Math.max(ans, mat[1][N-1] + helper(N-2, mat, cache));
        ans = Math.max(ans, helper(N-1, mat, cache));
        return cache[N] = ans;
    }
    static int maxSum(int N, int mat[][])
    {
        int[] cache = new int[N+1];
        // cache[i] -> maximum acihevable sum if num of cols in mat is i
        
        Arrays.fill(cache, -1);
        return helper(N, mat, cache);
    }
}

// Tabulation 
// T.C: O(N)
// S.C: O(N)
class Solution2{
    static int maxSum(int N, int mat[][])
    {
        int[] cache = new int[N+1];
        
        cache[0] = 0;
        cache[1] = Math.max(mat[0][0], mat[1][0]);
        // Since we are considering cache as 1 based indexing so to compute cache[i] we will use mat[0/1][i-1] values
        for(int i=2; i<=N; i++){
            cache[i] = Math.max(cache[i-1], Math.max(mat[0][i-1] + cache[i-2], mat[1][i-1] + cache[i-2]));
        }
        return cache[N];
    }
}

public class ajascents_are_not_allowed {
    
}
