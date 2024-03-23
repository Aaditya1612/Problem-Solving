package HomeWork.Tree_1_and_2;

import java.util.*;
class Solution {
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();

        q.add(root);
        int ans = root.val;
        while(!q.isEmpty()){
            int size = q.size();
            int cnt = 0;
            boolean take = false;
            while(cnt++<size){
                TreeNode curr = q.remove();
                if(!take){
                    ans = curr.val;
                    take = true;
                }

                if(curr.left!=null) {q.add(curr.left);}
                if(curr.right!=null) {q.add(curr.right);}
            }

        }

        return ans;
    }
}

public class bottom_left_tree_value {
    
}
