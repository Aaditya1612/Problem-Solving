package HomeWork.Searching_1;

class Solution {
    public boolean search(int[] nums, int target) {
        int l = 0;
        int h = nums.length - 1;

        while(l<=h){
            int m = l + (h-l)/2;
            if(nums[m] == target){
                return true;
            } else if(nums[m] >= nums[l]){ // if left part is sorted and mid in left
                if(nums[m] == nums[l]){ // If element at low is equal to element at mid then there can be two possiblities, either the whole left part is filled with the same element or there are some other elements as well. So we'll have to skip those elements which are equal and the problem will reduce to type - I variant of this question.
                    l++;
                }
                else if((nums[m] > target && nums[l] <= target)){
                    h = m - 1;
                } else{
                    l = m + 1;
                }
            } else{
                if((nums[m] < target && nums[h] >= target)){
                    l = m + 1;
                } else{
                    h = m - 1;
                }
            }
        }

        return false;
    }
}

//Ignore below
public class search_in_rsa_2 {
    
}
