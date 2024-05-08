package HomeWork.DP_3;
import java.util.*;



// Recursion + memozation
// T.C : O(N*amount)
// S.C : O(N*amount) + O(N)
class Solution {
    public int change(int amount, int[] coins) {
        int[][] cache = new int[coins.length][amount+1];
        for(int[] i : cache){
            Arrays.fill(i, -1);
        }
        int count=coinChange(coins,amount,0, cache);
        return count;
    }

    public int coinChange(int[] coins, int amount , int ind, int[][] cache) {
        if(amount == 0){
            return 1;
        }
        if(ind==coins.length-1){
           return amount%coins[ind]==0?1:0;
        }

        if(cache[ind][amount] != -1){
            return cache[ind][amount];
        }

        int notPick=coinChange(coins,amount,ind+1, cache);
        int pick=0;
        if(coins[ind]<=amount){
            pick=coinChange(coins,amount-coins[ind],ind, cache);
        }
        return cache[ind][amount] = pick+notPick;
    }
}



// Tabulation
// T.C: O(n*amount)
// s.c: O(amount)

class Solution2 {
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount+1];

        // dp[i] -> number of ways I can make an amount i using given denominations

        dp[0] = 1;

        for(int i=0; i<coins.length; i++){
            for(int j=1; j<=amount; j++){
                if(coins[i] <= j){
                    dp[j] = dp[j] + dp[j-coins[i]];
                }
            }
        }

        /*
        
        What would have happend if we had done something like below

        for(int i=1; i<=amount; i++){
            for(int j=0; j<coins.length; j++){
                if(coins[j] <= i){
                    dp[i] = dp[i] + dp[i-coins[j]];
                }
            }
        }


        this will not work because of redundat counts
        
         */
        System.out.println(Arrays.toString(dp));
        return dp[amount];

    }
}
public class coin_change_2 {
    
}
