package HomeWork.Graph_5;

import java.util.*;

class Pair{
    int node;
    int wt;
    public Pair(int node, int wt){
        this.node = node;
        this.wt = wt;
    }
}

// Apply dijkastra taking every node as source node and find the number of cities within the given distanceThreshold
// T.C: O(N*(N+E)logN)
class Solution {
    public int findNumberofCities(int n, int src, List<List<Pair>> adj, int distanceThreshold){
        PriorityQueue<Pair> pq = new PriorityQueue<>((x, y)->(x.wt-y.wt));

        boolean[] vis = new boolean[n];
        int[] dis = new int[n];
        Arrays.fill(dis, Integer.MAX_VALUE);

        pq.add(new Pair(src, 0));
        dis[src] = 0;

        while(!pq.isEmpty()){
            Pair curr = pq.poll();

            if(vis[curr.node]) continue;

            vis[curr.node] = true;

            for(Pair neigh: adj.get(curr.node)){
                if(vis[neigh.node]){
                    continue;
                }

                if(dis[neigh.node] > curr.wt + neigh.wt){
                    dis[neigh.node] = curr.wt + neigh.wt;
                    pq.add(new Pair(neigh.node, dis[neigh.node]));
                }
            }
        }
        int count = 0;
        for(int i: dis){
            if(i <= distanceThreshold) count++;
        }

        return count;
    }
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        List<List<Pair>> adj = new ArrayList<>();

        for(int i=0; i<n; i++){
            adj.add(new ArrayList<>());
        }
        for(int[] edge: edges){
            adj.get(edge[0]).add(new Pair(edge[1], edge[2]));
            adj.get(edge[1]).add(new Pair(edge[0], edge[2]));
        }

        int minCount = 0;
        int resNode = 0;

        for(int i=0; i<n; i++){
            int count = findNumberofCities(n, i, adj, distanceThreshold);
            if(i == 0) minCount = count;
            if(minCount >= count){
                resNode = i;
                minCount = count;
            }
        }

        return resNode;
    }
}