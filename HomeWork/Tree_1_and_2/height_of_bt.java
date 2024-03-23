package HomeWork.Tree_1_and_2;

class Solution {
    public static int heightOfBinaryTree(TreeNode root) {
        if(root == null) { return 0;}

        int lheight = heightOfBinaryTree(root.left);
        int rheight = heightOfBinaryTree(root.right);

        return (lheight>rheight)?(lheight+1):(rheight+1);
    }
}

public class height_of_bt {
    
}
