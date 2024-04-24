package HomeWork.Graph_5;
import java.util.*;

class Pair{
    int node;
    int time;
    public Pair(int node, int time){
        this.node = node;
        this.time = time;
    }
}
// T.C : O(N) + O(E) + O(N) + O((E+N)logN)
// S.C: O(N + E) + O(N)  + O(N) + O(E)
class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>((x, y) -> Integer.compare(x.time, y.time));

        boolean vis[] = new boolean[n+1];
        List<List<Pair>> adj = new ArrayList<>();

        for(int i=0; i<=n; i++){
            adj.add(new ArrayList<>());
        }

        for(int[] time: times){
            adj.get(time[0]).add(new Pair(time[1], time[2]));
        }

        pq.add(new Pair(k, 0));
        int[] nodeTime = new int[n+1];
        Arrays.fill(nodeTime, Integer.MAX_VALUE);
        nodeTime[0] = 0; // The numbering of nodes start from 1 so 0 can be marked as 0 so that it dosn't cause any problem
        nodeTime[k] = 0;
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

                if(nodeTime[neigh.node] > curr.time + neigh.time){
                    nodeTime[neigh.node] = curr.time + neigh.time;
                    pq.add(new Pair(neigh.node, nodeTime[neigh.node]));
                }
            }
        }

        int ans = Integer.MIN_VALUE;
        for(int i: nodeTime){
            if(i == Integer.MAX_VALUE){
                return -1;
            }
            ans = Math.max(i, ans);
        }

        return ans;
    }
}

public class network_delay_time {
    
}
