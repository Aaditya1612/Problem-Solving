package HomeWork.Searching_5;


// T.C O(log(m*n))
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;
        int low = 0;
        int high = n*m-1;

        while(low<=high){
            int mid = low + (high-low)/2;
            int r = mid/m;
            int c = mid%m; // Was tricky to be identify :)
            System.out.println(matrix[r][c]);
            if(matrix[r][c] == target){
                return true;
            } else if(matrix[r][c] < target){
                low = mid + 1;
            } else{
                high = mid - 1;
            }
        }

        return false;
    }
}

public class search_in_2d_matrix {
    
}
