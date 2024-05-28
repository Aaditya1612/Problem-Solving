package HomeWork.DP_1;
import java.util.*;

// Memoization:
// T.C: O(N)
// S.C: O(N) + O(N)

class Solution {
    public int findMinJumps(int i, int[] nums, int[] cache){
        if(i >= nums.length - 1){
            return 0;
        }
        if(cache[i] != -1) return cache[i];
        int currSteps = nums[i];
        int ans = (int)1e9;
        for(int j = 1; j<=currSteps; j++){
            ans = Math.min(ans, 1+findMinJumps(i+j, nums, cache));
        }

        return cache[i] = ans;
    }
    public int jump(int[] nums) {
        int n = nums.length;
        int[] cache = new int[n];
        Arrays.fill(cache, -1);
        return findMinJumps(0, nums, cache);
    }
}

// Tabulation solution
// T.C : O(N)
// S.C: O(N)

class Solution2 {
    public int jump(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        // dp[i] = minimum jumps to reach n-1 from index i;
        Arrays.fill(dp, (int)1e9);
        dp[n-1] = 0; // already standing on n-1 so it should be 0

        for(int i=n-2; i>=0; i--){
            int currStep = nums[i];
            for(int j=1; j<=currStep; j++){
                if(i+j>=n) continue;
                dp[i] = Math.min(dp[i], 1 + dp[i+j]);
            }
        }

        return dp[0]; // minimum jumps requiered to reach n-1 from index 0
        
    }
}

// Greedy Solution
// T.C: O(N), S.C: O(1)

class Solution4 {
    public int jump(int[] nums) {
        int n = nums.length;
        int maxReach = 0;
        int tmpReach = 0;

        int ans = 0;
        for(int i=0; i<n; i++){
            tmpReach = Math.max(tmpReach, nums[i]+i);

            if(i == maxReach && i<n-1){
                ans++;
                maxReach = tmpReach;
            }
        }

        return ans;
    }
}

public class jump_game_2 {
    
}
