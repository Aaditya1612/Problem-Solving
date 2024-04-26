package HomeWork.Graph_5;
import java.util.*;


// T.C: O(E) + O((E + NLOGE)) + O(N) + O(N + E)
// S.C: O(3*E)+ O(3*N) 
class Pair{
    int node, dis;
    public Pair(int node, int dis){
        this.node = node;
        this.dis = dis;
    }
}
class Solution {
    // find the minimum distance 
    public int[] dijkastra(List<List<Pair>> adj, int n){
        PriorityQueue<Pair> pq = new PriorityQueue<>((x, y) -> (x.dis - y.dis));
        boolean vis[] = new boolean[n];
        int[] dis = new int[n];
        Arrays.fill(dis, Integer.MAX_VALUE);
        dis[0] = 0;
        pq.add(new Pair(0, 0));

        while(!pq.isEmpty()){
            Pair curr = pq.poll();

            if(vis[curr.node]){
                continue;
            }
            vis[curr.node] = true;

            for(Pair neigh: adj.get(curr.node)){
                if(vis[neigh.node]){
                    continue;
                }
                if(dis[neigh.node] > curr.dis + neigh.dis){
                    dis[neigh.node] = curr.dis + neigh.dis;
                    pq.add(new Pair(neigh.node, dis[neigh.node]));
                }
            }
        }

        return dis;
    }
    public boolean[] findAnswer(int n, int[][] edges) {
        List<List<Pair>> adj = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();
        for(int i=0; i<n; i++){
            adj.add(new ArrayList<>());
        }
        int index = 0;
        for(int[] edge: edges){
            adj.get(edge[0]).add(new Pair(edge[1], edge[2]));
            adj.get(edge[1]).add(new Pair(edge[0], edge[2]));
            map.put(edge[0] + ":" + edge[1], index); // adding into hashmap so that the index of each edge can be retrived in O(1)
            map.put(edge[1] + ":" + edge[0], index++);
        }

        boolean[] ans = new boolean[edges.length];

        int[] totalCost = dijkastra(adj, n);

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(n-1, totalCost[n-1]));
        // Start BFS fron n-1 node and take edges which have contributed to the minimum distance, there index can be get from HashMap created earlier
        while(!q.isEmpty()){
            Pair curr = q.poll();
            for(Pair neigh: adj.get(curr.node)){
                if(curr.dis - neigh.dis == totalCost[neigh.node]){
                    ans[map.get(curr.node + ":" + neigh.node)] = true;
                    q.add(new Pair(neigh.node, totalCost[neigh.node]));
                }
            }
        }

        return ans;
    }
}   

public class find_edges_in_shortest_path {
    
}
