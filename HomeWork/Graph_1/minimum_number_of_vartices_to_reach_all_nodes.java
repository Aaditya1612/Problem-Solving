package HomeWork.Graph_1;
import java.util.*;


// Find all those nodes which have zero incoming edges as it is quite obsvious that the nodes which do not have any incoming edge will 
// not be reachible via any other node and they will have to be added into result


// T.C: O(N)
// S.C: O(2*N)
class Solution {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        boolean[] hasIncomingEdge = new boolean[n];
        List<Integer> res = new ArrayList<>();
        for(List<Integer> edge: edges){
            hasIncomingEdge[edge.get(1)] = true;
        }

        for(int i=0; i<n; i++){
            if(!hasIncomingEdge[i]){
                res.add(i);
            }
        }

        return res;
    }
}
public class minimum_number_of_vartices_to_reach_all_nodes {
    
}
