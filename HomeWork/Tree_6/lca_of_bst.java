

// Method2: Make use of the fact that given tree is a BST.
// If current root is LCA then root.val >= p .val && root.val <= q.val or root.val <= p.val && root.val >= q.val
// if root.val < p.val && root.val < q.val then we can search for LCA in left subtree else we will search in right subtree.
// T.C: O(H), S.C: O(H)
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        if(root == null){
            return null;
        }
        if(root.val >= p .val && root.val <= q.val){
            return root;
        }
        if(root.val <= p.val && root.val >= q.val){
            return root;
        }

        if(root.val < p.val && root.val < q.val){
            return lowestCommonAncestor(root.right, p, q);
        }
        return lowestCommonAncestor(root.left, p, q);
    }
}

// method1: Use the method to find LCA in simple Binary Tree.
// T.C: O(N), S.C: O(H)

class Solution2 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        if(root == null){
            return null;
        }
        if(root.val == p .val|| root.val == q.val){
            return root;
        }
        TreeNode leftAns = lowestCommonAncestor(root.left, p, q);
        TreeNode rightAns = lowestCommonAncestor(root.right, p, q);

        if(leftAns!=null && rightAns != null){
            return root;
        }

        if(leftAns == null){
            return rightAns;
        }

        return leftAns;
    }
}
public class lca_of_bst {
    
}
