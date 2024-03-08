package HomeWork.Searching_1;

// T.C -> O(LogN)
class Solution {
    public int search(int[] nums, int target) {
        int l = 0;
        int h = nums.length-1;

        while(l<=h){
            int m = l + (h-l)/2;
            if(nums[m] == target){
                return m;
            }
            else if(nums[0]<=nums[m]){  // mid in left part
                if(target>=nums[0] && target < nums[m]){ // target also in left part
                    h = m - 1;
                } else{ // else move to right part
                    l = m + 1;
                }
            } else{ // mid in right part
                if(target>nums[m] && target<=nums[h]){ // target also in right part
                    l = m + 1;
                } else{ // else move to left part
                    h = m - 1;
                }
            }
        }

        return -1;
    }
}

//Ignore below
public class search_in_rotated_sorted_array {
    
}
