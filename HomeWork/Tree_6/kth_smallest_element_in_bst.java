package HomeWork.Tree_6;

// T.C: O(K), S.C: O(H)
class Solution {
    int ans = 0;
    int cnt = 0;
    public void traverse(TreeNode root, int k){
        if(root == null){
            return;
        }

        traverse(root.left, k);
        cnt++;
        if(k == cnt){
            ans = root.val;
            return;
        }

        traverse(root.right, k);
    }
    public int kthSmallest(TreeNode root, int k) {
        traverse(root, k);
        return ans;
    }
}

public class kth_smallest_element_in_bst {
    
}
