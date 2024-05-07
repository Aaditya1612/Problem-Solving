package HomeWork.DP_2;
import java.util.*;


// Recursion + Memoization

// T.C : O(N), S.C: O(2*N)
class Solution
{
    final int mod = (int)1e9+7;
    public long countPairings(int n, long[] cache){
        if(n<0){
            return 0;
        }
        if(n==0){
            return 1;
        }
        
        if(n == 1){
            return 1;
        }
        
        if(cache[n] != -1){
            return cache[n];
        }
        return cache[n] = (countPairings(n-1, cache)%mod + (n-1)*countPairings(n-2, cache)%mod)%mod; 
    }
    public long countFriendsPairings(int n) 
    { 
        long[] cache = new long[n+1];
        Arrays.fill(cache, -1);
        // cache[i] number f ways to pair i number of friends
        return countPairings(n, cache);
    }
}    


// Tabulation 
// T.C: O(N), S.C: O(N)

class Solution2
{
    final int mod = (int)1e9+7;
    public long countFriendsPairings(int n) 
    { 
        long[] dp = new long[n+1];
        // cache[i] number f ways to pair i number of friends
        
        dp[0] = 1;
        dp[1] = 1;
        
        for(int i=2; i<=n; i++){
            dp[i] = (dp[i-1] + (i-1)*dp[i-2])%mod;
        }
        return dp[n];
    }
} 


// We can observe that we are ony using previous two states for computing current state so using an array of length n is useless. We can 
// simply keep track of last two states using two variables which will reduce the space complexity of our code to O(1)

// T.C: O(N)
// S.C: O(1)
class Solution3
{
    final int mod = (int)1e9+7;
    public long countFriendsPairings(int n) 
    {
        long prevTwo = 1;
        long prevOne = 1;
        
        for(int i=2; i<=n; i++){
            long curr = (prevOne + (i-1)*prevTwo)%mod;
            prevTwo = prevOne;
            prevOne = curr;
        }
        return prevOne;  // At the end of the loop prevOne wil have the answer for N number of friends
    }
} 
public class friends_pairing_problem {
    
}
