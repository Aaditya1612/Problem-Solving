package HomeWork.Tree_3;

// The idea is simple, for every node we have two choices, either to include that node in the sum or to exclude it from the sum
// If we include current node then for all the nodes below the current node we will left with only once chance that is to include
// it in the final answer, we can't exclude it that is why I have used a check taken which signifies if any of the parent 
// has been taken or not if the parent has been taken then child only left with the option to take, not take option is not
// available.
// remember to pass targetSum in long data type because the constriants may cause overflow for targetSum = 0;

// T.C: O(N), S.C: O(H)
class Solution {
    private int ans = 0;
    public void findTotalPaths(TreeNode root, long targetSum, boolean taken){
        if(root == null){
            return;
        }
        if(root.val == targetSum){
            ans++; // may happen that child nodes contain 0 value so need to check below as well, can't stop here.
        }
        
        findTotalPaths(root.right, targetSum - root.val, true);
        findTotalPaths(root.left, targetSum - root.val, true);
        if(!taken){
            findTotalPaths(root.right, targetSum, false);
            findTotalPaths(root.left, targetSum, false);
        }

    }
    public int pathSum(TreeNode root, int targetSum) {
        if(root == null){
            return 0;
        }
        ans = 0;
        findTotalPaths(root, (long)targetSum, false);

        return ans;
    }
}


public class path_sum_3 {
    
}
