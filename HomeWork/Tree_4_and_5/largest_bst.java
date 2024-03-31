package HomeWork.Tree_4_and_5;

// T.C: O(N), S.C: O(H)
class subTreeInfo{
    boolean isBST;
    int maxi;
    int mini;
    int size;
    
    public subTreeInfo(boolean isBST, int maxi, int mini, int size){
        this.maxi = maxi;
        this.mini = mini;
        this.isBST = isBST;
        this.size = size;
    }
}
class Solution{
    
    static subTreeInfo helper(Node root){
        if(root == null){
            return new subTreeInfo(true, Integer.MIN_VALUE, Integer.MAX_VALUE, 0);
        }
        
        subTreeInfo left = helper(root.left);
        subTreeInfo right = helper(root.right);
        
        boolean isBST = (left.isBST && right.isBST && root.data > left.maxi && root.data < right.mini);
        int size = isBST ? (left.size+right.size+1) : Math.max(left.size, right.size);
        int maxi = Math.max(right.maxi, root.data);
        int mini = Math.min(left.mini, root.data);
        
        return new subTreeInfo(isBST, maxi, mini, size);
        
    }
    static int largestBst(Node root)
    {
        return helper(root).size;
        
    }
    
}

public class largest_bst {
    
}
