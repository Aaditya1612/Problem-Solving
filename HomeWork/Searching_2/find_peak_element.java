package HomeWork.Searching_2;
class Solution {
    public int findPeakElement(int[] nums) {
        int n = nums.length;

        // Handling edge cases
        if(n == 1){ return 0;}
        if(nums[0] > nums[1]) { return 0;}
        if(nums[n-1] > nums[n-2]) {return n-1;}

        int l = 1; // case for 0 has already been handled
        int h = n-2; // case for n-1 has already been handled

        while(l<=h){
            int m = l+(h-l)/2;

            if(nums[m]>nums[m+1] && nums[m]>nums[m-1]){ // check for peak element
                return m;
            }

            else if(nums[m]<nums[m+1]){ // If ascending line in right side then guranteed answer in right side
                l=m+1;
            }
            else{ // else in left side
                h=m-1;
            }
            
        }

        return -1;
    }
}

// Ignore below
public class find_peak_element {
    
}
