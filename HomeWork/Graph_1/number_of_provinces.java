package HomeWork.Graph_1;

import java.util.*;


// Equivalent to find number of compnenets.
// T.C: O(N) + O(N*N)
// S.C: O(N) + O(N*N)
class Solution {
    public void dfs(HashMap<Integer, ArrayList<Integer>> adj, boolean[] vis, int i){
        if(vis[i]) return;
        vis[i] = true;
        for(int j: adj.get(i)){
            dfs(adj, vis, j);
        }
    }
    public int findCircleNum(int[][] isConnected) {
        HashMap<Integer, ArrayList<Integer>> adj = new HashMap<>();

        for(int i=0; i<isConnected.length; i++){
            for(int j=0; j<isConnected[0].length; j++){
                if(isConnected[i][j]==1){
                    adj.putIfAbsent(i, new ArrayList<>());
                    adj.get(i).add(j);
                }
            }
        }
        boolean[] vis = new boolean[isConnected.length];
        int res = 0;
        for(int i=0; i<isConnected.length; i++){
            if(!vis[i]){
                res++;
                dfs(adj, vis, i);
            } 
        }

        return res;


    }
}
public class number_of_provinces {
    
}
