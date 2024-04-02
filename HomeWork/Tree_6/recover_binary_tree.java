package HomeWork.Tree_6;

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


//  Method 2, recursive implemetation of idea of method 1, i.e. without storing any inorder array
// T.C: O(N) + O(N), S.C: O(H) + O(H)


class Solution {
    Integer val1 = null, val2 = null;
     TreeNode prev = null;
    public void swapNodes(TreeNode root, int val1, int val2){
        if(root == null){
            return;
        }

        if(root.val == val1){
            root.val = val2;
        } else if(root.val == val2){
            root.val = val1;
        }

        swapNodes(root.left, val1, val2);
        swapNodes(root.right, val1, val2);

    }
    public void helper(TreeNode root){
        if(root == null){
            return;
        }
        helper(root.left);
        if(val1 == null && prev!=null && prev.val > root.val){
            val1 = prev.val;
        }
        if(val1!=null && prev!=null && prev.val > root.val){
            val2 = root.val;
        }

        prev = root;
        helper(root.right);

    }
    public void recoverTree(TreeNode root) {
        helper(root);
        swapNodes(root, val1, val2);
    }
}


// Method 1, Just find out the InOrder of the given BST. The InOrder should be sorted for a BST. But here two nodes are swapped
// which means in the inorder traversal as well two nodes will not be at their actual postion. Thus to recover the BST
// we can use this idea of the Inorder Traversal. We can find the first largest and last smallest element and can swap them into
// the tree (In place) which will make the whole inorder array sorted.

// T.C: O(N) + O(N) + O(N), S.C1: O(N)
class Solution2 {
    public void inOrder(TreeNode root, List<Integer> in){
        if(root == null){
            return;
        }
        inOrder(root.left, in);
        in.add(root.val);
        inOrder(root.right, in);
    }

    public void replaceInTree(TreeNode root, int first, int second){
        if(root == null){
            return;
        }

        if(root.val == first){
            root.val = second;
        } else if(root.val == second){
            root.val = first;
        }

        replaceInTree(root.left, first, second);
        replaceInTree(root.right, first, second);
    }
    public void recoverTree(TreeNode root) {
        List<Integer> in = new ArrayList<Integer>();
        inOrder(root, in);
        Integer first = null;
        Integer second = null;
        for(int i=0; i<in.size()-1; i++){
            if(first == null && in.get(i) > in.get(i+1)){
                first = in.get(i);
            } if(in.get(i) > in.get(i+1)){
                second = in.get(i+1);
            }
        }
        
        if(second == null){
            second = in.get(in.size()-1);
        }

        // System.out.println(first);
        // System.out.println(second);

        replaceInTree(root, first, second);
    }
}

public class recover_binary_tree {
    
}
