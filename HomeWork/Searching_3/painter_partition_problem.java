package HomeWork.Searching_3;

import java.util.ArrayList;

// Similar to days to make m bouquets
class Solution 
{
    public static boolean isPossibleToPaint(ArrayList<Integer> boards, int k, int mid){
        int painterCount = 1;
        int totalTime = 0;

        for(int i = 0; i<boards.size(); i++){
            totalTime+=boards.get(i);
            if(boards.get(i) > mid) { return false;}
            if(totalTime>mid){
                totalTime = boards.get(i);
                painterCount++;
            }
        }

        return painterCount<=k;
    }
    public static int findLargestMinDistance(ArrayList<Integer> boards, int k)
    {
        int sum = 0;
        for(int i: boards) { sum+=i;}

        int low = 1;
        int high = sum;
        int ans = sum;
        while(low<=high){
            int mid = low + (high - low)/2;

            if(isPossibleToPaint(boards, k, mid)){
                high = mid - 1;
                ans = mid;
            } else{
                low = mid + 1;
            }
        }

        return ans;
    }
}

public class painter_partition_problem {
    
}
