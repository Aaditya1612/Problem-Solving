package HomeWork.Graph_1;

import java.util.*;

// T.C: O(N + E)
// S.C: O(N) + O(N) + O(N)
class Solution {
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] vis = new boolean[V];
        boolean[] visInCurrRound = new boolean[V];
        for(int i=0; i<V; i++){
            if(vis[i]){ continue;}
            if(dfs(i, adj, vis, visInCurrRound)) return true;
        }
        
        return false;
    }
    
    public boolean dfs(int curr, ArrayList<ArrayList<Integer>> adj, boolean[] vis, boolean[] visInCurrRound){
        
        vis[curr] = true;
        visInCurrRound[curr] = true;
        
        
        for(int i: adj.get(curr)){
            if(!vis[i]){
                if(dfs(i, adj, vis, visInCurrRound)) return true;
                
            }
            else if(visInCurrRound[i]){
                return true;
            }
        }
        
        visInCurrRound[curr] = false;
        return false;
        
    }
}
public class detect_cycle_in_directed_graph {
    
}
