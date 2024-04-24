package HomeWork.Graph_5;
import java.util.*;

class Trio{
    int i, j, effort;
    public Trio(int i, int j, int effort){
        this.i = i;
        this.j = j;
        this.effort = effort;
    }
}
class Solution {
    public int minimumEffortPath(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;
        PriorityQueue<Trio> pq = new PriorityQueue<>((x, y) -> Integer.compare(x.effort, y.effort));
        boolean[][] vis = new boolean[n][m];

        int[][] efforts = new int[n][m];

        for(int[] i: efforts){
            Arrays.fill(i, Integer.MAX_VALUE);
        }

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        pq.add(new Trio(0, 0, 0));
        efforts[0][0] = 0;
        while(!pq.isEmpty()){
            Trio curr = pq.poll();
            int curri = curr.i;
            int currj = curr.j;
            int curr_eff = curr.effort;

            if(vis[curri][currj]){
                continue;
            }

            vis[curri][currj] = true;

            for(int i=0; i<4; i++){
                int ni = curri + dx[i];
                int nj = currj + dy[i];

                if(ni < 0 || nj < 0 || ni>=n || nj >=m || vis[ni][nj]){
                    continue;
                }

                if(efforts[ni][nj] > Math.max(curr.effort, Math.abs(heights[curri][currj]-heights[ni][nj]))){
                    efforts[ni][nj] = Math.max(curr.effort, Math.abs(heights[curri][currj]-heights[ni][nj]));
                    pq.add(new Trio(ni, nj, efforts[ni][nj]));
                }
            }
        }   

        return efforts[n-1][m-1];
    }
}
public class path_with_minimum_effort {
    
}
