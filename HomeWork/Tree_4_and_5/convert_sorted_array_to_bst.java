package HomeWork.Tree_4_and_5;

// T.C: O(N), S.C: O(logN)
class Solution {
    public TreeNode convert(int[] nums, int st, int en){
        if(st>en){
            return null;
        }

        int mid = (st+en)/2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = convert(nums, st, mid-1);
        root.right = convert(nums, mid+1, en);

        return root;
    }
    public TreeNode sortedArrayToBST(int[] nums) {
        return convert(nums, 0, nums.length-1);
    }
}
public class convert_sorted_array_to_bst {
    
}
