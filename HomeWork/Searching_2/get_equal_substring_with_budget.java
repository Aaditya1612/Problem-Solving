package HomeWork.Searching_2;

// Two solutionss
// 1 - Sliding window
// 2 - Binary Search


// Solution-2: Binary Search, T.C -> O(NLogN), N -> length of s

class Solution1 {

    // function to check if it is possible to acieve a substring of s of length mid changable to t within maxCost
    public boolean isPossible(String s, String t, int mid, int maxCost){
        int cost = 0;

        // use fixed size sliding window to calculate the cost of size mid
        for(int i=0; i<mid; i++){
            cost += Math.abs(s.charAt(i) - t.charAt(i));
        }

        // update window and cost
        for(int i=mid; i<s.length(); i++){
            if(cost <= maxCost){ // if any substring is available then return true
                return true;
            }
            cost -= Math.abs(s.charAt(i-mid) - t.charAt(i-mid));
            cost += Math.abs(s.charAt(i) - t.charAt(i));
        }

        if(cost <= maxCost) return true;

        return false;
    }
    public int equalSubstring(String s, String t, int maxCost) {
        int low = 0;
        int high = s.length(); // search space
        int ans = 0;
        while(low<=high){
            int mid = low + (high - low)/2;
            
            if(isPossible(s, t, mid, maxCost)){ // if possible then try to increase the size of substring by going to right
                low = mid + 1;
                ans = mid;
            } else{ // if not possible then try to decrease the size of the substring by going to left
                high = mid - 1;
            }
        }  
        return ans; 
    }
}

// Solution-1: Sliding window, T.C -> O(N), N-> length of s
class Solution2 {
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
