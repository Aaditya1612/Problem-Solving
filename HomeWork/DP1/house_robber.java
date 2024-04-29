package HomeWork.DP1;
import java.util.*;

// Memoization solution
// T.C: O(N)
// S.C: O(N) + O(N)
class Solution {
    public int maxLoot(int ind, int[] nums, int[] cache){
        
        if(ind<0) return 0;
        if(ind==0) return nums[0];
        if(cache[ind]!=-1) return cache[ind];
        int pick = nums[ind] + maxLoot(ind-2, nums, cache);
        int npick = maxLoot(ind-1, nums, cache);

        return cache[ind] = Math.max(pick, npick);
    }
    public int rob(int[] nums) {
        int[] cache = new int[nums.length];
        Arrays.fill(cache, -1);
        // cache[i] -> maximum steal possible from i to nth house (bottom up approach)
        return maxLoot(nums.length-1, nums, cache);
    }
}

// Tabulation solution

// T.c: O(N)
// S.C: O(N)
class Solution2 {
    public int rob(int[] nums) {
        int[] dp = new int[nums.length+1];
        dp[0] = 0;
        dp[1] = nums[0];
        // dp[i] -> maximum steal till ith house (bottom up approach)

        for(int i=2; i<=nums.length; i++){
            dp[i] = Math.max(dp[i-1], nums[i-1] + dp[i-2]);
        }
        return dp[nums.length]; // maximum loot till nth house
    }
}

// Space optimized solution
// S.C: O(1)
class Solution3 {
    public int rob(int[] nums) {
        int[] dp = new int[nums.length+1];
        int secondLastVal = 0;
        int lastVal = nums[0];

        for(int i=2; i<=nums.length; i++){
            int currVal = Math.max(lastVal, nums[i-1] + secondLastVal);
            secondLastVal = lastVal;
            lastVal = currVal;
        }
        return lastVal; // maximum loot till nth house
    }
}

public class house_robber {
    
}
