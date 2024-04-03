

// The idea is simple, the first element of the preorder is always root. Left subtree will contain all the elements less than current root
// and right subtree will contain all the elements greater than current root. Let the recursion do the work on all nodes

// T.C: O(NlogN), S.C: O(H)
class Solution {
    public int findAllSmaller(int[] preorder, int start, int end, int val){
        for(int i=start; i<=end; i++){
            if(preorder[i] > val){
                return i;
            }
        }

        return end+1;
    }
    public TreeNode builder(int[] preorder, int start, int end){
        if(start>end){
            return null;
        }

        TreeNode root = new TreeNode(preorder[start]);
        int indTillGreater = findAllSmaller(preorder, start, end, root.val);
        root.left = builder(preorder, start+1, indTillGreater-1);
        root.right = builder(preorder, indTillGreater, end);

        return root;
    }
    public TreeNode bstFromPreorder(int[] preorder) {
        return builder(preorder, 0, preorder.length-1);
    }
}

public class construct_bst_from_preorder {
    
}
