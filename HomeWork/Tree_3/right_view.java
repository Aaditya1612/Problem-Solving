package HomeWork.Tree_3;

import java.util.*;
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

// Iterative using level order traversal, T.C: O(N), S.C: O(H)
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        if(root == null){
            return new ArrayList<>();
        }
        Queue<TreeNode> q = new LinkedList<>();
        List<Integer> ans = new ArrayList<>();
        q.add(root);
        while(!q.isEmpty()){
           int size = q.size();
           int cnt = 0;
           boolean first = true;
           while(cnt++<size){
            TreeNode curr = q.remove();
            if(first){ 
                ans.add(curr.val);
                first = false;
            }
            if(curr.right!=null) q.add(curr.right);
            if(curr.left!=null) q.add(curr.left);
           }
        }

        return ans;
    }
}

// Recursive code, T.C: O(N), S.C.: O(H) + O(H)
class Solution2 {
    public void getLeftView(TreeNode root, List<Integer> leftView, int lvl){
        if(root == null){
            return;
        }

        if(leftView.size() < lvl){
            leftView.add(root.val);
        }
        getLeftView(root.right, leftView, lvl+1);
        getLeftView(root.left, leftView, lvl+1);
    }
    public List<Integer> rightSideView(TreeNode root) {
        if(root == null){
            return new ArrayList<>();
        }
        List<Integer> ans = new ArrayList<>();
        getLeftView(root, ans, 1);
        return ans;
    }
}

public class right_view {
    
}
