import java.util.*;;
class Trio{
    int c;
    int d;
    int dis;
    public Trio(int c, int d, int dis){
        this.c = c;
        this.d = d;
        this.dis = dis;
    }
}

// T.C: O(A*B)
// S.C: O(2*A*B)
class Solution {
    
    public int knight(int A, int B, int C, int D, int E, int F) {        
        int[] dx = {-2, -2, 2, 2, -1, 1, -1, 1};
        int[] dy = {-1, 1, -1, 1, 2, 2, -2, -2};
        Queue<Trio> q = new LinkedList<>();
        
        if(C==E && D==F){
            return 0;
        }
        q.add(new Trio(C, D, 0));
        boolean[][] vis = new boolean[A+1][B+1];
        vis[C][D] = true;
        while(!q.isEmpty()){
            Trio curr = q.poll();
            int currc = curr.c;
            int currd = curr.d;
            int currDis = curr.dis;
            
            for(int i=0; i<8; i++){
                int newc = currc + dx[i];
                int newd = currd + dy[i];
                
                if(newc == E && newd == F){
                    return currDis + 1;
                }
                
                if(newc >= 1 && newd >= 1 && newc <= A && newd <= B && !vis[newc][newd]){
                    vis[newc][newd] = true;
                    q.add(new Trio(newc, newd, currDis+1));
                }
            }
        }
        // int ans = helper(A, B, C, D, E, F, vis, 0);
        return -1;
    }

    // DFS giving TLE
    // public int helper(int a, int b, int c, int d, int e, int f, int[][] vis, int step){
    //     if(c==e && d==f){
    //         return 0;
    //     }
        
    //     int mini = (int)1e9;
    //     vis[c][d] = step;
        
    //     int[] dx = {-2, -2, 2, 2, -1, 1, -1, 1};
    //     int[] dy = {-1, 1, -1, 1, 2, 2, -2, -2};
        
    //     for(int i=0; i<8; i++){
    //         int newc = c + dx[i];
    //         int newd = d + dy[i];
            
    //         if(newc < 1 || newd < 1 || newc >= a || newd >= b || (vis[newc][newd] != -1 && vis[newc][newd] < step+1) ){
    //             continue;
    //         }
            
    //         mini = Math.min(mini, 1+helper(a, b, newc, newd, e, f, vis, step+1));
    //     }
        
    //     return mini;
    // }
}

public class knight_on_chess_board {
    
}
