package HomeWork.DP_1;
import java.util.*;

// Memoization solution
// T.C: O(N)
// S.C: O(N) + O(N)
class Solution {
    public long solve(int ind, int[][] questions, long[] cache){
        
        if(ind >= questions.length){
            return 0;
        }
        if(cache[ind] != -1){
            return cache[ind];
        }

        long solveCurr = questions[ind][0] + solve(ind + questions[ind][1] + 1, questions, cache);
        long leaveCurr = solve(ind+1, questions, cache);

        return cache[ind] = Math.max(solveCurr, leaveCurr);
    }
    public long mostPoints(int[][] questions) {
        long[] cache = new long[questions.length];

        Arrays.fill(cache, -1);

        return solve(0, questions, cache);
    }
}

// Tabulation solution
// T.C: O(N)
// S.C: O(N)

class Solution2 {
    public long mostPoints(int[][] questions) {
        long[] dp = new long[questions.length];
        int n = questions.length;
        // dp[i]  -> maximum points achivable from i to nth question;

        for(int i=n-1; i>=0; i--){
            long solveCurr = questions[i][0] + (i + questions[i][1] + 1 >= n ? 0 : dp[i + questions[i][1] + 1]);
            long leaveCurr = (i + 1 >= n) ? 0 : dp[i+1];

            dp[i] = Math.max(solveCurr, leaveCurr);
        }

        return dp[0];
    }
}


public class solving_questions_with_brainpower {
    
}
