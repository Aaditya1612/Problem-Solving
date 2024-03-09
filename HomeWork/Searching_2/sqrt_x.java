package HomeWork.Searching_2;

class Solution {
    public int mySqrt(int x) {
        if(x == 0){ return 0;}

        int low = 1;
        int high = Math.min(x, (int)10e9);
        long ans = 1;
        while(low <= high){
            long mid = low + (high - low)/2; // long to fit the multiplication

            if(mid*mid <= x){ // best answer can still be found in right subpart
                ans = mid;
                low = (int) mid + 1;
            } else{
                high = (int) mid - 1;
            }
        }
        return (int)ans;
    }
}

//Ignore below
public class sqrt_x {
    
}
