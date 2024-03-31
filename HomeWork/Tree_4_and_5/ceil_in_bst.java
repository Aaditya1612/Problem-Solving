package HomeWork.Tree_4_and_5;

class Node {
    int data;
    Node left;
    Node right;
    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}
// T.C: O(H), S.C: O(H)
class Tree {
    int ans = -1;
    int findCeil(Node root, int key) {
        if (root == null) return -1;
        
        if(root.data == key){
            ans = root.data;
            return root.data;
        } else if(root.data > key){
            ans = root.data;
            findCeil(root.left, key);
        } else{
            findCeil(root.right, key);
        }
        
        return ans;
    }
}
public class ceil_in_bst {
    
}
