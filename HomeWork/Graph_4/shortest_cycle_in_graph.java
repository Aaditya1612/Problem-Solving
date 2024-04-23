package HomeWork.Graph_4;

import java.util.*;

// Tried everything, the DFS solution won't work for this, because we need to traverse all the neighbours first and that is
// the good approach to find minimal length of cycle



// BFS Solution
// T.C: O((N+E)*N)
// S.C: O(N) + O(N)
class Solution {
    public int bfs(int n, List<List<Integer>> adj, int node){
        int[] vis = new int[n];
        Queue<Integer> q = new LinkedList<>();
        Arrays.fill(vis, -1);
        q.add(node);
        vis[node] = 0;
        int[] parent = new int[n];
        int ans = (int) 1e9;
        while(!q.isEmpty()){
            int curr = q.poll();

            for(int neigh: adj.get(curr)){
                if(vis[neigh] == -1){ // if not already visited the neighour then visit it and mark the number of nodes to neighbour as number of nodes till curr + 1
                    vis[neigh] = vis[curr] + 1;
                    q.add(neigh);
                    parent[neigh] = curr;
                } else{
                    if(parent[curr] != neigh) // the neighbor should not be the parent, important check otherwise the answer will always come as 2 (between parent and neighbour)
                    ans = Math.min(ans, vis[neigh] + vis[curr]+1); // The very first node from where we has called the bfs will always have vis value as 0, so if that ultimate starting node contribute to the answer then this formula holds true
                }
            }
        }

        return ans;

    }
    public int findShortestCycle(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();

        for(int i=0; i<n; i++){
            adj.add(new ArrayList<>());
        }
        for(int[] edge: edges){
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        int ans = (int)1e9;
        for(int i=0; i<n; i++){ // need to consider all vertices individually, no just because of unconnected components but also because minimum cycle can start from any node
            ans = Math.min(ans, bfs(n, adj, i));
        }

        return ans == (int)1e9 ? -1 : ans;
    }
}

// DFS Solution which won't work
class Solution2 {
    public int dfs(int node, int n, List<List<Integer>> adj, int[] vis, int parent){
        int ans = (int)1e9;
        for(int neigh: adj.get(node)){
            if(vis[neigh] == 0){
                vis[neigh] = vis[node] + 1;
                ans = Math.min(ans, dfs(neigh, n, adj, vis, node));
            } else{
                if(neigh != parent){
                    System.out.println(node + " " + vis[node]);
                    ans = Math.min(ans, Math.abs(vis[neigh] - vis[node])+1);
                }
            }
        }

        return ans;
    }
    public int findShortestCycle(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0; i<n; i++){
            adj.add(new ArrayList<>());
        }
        for(int[] edge: edges){
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        int ans = (int)1e9;
        for(int i=0; i<n; i++){
            int[] vis = new int[n];
            vis[i] = 1;
            ans = Math.min(ans, dfs(i, n, adj, vis, i));
        }

        return ans == (int)1e9 ? -1 : ans;
    }
}

public class shortest_cycle_in_graph {
    
}
