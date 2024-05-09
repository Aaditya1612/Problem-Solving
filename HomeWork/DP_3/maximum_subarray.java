package HomeWork.DP_3;

// T.C: O(N)
// S.C: O(N)
class Solution {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        // dp[i] -> maximum sum of subarray ending at index i
        dp[0] = nums[0];
        int ans = dp[0];
        for(int i=1; i<n; i++){
            dp[i] = Math.max(dp[i-1]+nums[i], nums[i]); // contribute me to previous sum or start a new subarray from me
            ans = Math.max(ans, dp[i]);
        }
        
        return ans;
    }
}

// If we observe carefully then we need the maximum subarray sum till the last index to compute the maximum sum for the curren the index
// so just keep track of the last state only instead of mainiting whole dp array

// T.C: O(N)
// S.C: O(1)
class Solution2 {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int lastState = nums[0];
        int ans = nums[0];
        for(int i=1; i<n; i++){
            int currState= Math.max(lastState+nums[i], nums[i]); // contribute me to previous sum or start a new subarray from me
            ans = Math.max(ans, currState);
            lastState = currState;
        }
        
        return ans;
    }
}
public class maximum_subarray {
    
}
