package HomeWork.Searching_1.Searching_2;

class Solution {
    public int singleNonDuplicate(int[] nums) {
         // Handling edge cases of 0 and n-1
        if(nums.length == 1 || nums[0] != nums[1]){ return nums[0];}
        if(nums[nums.length-1] != nums[nums.length-2]){ return nums[nums.length-1];}
        int low = 1;
        int high = nums.length-2;

        while(low <= high){
            int mid = low + (high - low)/2;
            if(nums[mid] != nums[mid-1] && nums[mid] != nums[mid+1]){ // check if element is single element
                return nums[mid];
            }
            if(nums[mid] == nums[mid-1]) { // If first mid not at first occurance then do mid--
                mid--;
            }
            if(mid%2==0){ // If first occurance at even index then the answer is in right subpart
                low = mid + 2; // We need to do +2 because mid is at first occurance and doing +1 will put it at same number
            } else{
                high = mid;
            }
        }

        return -1;
    }
}
public class single_element_in_a_sorted_array {
    
}
