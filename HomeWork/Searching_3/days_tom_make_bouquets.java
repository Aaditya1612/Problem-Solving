package HomeWork.Searching_3;


// T.C -> O(log(max(bloomDay)))*O(N) here N -> number of flowers
class Solution {
    // function to check if it is possible to make m bouquets using k consecutive flowers at mid days.
    public boolean possible(int[] bloomDay, int m, int k, int mid){
        int bouquet_counts = 0;
        int conti = 0;

        for(int i=0; i<bloomDay.length; i++){
            if(bloomDay[i] <= mid){
                conti++;
            } else{
                conti = 0;
            }

            if(conti == k){
                bouquet_counts++;
                conti = 0;
            }
        }

        return bouquet_counts>=m;
    }
    public int minDays(int[] bloomDay, int m, int k) {
        int maxi = Integer.MIN_VALUE;

        for(int i: bloomDay){
            maxi = Math.max(i, maxi);
        }
        int low = 1; // The search space will be in the range [1, max(blommDay)]
        int high = maxi;
        int ans = -1;
        while(low<=high){
            int mid = low + (high-low)/2;
            if(possible(bloomDay, m, k, mid)){ // If it is possible to make m bouquets at mid days using k consicutive flowers
                ans = mid;
                high = mid - 1; // still a best answer can be found in lesser number of days so search in left subpart
            } else{ // try with a higher number of days (mid) so move in right subpart
                low = mid + 1;
            }
        }
        return ans;
    }
}

public class days_tom_make_bouquets {
    
}
