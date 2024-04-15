package HomeWork.Graph_1;
import java.util.*;


// Firs find out the node which is farthest from the root node (using dfs) then call another dfs which will compute the maximum distance
// between the farthest node and any other node. It is important to note that the maximum distance between two nodes will always 
// have a path going through root node.

class Solution {
    // for below function 0th index will hold the farthest node found till each call and 1st index will hold the value of maximum depth of that node
    public int[] findFarthestNode(List<List<Integer>> adj, int root, boolean[] vis){
        if(vis[root]){
            return new int[]{root, 1};
        }
        vis[root] = true;
        int maxi = 0;
        int farthestNode = root;
        for(int i: adj.get(root)){
            if(!vis[i]){
                int[] val = findFarthestNode(adj, i, vis);
                if(1 + val[1] > maxi){
                    maxi = 1 + val[1];
                    farthestNode = val[0];
                }
            }
                
        }
        
        return new int[]{farthestNode, maxi};
    }
    
    // this function will take the farthest node, will apply dfs from and and then find the maxmimum distance node from the farthest node.
    public int maxDis(List<List<Integer>> adj, int root, boolean[] vis){
        if(vis[root]){
            return 1;
        }
        vis[root] = true;
        int maxi = 0;
        
        for(int i: adj.get(root)){
            if(!vis[i]){
                int val = maxDis(adj, i, vis);
                if(1 + val > maxi){
                    maxi = 1 + val;
                }
            }
                
        }
        
        return maxi;
    }
    public int solve(int[] A) {
        List<List<Integer>> adj = new ArrayList<>();
        int n = A.length;
        for(int i=0; i<A.length; i++){
            adj.add(new ArrayList<>());
        }
        int start = 0;
        for(int i=0; i<n; i++){
            if(A[i] == -1){
                start = i;
                continue;
            }
            adj.get(A[i]).add(i);
            adj.get(i).add(A[i]);
        }
        
        boolean[] vis = new boolean[A.length];
        
        int farthestNode = findFarthestNode(adj, start, vis)[0];
        
        vis = new boolean[A.length];
        int res = maxDis(adj, farthestNode, vis);
        
        return res;
        
    }
}
