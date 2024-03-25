package HomeWork.Tree_3;

// T.C: O(N), S.C: O(H)
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root.val == p.val || root.val == q.val){
            return root;
        }

        TreeNode leftContributor = lowestCommonAncestor(root.left, p, q);
        TreeNode rightContributor = lowestCommonAncestor(root.right, p, q);

        if(leftContributor!=null && rightContributor!=null){
            return root;
        }
        else if(leftContributor!=null){
            return leftContributor;
        } else{
            return rightContributor;
        }
    }
}
public class lowest_common_ancestor {
    
}
