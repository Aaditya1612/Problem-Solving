package HomeWork.Graph_5;
import java.util.*;

// Use dijkastra, keep on setting the node with maximum probabilty to reach as curr node (using priority queue)
class El{
    int node;
    double prob;
    public El(int node, double prob){
        this.node = node;
        this.prob = prob;
    }
}

// T.C : O(N) + O(E) + O(N) + O((E+N)logN)
// S.C: O(N + E) + O(N)  + O(N) + O(E)
class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        PriorityQueue<El> pq = new PriorityQueue<El>((x, y) -> Double.compare(y.prob, x.prob));
        List<List<El>> adj = new ArrayList<>();
       
        for(int i=0; i<n; i++){
            adj.add(new ArrayList<>());
        }

        int ind = 0;

        for(int[] edge: edges){
            adj.get(edge[0]).add(new El(edge[1], succProb[ind]));
            adj.get(edge[1]).add(new El(edge[0], succProb[ind++]));
        }
        boolean[] vis = new boolean[n];
        pq.add(new El(start_node, 1.0));
        double[] prob = new double[n];
        Arrays.fill(prob, 0.0);
        prob[start_node] = 1;
        while(!pq.isEmpty()){
            El curr = pq.poll();
            if(vis[curr.node]){
                continue;
            }

            vis[curr.node] = true;

            for(El neigh: adj.get(curr.node)){
                if(vis[neigh.node]){
                    continue;
                }

                if(prob[neigh.node] < curr.prob*neigh.prob){
                    prob[neigh.node] = curr.prob*neigh.prob;
                    pq.add(new El(neigh.node, curr.prob*neigh.prob));
                }
            }
        }

        return prob[end_node];
    }
}

public class path_with_maximum_probability {
    
}
