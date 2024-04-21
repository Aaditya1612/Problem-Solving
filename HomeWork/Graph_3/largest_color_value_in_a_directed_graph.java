package HomeWork.Graph_3;
import java.util.*;


// Apply BFS on current node, and for each neigbour node copy the current color counts. Color count is basically an arrya which stores the 
// count of each 26 colors appeared till curr node.
// To detect cycle use indegree concept


// T.C: o(n) + O(E) + O(N + 26*V)
// S.C: O(N) + O(26*N) + O(N)
class Solution {
    public int largestPathValue(String colors, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        int n = colors.length();
        int[] indegree = new int[n];
        for(int i=0; i<n; i++){
            adj.add(new ArrayList<>());
        }
        for(int[] edge: edges){
            adj.get(edge[0]).add(edge[1]);
            indegree[edge[1]]++;
        }

        Queue<Integer> q = new LinkedList<>();

        for(int i=0; i<n; i++){
            if(indegree[i] == 0){
                q.add(i);
            }
        }
        int[][] colorCount = new int[n][26]; // To store count of colours on each n nodes
        int ans = 0;
        while(!q.isEmpty()){
            int curr = q.poll();
            colorCount[curr][colors.charAt(curr)-'a']++;  // update in the count array, the colour of current node
            System.out.println(curr);
            for(int neigh: adj.get(curr)){
                indegree[neigh]--;
                for(int i=0; i<26; i++){
                    colorCount[neigh][i] = Math.max(colorCount[neigh][i], colorCount[curr][i]);  // make a copy of all the counts to the neighbour nodes, but if the neighbour nodes already have some values then maximum should have been taken (think of condition when two paths are merging at current neighbour)
                }
                if(indegree[neigh] == 0){
                    q.add(neigh);
                }
            }

            for(int i: colorCount[curr]){
                ans = Math.max(ans, i);
            }
        }
        // System.out.println(Arrays.toString(colorCount[8]));
        for(int i: indegree){
            if(i!=0) return -1; // If indegree is not 0 then output -1 (As per question)
        }

        return ans;

    }
}

public class largest_color_value_in_a_directed_graph {
    
}
