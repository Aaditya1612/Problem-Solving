package HomeWork.Searching_5;

import java.util.ArrayList;

// T.C: O(log(max(arr1[n-1], arr2[m-1])-min(arr1[0], arr2[0])))*O(lon(m+n))
class Solution {
    public static int findNumberOfElementsLessThan(ArrayList<Integer> arr, int val){
        int low = 0;
        int high = arr.size()-1;
        while(low<=high){
            int mid = low + (high-low)/2;
            if(arr.get(mid)>=val){
                high = mid - 1;
            } else{
                low = mid + 1;
            }
        }

        return low;
    }
    public static int kthElement(ArrayList<Integer> arr1, ArrayList<Integer> arr2, int n, int m, int k) {
        int low, high;
        if(n == 0){
            low = arr2.get(0);
            high = arr2.get(m-1);
        } else if(m == 0){
            low = arr1.get(0);
            high = arr1.get(n-1);
        }else{
            low = Math.min(arr1.get(0), arr2.get(0));
            high = Math.max(arr1.get(n-1), arr2.get(m-1));
        }
       
        int ans = 0;
        while(low<=high){
            int mid = low + (high-low)/2;
            int cnt1 = findNumberOfElementsLessThan(arr1, mid);
            int cnt2 = findNumberOfElementsLessThan(arr2, mid);
            if(cnt1+cnt2 <= k-1){
                ans = mid;
                low = mid + 1;
            } else{
                high = mid - 1;
            }
        }
        return ans;
    }
}
public class kth_element_of_two_sorted_array {
    
}
