package HomeWork.Graph_5;

import java.util.*;
class El{
    int node;
    int time;
    public El(int node, int time){
        this.node = node;
        this.time = time;
    }
}

// Use case of dijkastra algorithm

// T.C: O(N) + O(E) + O((V + E)logV)
// S.C: O(N+E) + O(V) + O(V) + O(V+E)
class Solution {
    public int[] dijkastra(List<List<int[]>> adj, int src, int n, int[] disappear){
        boolean[] vis = new boolean[n];
        int[] dis = new int[n];
        Arrays.fill(dis, -1);

        PriorityQueue<El> pq = new PriorityQueue<>((x, y) -> (x.time - y.time));

        pq.add(new El(src, 0));
        dis[src] = 0;
        while(!pq.isEmpty()){
            El curr = pq.poll();
            if(vis[curr.node]) continue;
            vis[curr.node] = true;
            for(int[] neigh: adj.get(curr.node)){
                if(vis[neigh[0]]){
                    continue;
                }
                if(curr.time + neigh[1] < disappear[neigh[0]] && (dis[neigh[0]]==-1 || curr.time + neigh[1] < dis[neigh[0]])){ // condition after && is to handle the case when there is node with self loop like edge = [0, 0, 2] answer should be 0 but without this specified conditon answer will be 2 which is wrong.
                    dis[neigh[0]] = curr.time + neigh[1];
                    pq.add(new El(neigh[0], dis[neigh[0]]));    
                }
            }
        }

        return dis;
    }
    public int[] minimumTime(int n, int[][] edges, int[] disappear) {
        List<List<int[]>> adj = new ArrayList<>();
        for(int i=0; i<n; i++){
            adj.add(new ArrayList<>());
        }
        for(int[] edge: edges){
            adj.get(edge[0]).add(new int[]{edge[1], edge[2]});
            adj.get(edge[1]).add(new int[]{edge[0], edge[2]});
        }

        return dijkastra(adj, 0, n, disappear);
    }
}