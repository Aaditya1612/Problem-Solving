package HomeWork.Searching_5;


// Method: 1 -> T.C o(N+M), S.C O(N+M)
// Merge using two pointers approach then find the median of the merged sorted array.
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int[] merged = new int[n+m];

        int ptr1 = 0;
        int ptr2 = 0;
        int k = 0;
        while(ptr1<n && ptr2<m){
            if(nums1[ptr1] < nums2[ptr2]){
                merged[k++] = nums1[ptr1++];
            } else{
                merged[k++] = nums2[ptr2++];
            }
        }

        while(ptr1<n){
            merged[k++] = nums1[ptr1++];
        }

        while(ptr2<m){
            merged[k++] = nums2[ptr2++];
        }
        int len = merged.length;
        if(len%2!=0){
            return merged[len/2];
        } else{
            return ((double) merged[len/2-1]+(double) merged[len/2])/2.0;
        }
    }
}


// Method 2 -> T.C O(N+M), S.C o(1)
// Answer will be found when (ptr1+ptr2) == (n+m)/2;
class Solution2 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;

        int ptr1 = 0;
        int ptr2 = 0;
        int l = 0;
        int sl = 0;
        while((ptr1+ptr2) <= (n+m)/2){
            sl = l;
            if(ptr1<n && (ptr2>=m || nums1[ptr1]<nums2[ptr2])){
                l = nums1[ptr1++];
            } else if(ptr2<m){
                l = nums2[ptr2++];
            }
        }

        return (n+m)%2==0?(double)(l+sl)/2.0:l;
    }
}


// Method3, T.C O(log(max(nums1[n-1], nums2[m-1])-min(nums1[0], nums2[0])))*O(lon(m+n)), S.C. O(1)

class Solution3 {
    public int findNumberOfElementsLessThan(int[] nums, int val){
        int low = 0;
        int high = nums.length-1;
        while(low<=high){
            int mid = low + (high-low)/2;
            if(nums[mid]>=val){
                high = mid - 1;
            } else{
                low = mid + 1;
            }
        }

        return low;
    }
    public int countTotalElements(int[] nums1, int[] nums2, int mid){
        int cnt1 = findNumberOfElementsLessThan(nums1, mid);
        int cnt2 = findNumberOfElementsLessThan(nums2, mid);
        return (cnt1+cnt2);
        
    }

    // this function can be used to find elements at pos position 
    public int findElementAt(int[] nums1, int[] nums2, int pos){
        int n = nums1.length;
        int m = nums2.length;
        int low, high;
        // below if-else conditions are done to handle edge cases when one array is empty. :)
        if(n == 0){
            low = nums2[0];
            high = nums2[m-1];
        } else if(m == 0){
            low = nums1[0];
            high = nums1[n-1];
        }else{
            low = Math.min(nums1[0], nums2[0]);
            high = Math.max(nums1[n-1], nums2[m-1]);
        }
       
        int ans = 0;
        while(low<=high){
            int mid = low + (high-low)/2;

            if(countTotalElements(nums1, nums2, mid) <= pos){
                ans = mid;
                low = mid + 1;
            } else{
                high = mid - 1;
            }
        }
        return ans;
    }
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;

        if((n+m)%2 == 0){
            int mid1 = findElementAt(nums1, nums2, (n+m)/2); 
            int mid2 = findElementAt(nums1, nums2, (n+m)/2-1);
            System.out.println(mid1+" "+mid2);
            return (double)(mid1+mid2)/2.0;
        } else{
            return findElementAt(nums1, nums2, (n+m)/2);
        }
    }
}



public class median_of_two_sorted_arrays {
    
}
