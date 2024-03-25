package HomeWork.Tree_3;

class Node
{
    int data;
    Node left, right;
   Node(int item)    {
        data = item;
        left = right = null;
    }
}

// T.C: O(2*N), S.C: O(2*H)
class GfG {
    public Node getLCA(Node root, int s, int d){
        if(root == null || root.data == s || root.data == d){
            return root;
        }
        Node leftContributor = getLCA(root.left, s, d);
        Node rightContributor = getLCA(root.right, s, d);
        if(leftContributor != null && rightContributor != null){
            return root;
        }
        else if(leftContributor != null){
            return leftContributor;
        } else{
            return rightContributor;
        }
    }
    public int ancToNodeDis(Node root, int val){
        if(root == null){
            return (int)1e9;
        }
        if(root.data == val){
            return 0;
        }
        
        return 1 + Math.min(ancToNodeDis(root.left, val), ancToNodeDis(root.right, val));
    }
    int findDist(Node root, int a, int b) {
        Node anc = getLCA(root, a, b);
        int dis1 = ancToNodeDis(anc, a);
        int dis2 = ancToNodeDis(anc, b);
        
        return dis1 + dis2;
    }
}
public class min_distance_between_two_nodes_in_bt {
    
}
