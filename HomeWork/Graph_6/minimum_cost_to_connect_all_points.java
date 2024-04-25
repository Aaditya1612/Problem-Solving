package HomeWork.Graph_6;
import java.util.*;



// Create a graph by connecting all the given vertices and assiging weight to each edge as the manhattan distance.
// Then apply Prim's algorithm to find MST (all the vertices will be connected with minimum cost)

// T.C: O(N*N) + O((E+N)logN) -> E = N*N
// S.C: O(N*N) + O(N) + O(E)
class Pair{
    int ver;
    int dist;

    public Pair(int ver, int dist){
        this.ver = ver;
        this.dist = dist;
    }
}
class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                int dist = Math.abs(points[j][0] - points[i][0]) + Math.abs(points[j][1] - points[i][1]);
                adj.get(i).add(new Pair(j, dist));
                adj.get(j).add(new Pair(i, dist));
            }
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>((x, y) -> (x.dist - y.dist));
        boolean[] vis = new boolean[n];
        pq.add(new Pair(0, 0)); 
        int totalCost = 0;
        while (!pq.isEmpty()) {
            Pair curr = pq.poll();
            if (vis[curr.ver]) {
                continue;
            }

            vis[curr.ver] = true; 
            totalCost += curr.dist;

            for (Pair neigh : adj.get(curr.ver)) {
                if (!vis[neigh.ver]) {
                    pq.add(neigh);
                }
            }
        }
        return totalCost; 
    }
}
public class minimum_cost_to_connect_all_points {
    
}
