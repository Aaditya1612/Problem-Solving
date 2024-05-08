package HomeWork.DP_3;
import java.util.*;


// Recursion + memoization
// T.C: O(N*amount)
// S.C: O(N) + O(N*AMOUNT)
class Solution {
    public int coinChange(int i, int[] coins, int target, int[][] cache){
        if(target == 0){
            return 0;
        }
        if(i >= coins.length){
            return (int)1e9;
        }
        if(cache[i][target] != -1){
            return cache[i][target];
        }
        int takeCurrent = Integer.MAX_VALUE;
        if(target >= coins[i])
            takeCurrent = 1 + coinChange(i, coins, target - coins[i], cache);
        int leaveCurrent = coinChange(i+1, coins, target, cache);

        return cache[i][target] = Math.min(takeCurrent, leaveCurrent);

    }
    public int coinChange(int[] coins, int amount) {
        int[][] cache = new int[coins.length][amount+1];
        
        for(int[] i: cache){
            Arrays.fill(i, -1);
        }
        int ans = coinChange(0, coins, amount, cache);
        return ans == (int)1e9 ? -1 : ans;
    }
}

// Tabulation
// T.C: O(N*amount)
// S.C: O(amount)

class Solution2 {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        // dp[i] -> minimum number of coins required to make an amount of i
        Arrays.fill(dp, (int)1e9);
        dp[0] = 0; // to form 0 amount you will need 0 coins
        for(int i=1; i<=amount; i++){
            for(int j=0; j<coins.length; j++){
                if(coins[j] <= i){
                    dp[i] = Math.min(dp[i], 1 + dp[i - coins[j]]);
                }
            }
        }

        return dp[amount] >= (int) 1e9 ? -1 : dp[amount];
    }
}
public class coin_change {
    
}
