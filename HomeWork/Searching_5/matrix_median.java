package HomeWork.Searching_5;

// Approach is similar to finding the median in 2 sorted array.
// Here also if we make a 1D array from given matrix then we will get a sorted array and for this sorted array we need
// to find the (n+m)/2th element, so what we can do is take a mid and find the number of elements lesser than mid in each 
// row using binary search and if total count is equal to (n+m)/2 then mid is the median.
// This approach is also valid for finding kth element.

// // T.C -> O(n) + O(log(max(A)-min(A)))*O(n)*O(log(m)) ,  n-> number of rows, m -> number of cols
class Solution {
    public int countElementsLessThan(int[][] A, int val){
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
    public int findMedian(int[][] A) {
        int n = A.length;
        int m = A[0].length;
        int maxi = Integer.MIN_VALUE;
        int mini = Integer.MAX_VALUE;
        for(int[] row: A){
            maxi = Math.max(maxi, row[m-1]);
            mini = Math.min(mini, row[0]);
        }
        
        int low = mini;
        int high = maxi;
        int ans = low;
        while(low<=high){
            int mid = low + (high-low)/2;
            if(countElementsLessThan(A, mid) <= (n*m)/2){
                ans = mid;
                low = mid+1;
            } else{
                high = mid-1;
            }
        }
        
        return ans;
    }
}

public class matrix_median {
    
}
