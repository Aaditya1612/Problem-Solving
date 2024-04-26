package HomeWork.Graph_6;
import java.util.*;



// T.C: O(ElogN) 
// S.C: O(2*N)

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
    // This medthod is used to find if all the nodes of the given graph are part of same component or not
    // This method has been implemented to basically handle -1 case
    // We could have also handle the -1 case without the following method (see solution 2), which will save more time
    public boolean isAllConnected(int numNodes){
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
    public int maxNumEdgesToRemove(int n, int[][] edges) {
        DSU aliceDSU = new DSU(n+1);
        DSU bobDSU = new DSU(n+1);

        int ans = 0;
        Arrays.sort(edges, (x, y) -> (y[0]-x[0])); // Sorting and giving priotity to edge of type 3 because we need to remove maximum number of edges possible and thus considering nodes of type 3 are more preferable as in that scenario we can have case of removal of type 1 and type 2 edges over one type 3 edges and count will be maximized
        for(int[] edge: edges){
            System.out.println(Arrays.toString(edge));
            if(edge[0] == 1){
                boolean canUnite = aliceDSU.union(edge[1], edge[2]);
                if(!canUnite){
                    ans++;
                }
            } else if(edge[0] == 2){
                boolean canUnite = bobDSU.union(edge[1], edge[2]);
                if(!canUnite){
                    ans++;
                }
            } else{
                boolean canUnite1 = aliceDSU.union(edge[1], edge[2]);
                boolean canUnite2 = bobDSU.union(edge[1], edge[2]);
                if(!canUnite1 && !canUnite2) ans++;
            }
        }

        return (aliceDSU.isAllConnected(n+1) && bobDSU.isAllConnected(n+1)) ? ans : -1;
    }
}

// Handling the case of -1 without using isAllConnected() method
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

}
class Solution2 {
    public int maxNumEdgesToRemove(int n, int[][] edges) {
        DSU aliceDSU = new DSU(n+1);
        DSU bobDSU = new DSU(n+1);
        int aliceNodeCount = 0; // keep track of number of nodes connected so that -1 case can be handled
        int bobNodeCount = 0;

        int ans = 0;
        Arrays.sort(edges, (x, y) -> (y[0]-x[0]));
        for(int[] edge: edges){
            if(edge[0] == 1){
                boolean canUnite = aliceDSU.union(edge[1], edge[2]);
                if(!canUnite){
                    ans++;
                } else{
                    aliceNodeCount++;
                }
            } else if(edge[0] == 2){
                boolean canUnite = bobDSU.union(edge[1], edge[2]);
                if(!canUnite){
                    ans++;
                } else{
                    bobNodeCount++;
                }
            } else{
                boolean canUnite1 = aliceDSU.union(edge[1], edge[2]);
                boolean canUnite2 = bobDSU.union(edge[1], edge[2]);
                if(!canUnite1 && !canUnite2) ans++;
                else if(canUnite1){
                    if(canUnite2) bobNodeCount++;
                    aliceNodeCount++;
                }
            }
        }
        System.out.println(aliceNodeCount +" " + bobNodeCount);
        return (aliceNodeCount == n-1 && bobNodeCount == n-1) ? ans : -1;
    }
}

public class remove_max_number_of_edges_to_keep_graph_full_traversable {
    
}
