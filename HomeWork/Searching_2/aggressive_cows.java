package HomeWork.Searching_2;

import java.util.*;

// T.C - > O(log(max(stalls)-min(stalls)))*O(len(stalls))

class Solution {
    // This function checks if it is possible to place given number of cows at a distance of atleast 'distance'
    public static boolean isPossible(int[] stalls, int numberOfCows, int distance){
        int numberOfPlacedCows = 1;
        int previous = stalls[0];
        
        for(int i=1; i<stalls.length; i++){
            if(stalls[i]-previous >= distance){
                previous = stalls[i];
                numberOfPlacedCows++;
            }
        }
        
        return numberOfPlacedCows >= numberOfCows;
    }
    public static int solve(int n, int k, int[] stalls) {
        
        int ans = 1;
        Arrays.sort(stalls);
        int low = 1;
        int high = stalls[n-1] - stalls[0];
        while(low <= high){
            int mid = low + (high - low)/2;
            
            if(isPossible(stalls, k, mid)){ // Check if is it possible to place cows at a minimum distance of mid.
                low = mid + 1; // A better answer can be found at upper part
                ans = Math.max(ans, mid);
            } else{ // answer will be in left part
                high = mid - 1;
            }
        }
        
        return ans;
    }
}
public class aggressive_cows {
    
}
