package HomeWork.Tree_3;
import java.util.*;
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

 // T.C: O(N), S.C O(N) + O(N)
class Solution {
    public void path(TreeNode root, StringBuilder sb, List<String> ans){
        if(root == null){ return;}
        int len = sb.length();
        if(root.left == null && root.right == null){
            sb.append("->"+root.val);
            ans.add(sb.toString());
            sb.setLength(len);
            return;
        }
        sb.append("->"+root.val);

        path(root.left, sb, ans);
        path(root.right, sb, ans);

        sb.setLength(len);
    }
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ans = new ArrayList<>();
        if(root.right == null && root.left == null){
            ans.add(root.val+"");
            return ans;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(root.val+"");
        path(root.left, sb, ans);
        sb.setLength(0);
        sb.append(root.val+"");
        path(root.right, sb, ans);

        return ans;
    }
}
public class binary_tree_path {
    
}
