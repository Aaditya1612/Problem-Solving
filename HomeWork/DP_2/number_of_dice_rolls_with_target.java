package HomeWork.DP_2;
import java.util.*;

// Recursion + Memoization 
// T.C : O(K*N*target)
// S.C : O(N*target) + O(N)
class Solution {
    final int mod = (int)1e9+7;
    public int totalWays(int n, int k, int target, int[][] cache){
        if(target == 0){
            return n == 0 ? 1 : 0; // All the dices must be used to make the target
        }

        if(target < 0 || n == 0){
            return 0;
        }

        if(cache[n][target] != -1){
            return cache[n][target];
        }

        int ways = 0;
        for(int i=1; i<=k; i++){
            ways = (ways%mod + totalWays(n-1, k, target-i, cache)%mod)%mod;
        }

        return cache[n][target] = ways;
    }
    public int numRollsToTarget(int n, int k, int target) {
        int[][] cache = new int[n+1][target+1];
        for(int[] i: cache){
            Arrays.fill(i, -1);
        }

        return totalWays(n, k, target, cache);
    }
}

// Tabulation
// S.C: O(N*target)
class Solution2 {
    final int mod = (int)1e9+7;
    public int numRollsToTarget(int n, int k, int target) {
        int[][] dp = new int[n+1][target+1];

        // dp[i][j] -> number of ways to form target j using i dices of k faces.

        dp[0][0] = 1; // you have nothing to throw and nothing to achieve
        dp[1][0] = 0; // you have one dice to throw but nothing to achieve which is not posible


        for(int i = 1; i<=n; i++){
            for(int j=1; j<=target; j++){
                for(int face = 1; face <= k; face++){
                    if(j >= face)  // j represents the current target we want to achieve
                        dp[i][j] = (dp[i][j] + dp[i-1][j-face])%mod;
                }
            }
        }

        return dp[n][target];
    }
}

// Upon careful observation, we can further reduce the state, as we only need the valus of the immediate previous state for computing
// current state

// S.C: O(target)
class Solution4 {
    final int mod = (int)1e9+7;
    public int numRollsToTarget(int n, int k, int target) {
        int[] dp = new int[target+1];

        // dp[i] -> the number of ways to achieve the target on previous state

        dp[0] = 1; // this is for state n = 0, for n = 1 this will act as previous state


        for(int i = 1; i<=n; i++){
            int[] currState = new int[target+1]; // to store the values for curr state
            for(int j=1; j<=target; j++){
                for(int face = 1; face <= k; face++){
                    if(j >= face)  // j represents the current target we want to achieve
                        currState[j] = (currState[j] + dp[j-face])%mod;
                }
            }
            dp = currState; // make currstate as prev state for upcoming state
        }
  
        return dp[target]; // at the end of the loop the dp will store the number of ways for state with n number of dice
    }
}


public class number_of_dice_rolls_with_target {
    
}
