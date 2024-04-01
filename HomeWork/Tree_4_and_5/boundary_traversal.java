import java.util.*;

// First do LeftView, Then do bottom view then view right view.
// T.C: 
class Solution
{
    public static boolean isLeaf(Node root){
        return root.left == null && root.right == null;
    }
    public static void leftView(Node root, List<Integer> ans, int level){
        if(root == null){
            return;
        }

        if(isLeaf(root)){ return;}

        if(ans.size()<=level){
            ans.add(root.data);
        }

        if(root.left!=null){
            leftView(root.left, ans, level+1);
        } else{
            leftView(root.right, ans, level+1);
        }

    }
    public static void bottomView(Node root, List<Integer> ans){
        if(root == null){
            return;
        }
        if(isLeaf(root)){
            ans.add(root.data);
        }

        bottomView(root.left, ans);
        bottomView(root.right, ans);
    }

    public static void rightView(Node root, List<Integer> ans, int level){
        if(root == null){
            return;
        }
        
        if(isLeaf(root)){ return;}

        if(ans.size() < level){
            ans.add(root.data);
        }

        if(root.right!=null){
            rightView(root.right, ans, level+1);
        } else{
            rightView(root.left, ans, level+1);
        }
    }
	ArrayList <Integer> boundary(Node node)
	{
	    ArrayList<Integer> ans = new ArrayList<>();
	    if(!isLeaf(node)) { ans.add(node.data);}
	    if(node.left!=null)
            leftView(node, ans, 0);
        bottomView(node, ans);
        int pos = ans.size();
        List<Integer> right = new ArrayList<>();
        if(node.right!=null)
            rightView(node, right, 0);

        Collections.reverse(right);
        for(int i: right){
            ans.add(i);
        }
        return ans;
	}
}



public class boundary_traversal {
    
}
