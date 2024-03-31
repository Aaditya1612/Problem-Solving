package HomeWork.Tree_4_and_5;


 class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode() {}
     TreeNode(int val) { this.val = val; }
     TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
         this.left = left;
         this.right = right;
     }
 }

 // Method 1: T.C: O(N), S.C O(H)
class Solution {
    public boolean check(TreeNode root, long min, long max){
        if(root == null){
            return true;
        }
        if(root.val <= min || root.val >= max){
            return false;
        }

        return check(root.left, min, root.val) && check(root.right, root.val, max);
    }
    public boolean isValidBST(TreeNode root) {
        return check(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
}

// Method 2, same T.C
class Solution2 {
    TreeNode prev = null;
    public boolean check(TreeNode root){
        if(root == null){
            return true;
        }
        if(check(root.left) == false){
            return false;
        }
        if(prev!=null && root.val <= prev.val){
            return false;
        }

        prev =root;

        return check(root.right);
    }
    public boolean isValidBST(TreeNode root) {
        return check(root);
    }
}
public class validate_bst {
    
}
