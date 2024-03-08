package HomeWork.Searching_1;


// T.C -> O(LogN)

class Solution {
    public int findMin(int[] nums) {
        int ans = Integer.MAX_VALUE;

        int l = 0;
        int h = nums.length-1;

        while(l<=h){
            int m = l + (h-l)/2;
            ans = Math.min(ans, nums[m]);
            // if first element of left part is smaller than mid and greater than
            // end element then that means we are on the ascending hill so possible 
            // answer can be in right subpart
            if(nums[m] >= nums[0] && nums[0] >= nums[h]){
                l = m + 1;
            } else{ // else it will be in left subpart
                h = m - 1;
            }
        }

        return ans;
    }
}


// Ignore below
public class find_minimum_in_rotated_sorted_array {
    
}
