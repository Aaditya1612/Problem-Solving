package HomeWork.Graph_2;
import java.util.*;

// 1 -> 1 3 5
// 2 -> 2 5 6
// 3 -> 5 2 6
// 4 -> 


// For each path create a map to possible moves. then apply the move on the current cell in accordance with the path present in it.
// When you move to a new cell then if prev cell and the new cell together form a valid path then appying the set of moves on the new
// cell in accrodance with the path present in it should lead to the previous path. If not then the current cell does not have a valid path for continution

// T.C: O(N*M)
// S.C: O(N*M) + O(N*M)
class Solution {
    
    public boolean isPossible(int[][] grid, int i, int j, boolean[][] vis, HashMap<Integer, int[][]> mapToMoves){
        int n = grid.length;
        int m = grid[0].length;

        if(i == n-1 && j == m-1){
            return true;
        }

        vis[i][j] = true;

        for(int[] move: mapToMoves.get(grid[i][j])){
            int newi = i + move[0];
            int newj = j + move[1];
            if(newi < 0 || newj < 0 || newi >= n || newj >= m) continue;
            for(int[] backMove: mapToMoves.get(grid[newi][newj])){
                int backi = newi + backMove[0];
                int backj = newj + backMove[1];

                if(backi != i || backj != j){
                    continue;
                }

                if(!vis[newi][newj]){
                    if(isPossible(grid, newi, newj, vis, mapToMoves)) return true;
                }
            }
        }

        return false;
    }
    public boolean hasValidPath(int[][] grid) {
        boolean[][] vis = new boolean[grid.length][grid[0].length];
        HashMap<Integer, int[][]> mapToMoves = new HashMap<>();
        mapToMoves.put(1, new int[][]{{0, -1}, {0, 1}});
        mapToMoves.put(2, new int[][]{{-1, 0}, {1, 0}});
        mapToMoves.put(3, new int[][]{{0, -1}, {1, 0}});
        mapToMoves.put(4, new int[][]{{0, 1}, {1, 0}});
        mapToMoves.put(5, new int[][]{{0, -1}, {-1, 0}});
        mapToMoves.put(6, new int[][]{{0, 1}, {-1, 0}});
        return isPossible(grid, 0, 0, vis, mapToMoves);
    }
}
public class check_if_there_is_a_valid_path_in_a_grid {
    
}
