package HomeWork.Tree_1_and_2;

import java.util.*;

// Recursive approach
class Solution {
    public int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }

        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);

        return (leftDepth>rightDepth)?(leftDepth+1):(rightDepth+1);
    }
}

// Iterative solution using Queue

class Solution2 {
    public int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }

        Queue<TreeNode> q = new LinkedList<>();

        int ans = 0;
        q.add(root);

        while(!q.isEmpty()){
            int size = q.size();
            int cnt = 0;
            ans++;
            while(cnt++<size){
                TreeNode curr = q.poll();

                if(curr.right!=null){ q.add(curr.right);}
                if(curr.left!=null) { q.add(curr.left);}
            }
        }

        return ans;
    }
}


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
public class maximum_depth_of_BT {
    
}
