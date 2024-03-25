package HomeWork.Tree_3;
import java.util.*;

// T.C. O(N), S.C:O(N) + O(H)
class Solution {
    public void findPath(TreeNode root, List<List<Integer>> ans, List<Integer> tmp, int tar){
        if(root == null){
            return;
        }
        if(root.val == tar && root.right == null && root.left == null){
            tmp.add(root.val);
            ans.add(new ArrayList<>(tmp));
            tmp.remove(tmp.size()-1);
            return;
        }
        System.out.println(tmp);
        tmp.add(root.val);
        findPath(root.left, ans, tmp, tar-root.val);
        findPath(root.right, ans, tmp, tar-root.val);
        tmp.remove(tmp.size()-1);
    }
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> ans = new ArrayList<>();
        findPath(root, ans, new ArrayList<>(), targetSum);
        return ans;
    }
}
public class path_sum_2 {
    
}
