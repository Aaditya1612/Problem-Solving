package HomeWork.Searching_1;

// We will find the first occurance using the fact that if nums[mid] < target then 
// that means target will be in right part else it will be in left part
// Also, if mid itself is the target element then it could be a possible answer and 
// still we can find the best answer in the left subpart
// Similarly for right subpart

class Solution {
    public int first(int[] nums, int target){
        int n = nums.length;
        int l = 0;
        int h = n-1;
        int ans = -1;
        while(l<=h){
            int m = l + (h-l)/2;
            if(nums[m]==target){ // can be possible answer, still best can be found in left
                ans = m;
                h = m-1;
            }
            else if(nums[m]<target){ // possible answer can be found int right subpart
                l = m+1;
            }
            else{ // possible answer cab be found in left subpart
                h = m-1;
            }
        }

        return ans;
    }
    // find last occurance.
    public int last(int[] nums, int target){
        int n = nums.length;
        int l = 0;
        int h = n-1;
        int ans = -1;
        while(l<=h){
            int m =l +(h-l)/2;
            if(nums[m]==target){
                ans = m;
                l = m+1;
            }
            else if(nums[m]<target){
                l = m+1;
            }
            else{
                h = m-1;
            }
        }

        return ans;

    }
    public int[] searchRange(int[] nums, int target) {
        return new int[]{first(nums, target), last(nums, target)};
    }
}


// Ignore below
public class find_first_and_last_pos {
    
}
