import java.util.*;


// Method 3: Do we really need to maintain two suffix arrays in method 2? No, we don't need it. We can simply check from the 
// the last index whether the said condition of method 2 is being satisfied or not.

// T.C: O(N), S.C: O(1) <- Ignoring the space for input

class Solution3{
    public boolean eachNodeWithOneChild(int[] preOrder){
        int n = preOrder.length;

        int maxi = preOrder[n-1];
        int mini = preOrder[n-1];

        for(int i=n-2; i>=0; i--){
            if(preOrder[i] < maxi && preOrder[i] > mini){
                return false;
            }

            maxi = Math.max(preOrder[i], maxi);
            mini = Math.min(preOrder[i], mini);
        }

        return true;
    }
}

// Method 2: Maintian two suffix array, maxiSuffix and miniSuffix, maxiSuffix[i] -> maximum value from i to n-1, 
// miniSuffix[i] -> minimum value from i to n-1

// Now linearly traverse the preorder array the, value at ith index should either be freater than both maxiSuffix[i+1] and miniSuffix[i+1]
// or it should be smaller than both else the output is false.

// This method is optimized version of method 1
// T.C: O(N) + O(N), S.C: O(N) + O(N)


class Solution2{
    public boolean eachNodeWithOneChild(int[] preOrder){
        int n = preOrder.length;
        int[] maxiSuffix = new int[n];
        int[] miniSuffix = new int[n];

        int maxi = preOrder[n-1];
        int mini = preOrder[n-1];
        maxiSuffix[n-1] = maxi;
        miniSuffix[n-1] = mini;

        for(int i=n-2; i>=0; i--){
            maxi = Math.max(preOrder[i], maxi);
            mini = Math.min(preOrder[i], mini);
            maxiSuffix[i] = maxi;
            miniSuffix[i] = mini;
        }

        for(int i=0; i<n-1; i++){
            if(preOrder[i] < maxiSuffix[i+1] && preOrder[i] > miniSuffix[i+1]){
                return false;
            }
        }

        return true;
    }
}

// Method 1: Brute Force: [20, 10, 11, 13, 12], for the answer to be true we can observe that all the nodes after 20
// are smaller than 20, all the nodes after 10 are greater than 10, so for returning true, all the elements after current
// element can either be all greater or all smaller, it can't be both.

// T.C: O(N*N), N -> Number of Nodes or Length of preOrder array.
class Solution{
    public boolean eachNodeWithOneChild(int[] preOrder){
        for(int i=0; i<preOrder.length; i++){
            boolean greaterSeries = false;
            boolean smallerSeries = false;
            for(int j=i+1; j<preOrder.length; j++){
                if(!greaterSeries && !smallerSeries){
                    if(preOrder[i] < preOrder[j]){
                        greaterSeries = true;
                    } else{
                        smallerSeries = true;
                    }
                } else if(greaterSeries && preOrder[j] < preOrder[i]){
                    return false;
                } else if(smallerSeries && preOrder[j] > preOrder[i]){
                    return false;
                }
            }
        }
        return true;
    }
}

public class check_if_each_node_of_bst_has_exactly_on_child {
    public static void main(String[] args) {
        Solution3 solutionObj = new Solution3();
        int[] preOrder = new int[]{10, 15, 4, 12, 13, 5, 7, 6};
        System.out.println(solutionObj.eachNodeWithOneChild(preOrder));
    }
}
