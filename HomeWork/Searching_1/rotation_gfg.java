package HomeWork.Searching_1;

// T.C -> O(LogN)
// Find the index of the minimum element in the array. That will be the answer
class Solution {
    int findKRotation(int arr[], int n) {
        int l = 0;
        int h = n - 1;
        int mini = Integer.MAX_VALUE;
        int ans = 0;
        while(l<=h){
            int m = l + (h-l)/2;
            
            if(arr[m] >= arr[l]){ // If left subpart is sorted
                if(mini > arr[l]){ // element at low will be lowest in left subpart, compare with min
                    mini = arr[l];
                    ans = l;
                }
                
                l = m + 1; // move to right to find other best answer
            } else{
                if(mini > arr[m]){ // element at mid will be lowest in right subpart if right subpart is sorted
                    mini = arr[m];
                    ans = m;
                }
                h = m - 1; // move to left to find other best answer
            }
        }
        return ans;
    }
}

//Ignore below
public class rotation_gfg {
    
}
