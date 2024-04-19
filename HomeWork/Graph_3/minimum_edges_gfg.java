import java.util.*;


// Application of 0/1 BFS
class Solution {
    public static int minimumEdgeReversal(int[][] edges, int n, int m, int src, int dst) {
        List<List<int[]>> adj = new ArrayList<>();
        
        for(int i=0; i<n; i++){
            adj.add(new ArrayList<int[]>());
        }
        for(int i=0; i<m; i++){
            adj.get(edges[i][0]-1).add(new int[]{edges[i][1]-1, 0}); // subtracted 1 because nodes are starting from 1 and doing so will convert them in 0 based indexing
            adj.get(edges[i][1]-1).add(new int[]{edges[i][0]-1, 1});
        }
        Deque<int[]> q = new LinkedList<>();
        boolean[] vis = new boolean[n];
        int[] dis = new int[n];
        
        q.add(new int[]{src-1, 0});

        while(!q.isEmpty()){
            int[] curr = q.removeFirst();
            if(curr[0] == dst-1){
                return curr[1];
            }
            vis[curr[0]] = true;         // At the time of removal onl mark the vis not while pushing in the queue as the shortest distance node will come first than the greater distance node.
            for(int[] neigh: adj.get(curr[0])){
                int neighNode = neigh[0];
                if(!vis[neighNode]){
                    if(neigh[1] == 0){
                        q.addFirst(new int[]{neighNode, curr[1]});
                    } else{
                        q.addLast(new int[]{neighNode, curr[1]+1});
                    }
                }
            }
        }
        
        return -1;
    }
}

class minimum_edges_gfg{

}