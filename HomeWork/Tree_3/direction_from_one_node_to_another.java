package HomeWork.Tree_3;
// T.C : O(3*N), S.C: o(3*H)
class Solution {
    public TreeNode getLCA(TreeNode root, int s, int d){
        if(root == null || root.val == s || root.val == d){
            return root;
        }
        TreeNode leftContributor = getLCA(root.left, s, d);
        TreeNode rightContributor = getLCA(root.right, s, d);
        if(leftContributor != null && rightContributor != null){
            return root;
        }
        else if(leftContributor != null){
            return leftContributor;
        } else{
            return rightContributor;
        }
    }
    public String getPathOne(TreeNode root, int s, StringBuilder tmp){
        if(root == null){
            return "";
        }
        if(root.val == s){
            return tmp.toString();
        }

        int len = tmp.length();
        tmp.append("U");
        String l1 = getPathOne(root.left, s, tmp);
        String l2 = getPathOne(root.right, s, tmp);

        tmp.setLength(len);
        
        return l1+l2;

    }
    public String getPathTwo(TreeNode root, int s, StringBuilder tmp){
        if(root == null){
            return "";
        }
        if(root.val == s){
            return tmp.toString();
        }
        int len = tmp.length();
        tmp.append("L");
        String l1 = getPathTwo(root.left, s, tmp);
        tmp.setLength(len);
        tmp.append("R");
        String l2 = getPathTwo(root.right, s, tmp);
        tmp.setLength(len);
        return l1+l2;
    }
    public String getDirections(TreeNode root, int startValue, int destValue) {
        TreeNode anc = getLCA(root, startValue, destValue);
        String p1 =  getPathOne(anc, startValue, new StringBuilder());
        String p2 = getPathTwo(anc, destValue, new StringBuilder());
        return p1+p2;
    }
}
public class direction_from_one_node_to_another {
    
}
