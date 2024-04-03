import java.util.*;


// Method 1: the most basic approach, use the idea of merge two sorted arrays. Convert trees into their inorders ans these inorders
// will represent two sorted arrays or list and then we can merge these two to get final amswer.

// T.C O(2*(M+N)), S.C: O(M+N) + O(H) +O(H)
class Solution
{
    //Function to return a list of integers denoting the node 
    //values of both the BST in a sorted order.
    public void inorder(Node root, List<Integer> list){
        if(root == null){
            return;
        }
        
        inorder(root.left, list);
        list.add(root.data);
        inorder(root.right, list);
    }
    public List<Integer> merge(Node root1,Node root2)
    {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        inorder(root1, list1);
        inorder(root2, list2);
        
        int pt1 = 0;
        int pt2 = 0;
        int n = list1.size();
        int m = list2.size();
        
        while(pt1 < n && pt2 <m){
            if(list1.get(pt1)<list2.get(pt2)){
                res.add(list1.get(pt1));
                pt1++;
            } else{
                res.add(list2.get(pt2));
                pt2++;
            }
        }
        
        while(pt1<n){
            res.add(list1.get(pt1++));
        }
        
        while(pt2<m){
            res.add(list2.get(pt2++));
        }
        
        return res;
    }
}

public class merge_two_bst {
    
}
