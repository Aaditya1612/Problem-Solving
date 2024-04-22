package HomeWork.Graph_4;
import java.util.*;


// For graph to be bipartite we need to check if it is possible to color the graph with atmost 2 colours.
// This is kind of similar to the problem where we find if it is possible to colour the graph with m colors. But the algrithm used for
// m color graph coloring takes O(m^v) and here in our case m = 2 and v can be 100 in worst case so clearly this algorithm won't work
// So what we can do is we can keep on assigning the alternate colour of 0 and 1 to the neighbours of the current node and the
// if we arrive at at neigbour which is already coloured previously but have the same colour as the current node then that graph can never be
// colored with 2 colors

// T.C: O(V*V)
// S.C: O(V) + O(V)
class Solution {
    public boolean dfs(int[][] graph, int[] color, int i, int currColor){   
        color[i] = currColor;
        for(int j: graph[i]){
            if(color[j]==-1){
                // keep on assigning alterante colors to then next nodes
                if(dfs(graph, color, j, 1-currColor)==false) return false;
            }
            else if(color[j]==currColor){ // if color to the next neighbor node has aleready been assigned and it is same as colour of current node then it is impossible to colour the graph with 2 colors
                return false;
            }
        }

        return true;
    }
    public boolean isBipartite(int[][] graph) {
        int[] color = new int[graph.length];
        Arrays.fill(color, -1);
        // To handle the unconnected componenets check if the all the vertices have been colored or not
        for(int i=0; i<graph.length; i++){
            if(color[i]==-1) 
                if(dfs(graph, color, i, 0)==false) return false;
        }
        
        return true;

    }
}
public class is_graph_bipartite {
    
}
