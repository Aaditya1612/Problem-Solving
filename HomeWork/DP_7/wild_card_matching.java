
// Reursion + memoizat : O(N+M)

class Solution {
    // a function which will tell me wether it is possible to match or not. If i have a ? in the pattern then I
    // I can match the corresponding character from the string s, if I have a * then either I can skip the
    // * or I can match it with next substring

    public boolean helper(int i, int j, String s, String p, Boolean[][] cache){

        if(i >= s.length() && j >= p.length()){
            return true;
        }
        if(i>=s.length()){
            while(j < p.length() && p.charAt(j) == '*') j++;
            return j >= p.length();
        } if(j >= p.length()){
            return false;
        }
        if(cache[i][j] != null){
            return cache[i][j];
        }
        if(p.charAt(j) == '?' || s.charAt(i) == p.charAt(j)){
            return cache[i][j] = helper(i+1, j+1, s, p, cache);
        }
        else if(p.charAt(j) == '*')
            return cache[i][j] = helper(i+1, j, s, p, cache) || helper(i, j+1, s, p, cache);

        return false;
    }
    public boolean isMatch(String s, String p) {
        Boolean[][] cache = new Boolean[s.length()][p.length()];
        return helper(0, 0, s, p, cache);
    }
}

class Solution2 {
    public boolean isMatch(String s, String p) {
        int n = s.length();
        int m = p.length();
        boolean[][] dp = new boolean[n+1][m+1];

        // dp[i][j] -> is it possible to match from n-i and m-j length
        dp[n][m] = true;

        for(int j = m-1; j>=0; j--){
            if(p.charAt(j) != '*') break;
            dp[n][j] = true;
        }

        for(int i=n-1; i>=0; i--){
            for(int j=m-1; j>=0; j--){
                if(p.charAt(j) == '?' || s.charAt(i) == p.charAt(j)){
                    dp[i][j] = dp[i+1][j+1];
                } else if(p.charAt(j) == '*'){
                    dp[i][j] = dp[i+1][j] || dp[i][j+1];
                } else{
                    dp[i][j] = false;
                }
            }
        }

        return dp[0][0];

    }
}

public class wild_card_matching {
    
}
