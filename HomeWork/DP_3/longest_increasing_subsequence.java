package HomeWork.DP_3;
import java.util.*;

// Recursion + Memoization
// T.C: O(N*N)
// S.C: O(N*N)
class Solution {
    public int LIS(int i, int[] nums, int prev, int[][] dp){
        if(i>=nums.length){
            return 0;
        }

        if(prev != -1 && dp[i][prev]!=-1){
            return dp[i][prev];
        }

        int pick = 0;
        if(prev==-1 || nums[i]>nums[prev]){
            pick = 1 + LIS(i+1, nums, i, dp);
        }

        int leave = LIS(i+1, nums, prev, dp);
        if(prev != -1){
            dp[i][prev] = Math.max(pick, leave);
        }
        return Math.max(pick, leave);
    }
    public int lengthOfLIS(int[] nums) {
        int[][] dp = new int[nums.length][nums.length];

        for(int[] i: dp){
            Arrays.fill(i, -1);
        }
        return LIS(0, nums, -1, dp);
    }
}


// Tabulation
// T.C: O(N*N)
// S.C: O(N)

class Solution2 {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        // dp[i] -> length of longest increasing subsequence ending at i

        dp[0] = 1;
        int ans = 1;
        for(int i=1; i<nums.length; i++){
            int maxPrev = 0;
            for(int j=i-1; j>=0; j--){
                if(nums[j] < nums[i])
                    maxPrev = Math.max(maxPrev, dp[j]);
            }

            dp[i] = maxPrev + 1;
            ans = Math.max(ans, dp[i]);
        }

        return ans;
    }
}


// Binary Search solution

// T.C: O(NLogN)
// S.C: O(N)

class Solution3 {
    public int findLowerBound(List<Integer> arr, int val){
        int low = 0;
        int high = arr.size()-1;
        int ans = high;
        while(low<=high){
            int mid = low + (high-low)/2;

            if(arr.get(mid) >= val){
                ans = Math.min(ans, mid);
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }

        return ans;
    }

    public int lengthOfLIS(int[] nums){
        List<Integer> lisStorage = new ArrayList<>();
        int ans = 1;
        lisStorage.add(nums[0]);
        for(int i=1; i<nums.length; i++){
            if(lisStorage.get(lisStorage.size()-1) < nums[i]){
                lisStorage.add(nums[i]);
            } else{
                int lowerBoundIndex = findLowerBound(lisStorage, nums[i]);
                lisStorage.set(lowerBoundIndex, nums[i]);
            }

            ans = Math.max(ans, lisStorage.size());
        }

        return ans;
    }
}

public class longest_increasing_subsequence {
    
}
