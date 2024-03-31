package HomeWork.Tree_4_and_5;

// Same logic as largest_bst, maintain one extra variable maxAchivable for every sub tree which will tell that for a sub tree
// what is the max Sum which is possble to achieve.

// T.C: O(N), S.C: O(H)
class subTreeInfo{
    boolean isBST;
    int maxi;
    int mini;
    int sum;
    int maxAchivable;
    
    public subTreeInfo(boolean isBST, int maxi, int mini, int sum, int maxAchivable){
        this.isBST = isBST;
        this.maxi = maxi;
        this.mini = mini;
        this.sum = sum;
        this.maxAchivable = maxAchivable;
    }
}

class Solution {
    public subTreeInfo helper(TreeNode root){
        if(root == null){
            return new subTreeInfo(true, Integer.MIN_VALUE, Integer.MAX_VALUE, 0, 0);
        }

        subTreeInfo left = helper(root.left);
        subTreeInfo right = helper(root.right);

        boolean isBST = (left.isBST && right.isBST && root.val > left.maxi && root.val < right.mini);
        int sum = isBST ? (left.sum + right.sum + root.val) : Math.max(right.sum, left.sum);
        int maxi = Math.max(right.maxi, root.val);
        int mini = Math.min(left.mini, root.val);
        int maxAchivable = Math.max(left.maxAchivable, Math.max(right.maxAchivable, sum));
        return new subTreeInfo(isBST, maxi, mini, sum, maxAchivable);
    }
    public int maxSumBST(TreeNode root) {
        return helper(root).maxAchivable;
    }
}
public class maximum_sum_bst {
    
}
