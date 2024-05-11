package HomeWork.DP_4;
import java.util.*;

// Recursion + Memoization
// T.C: O(N*target)
// S.C: O(N*target) + O(N)
class Solution {
    public int lis(int ind, List<Integer> nums, int target, int[][] cache){
        if(target == 0){
            return 0;
        }

        if(ind >= nums.size()){
            return -(int)1e9;
        }
        if(cache[ind][target] != -1){
            return cache[ind][target];
        }

        int pickCurr = -(int)1e9;

        if(nums.get(ind) <= target){
            pickCurr = 1 + lis(ind+1, nums, target-nums.get(ind), cache);
        }

        int leaveCurr = lis(ind+1, nums, target, cache);

        return cache[ind][target] = Math.max(pickCurr, leaveCurr);
    }
    public int lengthOfLongestSubsequence(List<Integer> nums, int target) {
        int[][] cache = new int[nums.size()][target+1];

        for(int[] i: cache){
            Arrays.fill(i, -1);
        }

        int ans = lis(0, nums, target, cache);
        System.out.println(ans);

        return ans <= 0 ? -1 : ans;
    }
}

// Tabulation Solution 
// T.C: O(N*target)
// S.C: O(N*target)

class Solution2 {
    public int lengthOfLongestSubsequence(List<Integer> nums, int target) {
        int n = nums.size();
        int[][] dp = new int[nums.size()][target+1];

        // dp[i][j] -> length of the longest subsequence upto index i with target j
        for(int[] i : dp){
            Arrays.fill(i, -(int)1e9); // Initially mark all as not possible then we will eventually populate this dp array
        }
        for(int i=0; i<n; i++){
            dp[i][0] = 0; // it requires a subsequence of maximum length 0 to achieve a targt 0 (Since all elements of nums are positive)
        }
        if(nums.get(0) <= target)
            dp[0][nums.get(0)] = 1; // the target which we can acheive from 0th index is the value at that index itself
        for(int j=1; j<=target; j++){
            for(int i=1; i<n; i++){
                if(j >= nums.get(i)){
                    dp[i][j] = Math.max(dp[i][j], 1+dp[i-1][j-nums.get(i)]);
                }
                dp[i][j] = Math.max(dp[i][j], dp[i-1][j]);
            }
        }

        return dp[n-1][target] <= 0 ? -1 : dp[n-1][target];
    }
}

// sapce otimized version
// T.C: O(n*target)
// S.C: O(target)

class Solution4 {
    public int lengthOfLongestSubsequence(List<Integer> nums, int target){
        int n = nums.size();
        int[] dp = new int[target+1];

        // dp[i] -> length of the longest subsequence to achieve target i till last state
       
        Arrays.fill(dp, -(int)1e9); // Initially mark all as not possible then we will eventually populate this dp array
        dp[0] = 0;
        if(nums.get(0) <= target)
            dp[nums.get(0)] = 1; // the target which we can acheive from 0th index is the value at that index itself (the very initial state)
        
        for(int i=1; i<n; i++){
            int[] currState = new int[target+1];
            for(int j=1; j<=target; j++){
                currState[j] = -(int)1e9; // currently marking j target as not possible
                if(j >= nums.get(i)){
                    currState[j] = 1+dp[j-nums.get(i)];
                }
                currState[j] = Math.max(currState[j], dp[j]);
            }
            dp = currState;
        }

        return dp[target] <= 0 ? -1 : dp[target];
    }
}

public class length_of_longest_subsequence_that_sum_target {
    
}
