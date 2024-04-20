package HomeWork.Graph_3;
import java.util.*;


// T.C: O(2*n) + O(E) + 
class Solution {
    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        List<List<Integer>> ans = new ArrayList<>();
        List<List<Integer>> adj = new ArrayList<>();
        List<TreeSet<Integer>> ancs = new ArrayList<>(); // Used TreeSet because list of ancestors needed to be in sorted orded and set so that unique ancestors are recorded only
        int[] indegree = new int[n];
        for(int i=0; i<n; i++){
            ancs.add(new TreeSet<Integer>());
            adj.add(new ArrayList<>());
        }

        for(int i=0; i<edges.length; i++){
            adj.get(edges[i][0]).add(edges[i][1]);
            indegree[edges[i][1]]++;
        }

        Queue<Integer> q = new LinkedList<>();

        for(int i=0; i<n; i++){
            if(indegree[i] == 0){
                q.add(i);
            }
        }

        while(!q.isEmpty()){
            int curr = q.poll();

            for(int neigh: adj.get(curr)){
                for(int anc: ancs.get(curr)){  // all the ancestors of the curr node will also be part of neighbours of the curr node
                    ancs.get(neigh).add(anc);
                }
                ancs.get(neigh).add(curr); // curr node will itself be an ancestor of all it's negihbours.

                indegree[neigh]--;

                if(indegree[neigh] == 0){ // no more ancestors of the neigh is possible so add it to the queue so that it can now be considered as ancestor for other nodes which are it's child
                    q.add(neigh);
                }
            }
        }

        for(TreeSet<Integer> set : ancs){
            ans.add(new ArrayList<>(set));
        }

        return ans;
    }
}

public class all_ancestor_of_a_node_in_a_dag {
    
}
