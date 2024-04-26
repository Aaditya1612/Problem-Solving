package HomeWork.Graph_6;
import java.util.*;

class DSU{
    int[] size;
    int[] parent;
    public DSU(int numNodes){
        size = new int[numNodes];
        parent = new int[numNodes];

        for(int i=0; i<numNodes; i++){
            size[i] = 1;
            parent[i] = i;
        }
    }

    public int findUParent(int node){
        if(parent[node] == node){
            return node;
        }

        return parent[node] = findUParent(parent[node]);
    }

    public boolean union(int v1, int v2){
        int up1 = findUParent(v1);
        int up2 = findUParent(v2);

        if(up1 == up2){
            return false;
        }

        if(size[up1] < size[up2]){
            parent[up1] = up2;
            size[up2] = size[up1]+size[up2];
        } else{
            parent[up2] = up1;
            size[up1] = size[up2] + size[up1];
        }

        return true;
    }

    public boolean allNodesInSameComponent(int numNodes){
        int firstParent = findUParent(1);
        
        for(int i=2; i<numNodes; i++){
            int currP = findUParent(i);
            if(currP != firstParent){
                return false;
            }
        }

        return true;
    }

}
class Solution {
    public int[] findRedundantDirectedConnection(int[][] edges) {
        int edgeToRemove1 = -1;
        int edgeToRemove2 = -1;
        int n = edges.length;
        int[] indegree = new int[n+1];
        DSU dsu = new DSU(n+1);
        Arrays.fill(indegree, -1);
        for(int i=0; i<n; i++){
            int[] edge = edges[i];

            if(indegree[edge[1]] == -1){
                indegree[edge[1]] = i;
            } else{
                edgeToRemove1 = i;
                edgeToRemove2 = indegree[edge[1]];
                break;
            }
        }       

        if(edgeToRemove1 == -1){
            for(int i =0; i<n; i++){
                boolean canUnite = dsu.union(edges[i][0], edges[i][1]);
                if(!canUnite){
                    return edges[i];
                }
            }
        } 
        for(int i=0; i<n; i++){
            if(edgeToRemove1 == i){
                continue;
            }

            dsu.union(edges[i][0], edges[i][1]);
        }

        if(dsu.allNodesInSameComponent(n+1)){
            return edges[edgeToRemove1];
        }

        return edges[edgeToRemove2];
        
    }
}

public class redundant_connection_2 {
    
}
