package HomeWork.Graph_1;
import java.util.*;

// Simple BFS, check is the destination is reachable from the source node using BFS or not.

// S.C: O(N) + O(N), T.C: O(N)
class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        boolean vis[] = new boolean[n];

        Queue<Integer> q = new LinkedList<>();
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0; i<n; i++){ adj.add(new ArrayList<>());};

        for(int[] edge: edges){
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        q.add(source);
        vis[source] = true;

        while(!q.isEmpty()){
            int currNode = q.poll();

            for(int neighbors: adj.get(currNode)){
                if(vis[neighbors]) continue;
                vis[neighbors] = true;
                q.add(neighbors);
            }
        }

        return vis[destination];
    }
}
public class find_if_path_exists_in_graph {
    
}
