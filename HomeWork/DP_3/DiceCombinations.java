
import java.util.*;

public class DiceCombinations {
    final static int mod = (int)1e9+7;
    
    // Recursion + memoization
    // T.C: O(N)
    // S.C: O(N)
    public static int countCombinations(int n, int[] cache){
        if(n == 0){
            return 1;
        }
        if(n < 0){
            return 0;
        }
        if(cache[n] != -1){
            return cache[n];
        }
        int combinations = 0;
        for(int i=1; i<=6; i++){
            combinations = (combinations%mod + countCombinations(n-i, cache)%mod)%mod;
        }

        return cache[n] = combinations;
    }

    // Tabulation
    // T.C: O(N)
    // S.C: O(N)
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] dp = new int[n+1];
        // dp[i] -> number of combinations to achieve i
        
        dp[0] = 1;
        for(int i=1; i<=n; i++){
            for(int j=1; j<=6; j++){
                if(j <= i){
                    dp[i] = (dp[i]%mod + dp[i-j]%mod)%mod;
                }
            }
        }

        System.out.println(dp[n]);

    }
}
