package HomeWork.Tree_3;
import java.util.*;

class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) {
      val = x;
      left=null;
      right=null;
     }
 }
 // T.C: O(N), S.C: O(3*H)
class Solution {
    public boolean findPath(TreeNode A, int B, ArrayList<Integer> path){
        if(A == null){
            return false;
        }
        
        if(A.val == B || findPath(A.left, B, path) || findPath(A.right, B, path)){
            path.add(A.val);
            return true;
        }
        
        return false;
    }
    public int[] solve(TreeNode A, int B) {
        ArrayList<Integer> path = new ArrayList<>();
        
        findPath(A, B, path);
        
        int[] ans = new int[path.size()];
        
        for(int i=0; i<path.size(); i++){
            ans[path.size()-1-i] = path.get(i);
        }
        
        return ans;
        
    }
}

public class path_to_given_node {
    
}
