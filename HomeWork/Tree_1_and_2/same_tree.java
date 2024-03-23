package HomeWork.Tree_1_and_2;

// Time complexity: O(N)
class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null || q == null){
            if(p!=null || q!=null){
                return false;
            }
            return true;
        }

        if(p.val != q.val){
            return false;
        }

        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}

public class same_tree {
    
}
