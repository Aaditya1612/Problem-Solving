package HomeWork.Tree_3;

// Diameter is the maximum length of path between any two node. This maximum path can ocuur in any part of the subtree
// So to keep maximum path track I have created a maxDia[] array of length 1 which stores the maximum path length encountred so 
// far at the 0th index.
// T.C: O(N), S.C: O(H)
class Solution {
    public int longestPath(TreeNode root, int[] maxDia){
        if(root == null){
            return 0;
        }

        int lLongestPath = longestPath(root.left, maxDia);
        int rLongestPath = longestPath(root.right, maxDia);
        maxDia[0] = Math.max(maxDia[0], lLongestPath+rLongestPath);
        return 1 + Math.max(lLongestPath, rLongestPath) ;
    }
    public int diameterOfBinaryTree(TreeNode root) {
        int[] maxDia = new int[1];
        longestPath(root, maxDia);
        return maxDia[0];
    }
}
public class diameter_of_bt {
    
}
