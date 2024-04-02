package HomeWork.Tree_6;
import java.util.*;


// T.C: O(N), S.C: O(N) + O(H)
class Solution {
    public boolean putAndFind(TreeNode root, int k, HashSet<Integer> set){
        if(root == null){
            return false;
        }

        if(set.contains(k - root.val)){
            return true;
        }

        set.add(root.val);
        return putAndFind(root.left, k, set) || putAndFind(root.right, k, set);
    }
    public boolean findTarget(TreeNode root, int k) {
        return putAndFind(root, k, new HashSet<>());
    }
}
public class tow_sum_iv_input_is_bst {
    
}
