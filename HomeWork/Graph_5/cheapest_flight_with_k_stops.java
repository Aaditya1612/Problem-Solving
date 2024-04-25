package HomeWork.Graph_5;

import java.util.*;

class Trio{
    int node;
    int cost;
    int stop;
    public Trio(int node, int cost, int stop){
        this.node = node;
        this.cost = cost;
        this.stop = stop;
    }
}
class Pair{
    int node, cost;

    public Pair(int node, int cost){
        this.node = node;
        this.cost = cost;
    }
}

// below solution is using the priority queue, but if we had used queue then the number of if else condition would of reduced because using queue
// would have allowed us to explore all the nodes with equal stops first then move to other.

// Also we cannot use visited here because it might happen that we mark current node as visited with some number of stops but we may reach that
// node in future as well with less cost and same number of stops. (notice priority queue is being heapify based on number of stops)
class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<Pair>> adj = new ArrayList<>();

        for(int i=0; i<n; i++){
            adj.add(new ArrayList<>());
        }
        for(int[] flight: flights){
            adj.get(flight[0]).add(new Pair(flight[1], flight[2]));
        }

        PriorityQueue<Trio> pq = new PriorityQueue<>((x, y) -> Integer.compare(x.stop, y.stop)); // tried using cost but failed on last test case
        int[] costs = new int[n];
        Arrays.fill(costs, Integer.MAX_VALUE);
        pq.add(new Trio(src, 0, -1)); // used -1 as stop value for source because we are not counting destination as source, means if we move directly from source to destination (if such path exists) hten number of stops will be zero.
        // we could have also used 0 as number of stops for src node in that case if conditions would have changed. (See solution using queue )
        costs[src] = 0;
        int[] stopCount = new int[n]; // need to keep track of stop counts of each node as well because the path depends on cost as well as stop counts. That is why here queue is preferable, atleast according to me :)
        Arrays.fill(stopCount, Integer.MAX_VALUE);
        stopCount[src] = -1;
        while(!pq.isEmpty()){
            Trio curr = pq.poll();

            for(Pair neigh: adj.get(curr.node)){
                if(costs[neigh.node] > curr.cost + neigh.cost && curr.stop+1 <= k){
                    costs[neigh.node] = curr.cost + neigh.cost;
                    pq.add(new Trio(neigh.node, costs[neigh.node], curr.stop+1));
                    stopCount[neigh.node] = curr.stop+1;
                } else if(curr.stop+1 < stopCount[neigh.node] && curr.stop+1 <= k){ // if node is reachable with less value of stops then also add in pq
                    pq.add(new Trio(neigh.node, curr.cost + neigh.cost, curr.stop+1));
                    stopCount[neigh.node] = curr.stop+1;
                }
            }
        }
        System.out.println(Arrays.toString(costs));
        System.out.println(Arrays.toString(stopCount));
       return costs[dst] == Integer.MAX_VALUE ? -1 : costs[dst];

    }
}


// staight forward Solution using queue only

class Tuple
{
    int stops;
    int node;
    int dist;
    public Tuple(int s,int node,int dis)
    {
        stops=s;
        this.node=node;
        dist=dis;
    }
}
class Pairs
{
    int stop;
    int distance;
    public Pairs(int s,int d)
    {
        stop=s;
        distance=d;
    }
}
class Solution2 
{
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) 
    {
        List<List<Pairs>> adj=new ArrayList<>();

        for(int i=0;i<n;i++)  adj.add(new ArrayList<Pairs>());

        for(int i=0;i<flights.length;i++)
            adj.get(flights[i][0]).add(new Pairs(flights[i][1],flights[i][2]));
        
        Queue<Tuple> queue=new LinkedList<>();
        int[] dist=new int[n];
        Tuple start=new Tuple(0,src,0);
        queue.add(start);
        Arrays.fill(dist,Integer.MAX_VALUE);

        while(!queue.isEmpty())
        {
            Tuple top=queue.peek();
            queue.remove();
            int stops=top.stops;
            int node=top.node;
            int distance=top.dist;
            for(Pairs curr : adj.get(node))
            {
                int destination=curr.stop;
                int amount=curr.distance;
                if(stops<=k && dist[destination]>distance+amount)
                {
                    dist[destination]=distance+amount;
                    queue.add(new Tuple(stops+1,destination,distance+amount));
                }
            }
        }
        int ans=dist[dst];
        return (ans==Integer.MAX_VALUE) ? -1 : ans;
    }
}

public class cheapest_flight_with_k_stops {
    
}
