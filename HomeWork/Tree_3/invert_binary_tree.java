package HomeWork.Tree_3;

//T.C: O(N), S.C: O(H)
class Solution {
    public TreeNode invertTree(TreeNode root) {
        if(root == null){
            return null;
        }

        TreeNode temp = root.right;
        root.right = root.left;
        root.left = temp;

        invertTree(root.left);
        invertTree(root.right);

        return root;
    }
}
public class invert_binary_tree {
    
}
