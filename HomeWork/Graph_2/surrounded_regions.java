package HomeWork.Graph_2;


// Traverse the boundary elements first. If the is any 'O' present at the boundary then apply dfs for it and mark all 
// the 'O' connected to this 'O' with any third symbol let's say '$'.
// In the end the task get reduced to converting '$' back to 'O' as these cannot be converted to 'X' (Why?) and remaining 'O' to 'X'.


// T.C: O(M+N) + O(M*N)
// S.C: O(M*N)

class Solution {
    public void unmark(char[][] board, int i, int j){
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};

        board[i][j] = '$';

        for(int d = 0; d<4; d++){
            int newi = i + dx[d];
            int newj = j + dy[d];

            if(newi < 0 || newj < 0 || newi >= board.length || newj >= board[0].length){
                continue;
            }

            if(board[newi][newj] == 'O'){
                unmark(board, newi, newj);
            }
        }

    }
    public void solve(char[][] board) {
        
        int n = board.length;
        int m = board[0].length;

        for(int i=0; i<n; i++){
            if(board[i][0] == 'O'){
                unmark(board, i, 0);
            }
            if(board[i][m-1] == 'O'){
                unmark(board, i, m-1);
            }
        }

        for(int j=0; j<m; j++){
            if(board[0][j] == 'O'){
                unmark(board, 0, j);
            }
            if(board[n-1][j] == 'O'){
                unmark(board, n-1, j);
            }
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(board[i][j] == '$'){ board[i][j] = 'O';}
                else if(board[i][j] == 'O'){ board[i][j] = 'X';}
            }
        }
    }
}
public class surrounded_regions {
    
}
