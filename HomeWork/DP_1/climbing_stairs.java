package HomeWork.DP_1;

class Solution {
    public int climbStairs(int n) {
        // 3 -> 2 1
        // 2 -> 1 0

        if(n == 1){ return 1;}
        if(n == 2){ return 2;}

        int waysToPreviousStep = 2;
        int waysToBeforePreviousStep = 1;

        for(int i=3; i<=n; i++){
            int currSteps = waysToPreviousStep + waysToBeforePreviousStep;
            waysToBeforePreviousStep = waysToPreviousStep;
            waysToPreviousStep = currSteps;
        }

        return waysToPreviousStep; // in the end of the loop this will store the value of nth step
    }
}

public class climbing_stairs {
    
}
