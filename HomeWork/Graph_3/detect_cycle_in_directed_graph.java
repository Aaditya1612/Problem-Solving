package HomeWork.Graph_3;

import java.util.*;

// Solution using Indegree: The idea is simple, if there exists any cycle in the graph then the indegree of all the nodes won't be able to 
// become 0 at the end of Topo Sort similar process (BFS basically)

// T.C: O(E) + O(V) + O(E+V)
// S.C: O(V)
class Solution {
    // Function to detect cycle in a directed graph.
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        int[] indegree = new int[V];
        
        for(int i=0; i<adj.size(); i++){
            for(int j: adj.get(i)){
                indegree[j]++;
            }
        }
        
        Queue<Integer> q = new LinkedList<>();
        
        for(int i=0; i<V; i++){
            if(indegree[i] == 0){
                q.add(i);
            }
        }
        
        while(!q.isEmpty()){
            int curr = q.poll();
            
            for(int neigh : adj.get(curr)){
                indegree[neigh]--;
                
                if(indegree[neigh] == 0){
                    q.add(neigh);
                }
            }
        }
        
        for(int i: indegree){
            if(i!=0){
                return true;
            }
        }
        
        return false;
    }
}


// DFS Solution
class Solution2 {
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
