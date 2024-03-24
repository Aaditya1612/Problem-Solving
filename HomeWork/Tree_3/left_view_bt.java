package HomeWork.Tree_3;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;


class TreeNode<T>
{
    T data;
    TreeNode<T> left;
    TreeNode<T> right;

    TreeNode(T data) {
        this.data = data;
        left = null;
        right = null;
    }
};



// Iterative code using level order traversal
// T.C. O(N), S.C: O(N)
class Solution {
    public static void printLeftView(TreeNode<Integer> root) {
        Queue<TreeNode<Integer>> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            int cnt = 0;
            boolean first = true;

            while(cnt++<size){
                TreeNode<Integer> curr = q.poll();
                if(first){
                    System.out.print(curr.data+" ");
                    first = false;
                }

                if(curr.left!=null) q.add(curr.left);
                if(curr.right!=null) q.add(curr.right);
            }
        }
    }
}

// Recursive solution // T.C. O(N), S.C: O(N) + O(H)

class Solution2 {
    public static void getLeftView(TreeNode<Integer> root, ArrayList<Integer> leftView, int lvl){
        if(root == null){
            return;
        }

        if(leftView.size() < lvl){
            leftView.add(root.data);
        }

        getLeftView(root.left, leftView, lvl+1);
        getLeftView(root.right, leftView, lvl+1);
    }
    public static void printLeftView(TreeNode<Integer> root) {
       ArrayList<Integer> leftView = new ArrayList<>();
       getLeftView(root, leftView, 1);

       for(int i: leftView){
           System.out.print(i+" ");
       }
    }
}

public class left_view_bt {
    
}
