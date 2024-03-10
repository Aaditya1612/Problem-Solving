package HomeWork.Searching_3;
class Solution {
    // function to check if it is possible to distribute balls using maxOp such that upper bound of number of balls for each bag is mid
    public boolean isPossibleToDistribute(int[] nums, int maxOp, int mid){
        int op = 0;

        for(int balls: nums){
            if(balls > mid){
                if(balls%mid == 0) { op+=(balls/mid - 1);} // for example if we have balls = 8 and mid = 2 then operations needed will be 3 which is 8/2-1
                else { op+=(balls/mid);} // for example if we have balls = 9 and mid = 2 then operations needed will be 4 which is 9/2
            }
        }

        return op<=maxOp;
    }
    public int minimumSize(int[] nums, int maxOperations) {

        int maxi = Integer.MIN_VALUE;
        for(int i: nums){ maxi = Math.max(maxi, i);}
        int low = 1;
        int high = maxi;
        int ans = maxi;
        while(low<=high){
            int mid = low + (high - low)/2;
            if(isPossibleToDistribute(nums, maxOperations, mid)){ // if it is possible to distribute then this mid could be a possible answer
                high = mid - 1; // better answer can be found in left part as we need to minimize the answer
                ans = mid;
            } else{ // else answer is in right part
                low = mid + 1;
            }
        }

        return ans;
    }
}
public class minimum_limits_of_balls_in_bags {
    
}
