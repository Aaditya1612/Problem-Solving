package HomeWork.Searching_5;


// Same as find median in 2D matrix, refer matrix_median.java
class Solution
{
    public static int countElementsLessThan(int[][] A, int val){
        int cnt = 0;
        
        for(int[] row: A){
            int low = 0;
            int high = row.length-1;
            while(low<=high){
                int mid = low + (high-low)/2;
                if(row[mid]>=val){
                    high = mid-1;
                } else{
                    low = mid+1;
                }
            }
            cnt+=low;
        }
        
        return cnt;
    }
	public static int kthSmallest(int[][]mat,int n,int k)
	{
        int maxi = Integer.MIN_VALUE;
        int mini = Integer.MAX_VALUE;
        for(int[] row: mat){
            maxi = Math.max(maxi, row[n-1]);
            mini = Math.min(mini, row[0]);
        }
        
        int low = mini;
        int high = maxi;
        int ans = low;
        while(low<=high){
            int mid = low + (high-low)/2;
            if(countElementsLessThan(mat, mid) <= k-1){
                ans = mid;
                low = mid+1;
            } else{
                high = mid-1;
            }
        }
        
        return ans;
    }
}

public class kthm_element_in_matrix_gfg {
    
}
