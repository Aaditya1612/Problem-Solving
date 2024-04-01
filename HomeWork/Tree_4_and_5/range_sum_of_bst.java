package HomeWork.Tree_4_and_5;

// T.C: O(N), S.C: O(H)
class Solution {
    public int rangeSumBST(TreeNode root, int low, int high) {
        if(root == null){
            return 0;
        }

        int a = rangeSumBST(root.left, low, high);
        int b = rangeSumBST(root.right, low, high);
        if(root.val<=high && root.val>=low){
            return root.val+a+b;
        }
        return a+b;
    }
}
public class range_sum_of_bst {
    
}
