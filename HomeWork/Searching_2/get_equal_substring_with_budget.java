package HomeWork.Searching_2;

// Two solutionss
// 1 - Sliding window
// 2 - Binary Search


// Solution-1: Sliding window, T.C -> O(N), N-> length of s
class Solution {
    public int equalSubstring(String s, String t, int maxCost) {
        int low = 0;
        int high = 0;
        int cost = 0;
        int ans = 0;
        while(high<s.length()){
            cost += Math.abs(s.charAt(high) - t.charAt(high));
            while(cost > maxCost){
                cost -= Math.abs(s.charAt(low) - t.charAt(low));
                low++;
            }
            ans = Math.max(ans, high - low + 1);
            high++;
            
        }

        return ans;
    }
}



public class get_equal_substring_with_budget {
    
}
