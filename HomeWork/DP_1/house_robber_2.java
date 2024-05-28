package HomeWork.DP_1;

import java.util.*;

// Memoization solution
class Solution {
    public int maxSteal(int i, int[] nums, int[][] cache, int lastTaken){
        if(i == 0){
            return lastTaken == 1 ? 0 : nums[0];
        }
        if(i < 0){
            return 0;
        }
        if(cache[i][lastTaken] != -1) return cache[i][lastTaken];
        int notTake = maxSteal(i-1, nums, cache, lastTaken);
        int take = nums[i] + maxSteal(i-2, nums, cache, i == nums.length-1 ? 1 : lastTaken);
        return cache[i][lastTaken] = Math.max(notTake, take);
    }
    public int rob(int[] nums) {
        int[][] cache = new int[nums.length][2];

        // cache[i][0] -> maximum loot possible from ith house to nth house if last house is not looted
        // cache[i][1] -> maximum loot possible from ith house to nth house if last house is looted
        for(int[] state: cache){
            Arrays.fill(state, -1);
        }
        return maxSteal(nums.length-1, nums, cache, 0);
    }
}
public class house_robber_2 {
    
}
