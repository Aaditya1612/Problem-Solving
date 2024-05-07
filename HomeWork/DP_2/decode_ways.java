package HomeWork.DP_2;
import java.util.*;

// Recursion + memoization
// T.C: O(N)
// S.C: O(2*N)
class Solution {
    // this function will tell me the ways to decode the given string starting from index i
    public int waysToDecode(String s, int i, int[] cache){
        if(i>=s.length()){
            return 1;
        }

        if(s.charAt(i) == '0'){
            return 0;
        }

        if(cache[i] != -1){
            return cache[i];
        }

        int notCombineNext = waysToDecode(s, i+1, cache);
        int combineNext = 0;

        if(i+1<s.length() && Integer.parseInt(s.charAt(i)+"")*10 + Integer.parseInt(s.charAt(i+1)+"") <= 26){
            combineNext = waysToDecode(s, i+2, cache);
        }

        return cache[i] = notCombineNext + combineNext;
    }
    public int numDecodings(String s) {
        int[] cache = new int[s.length()];
        Arrays.fill(cache, -1);
        return waysToDecode(s, 0, cache);
    }
}

// Tabulation
// T.C: O(N), S.C: O(N)

class Solution2 {
    public int numDecodings(String s) {
        int n = s.length();
        int[] dp = new int[n+1];
        // dp[i] -> number of ways to decode the string starting from index i

        dp[n] = 1;
        dp[n-1] = s.charAt(n-1) == '0' ? 0 : 1; // we cannot decode '0' alone

        for(int i=n-2; i>=0; i--){

            if(s.charAt(i) == '0') continue;

            dp[i] = dp[i+1];

            if(i+1<n && Integer.parseInt(s.charAt(i)+"")*10 + Integer.parseInt(s.charAt(i+1)+"") <= 26){
                dp[i] += dp[i+2];
            }
        }

        return dp[0]; // ways to decode the string starting from index 0
    }
}

// If we do careful observation then the output of the current satte is dependent on next state and next to next state only so we do not
// need to maintain the whole dp array, we can simply use two variables to keep track of these two next states

// T.C: O(N)
// S.C O(1)

class Solution3 {
    public int numDecodings(String s) {
        int n = s.length();
        int nextTonext = 1;
        int nextState = s.charAt(n-1) == '0' ? 0 : 1; // we cannot decode '0' alone

        for(int i=n-2; i>=0; i--){

            if(s.charAt(i) == '0'){
                nextTonext = nextState;
                nextState = 0;
                continue;
            }

            int currState = nextState;

            if(i+1<n && Integer.parseInt(s.charAt(i)+"")*10 + Integer.parseInt(s.charAt(i+1)+"") <= 26){
                currState += nextTonext;
            }

            nextTonext = nextState;
            nextState = currState;
        }

        return nextState; // at the end of the loop nextState will have the value for 0
    }
}
public class decode_ways {
    
}
