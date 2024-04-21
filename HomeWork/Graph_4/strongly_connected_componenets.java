package HomeWork.Graph_4;

import java.util.*;

// Kosaraju's Algorithm for SCC.

// T.c: O(2*(V+E))
// S.C: O(V) + O(V+E)
class Solution
{
    public void dfs(ArrayList<ArrayList<Integer>> adj, int node, Stack<Integer> st, boolean[] vis){
        vis[node] = true;
        
        for(int i: adj.get(node)){
            if(!vis[i]){
                dfs(adj, i, st, vis);
            }
        }
        
        st.push(node);
    }
    
    public void iterateOnComponents(ArrayList<ArrayList<Integer>> adj, int node, boolean[] vis){
        vis[node] = true;
        for(int i: adj.get(node)){
            if(!vis[i])
                iterateOnComponents(adj, i, vis);
        }
    }
    
    public int kosaraju(int V, ArrayList<ArrayList<Integer>> adj)
    {
        Stack<Integer> st = new Stack();
        boolean[] vis = new boolean[V];
        
        for(int i=0; i<V; i++){
            if(!vis[i]){
                dfs(adj, i, st, vis);
            }
        }
        vis = new boolean[V];
        ArrayList<ArrayList<Integer>> adj_rev = new ArrayList<>();
        
        for(int i=0; i<V; i++){
            adj_rev.add(new ArrayList<>());
        }
        
        for(int i=0; i<adj.size(); i++){
            for(int k: adj.get(i)){
                adj_rev.get(k).add(i);
            }
        }
        
        int res = 0;
        
        while(!st.isEmpty()){
            int curr = st.pop();
            
            if(!vis[curr]){
                iterateOnComponents(adj_rev, curr, vis);
                res++;
            }
        }
        
        return res;
    }
}

public class strongly_connected_componenets {
    
}
