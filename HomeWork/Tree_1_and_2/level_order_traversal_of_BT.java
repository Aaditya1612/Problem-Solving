package HomeWork.Tree_1_and_2;
import java.util.*;

//Iterative solution, T.C O(n), S.C: O(n)
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();

        if(root==null) return res;
        Queue<TreeNode> q = new LinkedList<>();

        q.add(root);

        while(!q.isEmpty()){
            int size = q.size();
            int count = 0;
            List<Integer> temp = new ArrayList<>();
            while(count++<size){
                TreeNode curr = q.poll();
                temp.add(curr.val);
                if(curr.left!=null) q.add(curr.left);
                if(curr.right!=null) q.add(curr.right);
            }

            res.add(temp);
 
        }

        return res;
    }
}

// Recursive T.C. O(n), S.C. O(n) + O(NumberOfLevels) + O(n)
class Solution2 {
    public void traverse(TreeNode root, Map<Integer, List<Integer>> map, int lvl){
        if(root == null){
            return;
        }
        map.putIfAbsent(lvl, new ArrayList<>());
        map.get(lvl).add(root.val);

        if(root.left!=null){
            traverse(root.left, map, lvl+1);
        }

        if(root.right!=null){
            traverse(root.right, map, lvl+1);
        }
    }
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        Map<Integer, List<Integer>> map = new HashMap<>();
        traverse(root, map, 0);

        for(Map.Entry<Integer, List<Integer>> entry: map.entrySet()){
            ans.add(new ArrayList<>(entry.getValue()));
        }       

        return ans;
    }
}
public class level_order_traversal_of_BT {
    
}
