package HomeWork.DP1;
import java.util.*;

// Memoization solution 
// T.C: O(N * sqrt(N))
// S.C: O(N) + O(sqrt(N))
class Solution {
    public int findMinAns(int n, int[] cache){
        if(n == 0){
            return 0;
        }
        if(n < 0){
            return (int)1e9;
        }

        if(cache[n] != -1){ return cache[n];}
        int ans = (int)1e9;
        for(int i=1; i*i<=n; i++){
            ans = Math.min(ans, 1+findMinAns(n-i*i, cache));;
        }

        return cache[n] = ans;
    }
    public int numSquares(int n) {
        int[] cache = new int[n+1];
        // cache[i] -> stores minimum perfect squares required to make sum i
        Arrays.fill(cache, -1);
        return findMinAns(n, cache);
    }
}

// Tabulation Solution
// T.C: O(N*sqrt(N))
// S.C: O(N)
class Solution2 {
    public int numSquares(int n) {
        int[] cache = new int[n+1];
        Arrays.fill(cache, (int)1e9);
        // cache[i] -> stores minimum erfect squares required to make sum i
        cache[0] = 0;
        cache[1] = 1;
        
        for(int i=2; i<=n; i++){
            for(int j = 1; j*j<=i; j++){
                cache[i] = Math.min(cache[i], 1+cache[i-j*j]);
            }
        }

        return cache[n];
    }
}


public class perfect_sqaures {
    
}
