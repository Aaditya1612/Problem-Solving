#include<bits/stdc++.h>
using namespace std;


// Recursion + Memoization
// T.C: O(n*x)
// S.C: O(n*x) + o(n)
int minCoins(int ind, int coins[], int x, int n, vector<vector<int>>& cache){

    if(ind == n-1){
        if(x % coins[ind] == 0){
            return x/coins[ind];
        }

        return (int)1e9;
    }

    if(x == 0){
        return 0;
    }
    if(cache[ind][x] != -1){
        return cache[ind][x];
    }
    int takeCurr = (int)1e9;

    if(coins[ind] <= x){
        takeCurr = 1 + minCoins(ind, coins, x-coins[ind], n, cache);
    }

    int leaveCurr = minCoins(ind+1, coins, x, n, cache);

    return cache[ind][x] = min(takeCurr, leaveCurr);

}


int tabulatedMinCoins(int coins[], int n, int x){
    vector<int> dp(x+1, (int)1e9); // Initially marking all the tragets as not possible
    
    // dp[i] -> minimum number of coins required to achieve a target i
    dp[0] = 0; // To achieve a target of 0 you need 0 coins
    

    for(int i=1; i<=x; i++){
        for(int j=0; j<n; j++){
            if(coins[j] <= i){
                dp[i] = min(dp[i], 1+dp[i-coins[j]]);
            }

        }

    }

    return dp[x];
}
int main(){
    int n, x;
    cin >> n;
    cin >> x;
    int coins[n];

    for(int i=0; i<n; i++){
        cin >> coins[i];
    }

    int ans =  tabulatedMinCoins(coins, n, x);
    cout << (ans >= (int)1e9 ? -1 : ans);
    return 0;

}