package HomeWork.Graph_2;


// check distance between newx and newy and every center it should not be within the given radius r.
// also to be within the rectangle the newx and newy should also not exceed target x and target y


class Solution {
    public boolean isTouchingCircle(int x, int y, int n, int r, int[] a, int[] b){
        
        for(int i=0; i<n; i++){
            int disx = Math.abs(x - a[i]);
            int disy = Math.abs(y - b[i]);
            
            double calcDis = Math.sqrt(disx*disx + disy*disy);
            
            if(calcDis <= (double) r){
                return true;
            }
        }
        
        return false;
    }
    public boolean isPossible(int x, int y, int tarx, int tary, int n, int r, int[] a, int[] b, boolean[][] vis){
        
        if(x == tarx && y == tary){
            return true;
        }
        if(vis[x][y]){
            return false;
        }
        
        vis[x][y] = true;
        
        int[] dx = {1, 1, 0, -1, -1, -1, 0, 1};
        int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};
        
        for(int d=0; d<8; d++){
            int newx = x + dx[d];
            int newy = y + dy[d];
            
            if(newx < 0 || newy < 0 || newx > tarx || newy > tary || vis[newx][newy]
                        || isTouchingCircle(newx, newy, n, r, a, b)){
                continue;
            }
            
            if(isPossible(newx, newy, tarx, tary, n, r, a, b, vis)){
                return true;
            }
        }
        
        return false;
    }
    public String solve(int x, int y, int n, int r, int[] a, int[] b) {
        boolean[][] vis = new boolean[101][101];
        if(isTouchingCircle(0, 0, n, r, a, b)){
            return "NO";
        }
        if(isTouchingCircle(x, y, n, r, a, b)){
            return "NO";
        }
        return isPossible(0, 0, x, y, n, r, a, b, vis) ? "YES" : "NO";
    }
}

public class valid_path_interviewbit {
    
}
