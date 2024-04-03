import java.util.*;


class Node{
    int data;
    Node left,right;
    Node(int d){
        data=d;
        left=right=null;
    }
}

// Method 1:
// Play with prev and current node in inorder traversal of the tree. Make prev.right = current and current.left = prev and then move
// prev to current by prev = curr. The recursion will do rest of the work.
// In last remember to connect tail and head, as we are required to make a circular doubly linked list so in last we will do
// head.left = prev and prev.right = head (As in the end of recursion, prev will be pointing at last node, just like the tail of the CDLL)

// T.C: O(N), S.C: O(H)
class Solution
{ 
    Node prev = null, head = null;
    
    void traverse(Node root){
        if(root == null){
            return;
        }
        
        traverse(root.left);
        
        if(head == null){
            head = root;
        } else{
            prev.right = root;
            root.left = prev;
        }
        
        prev = root;
        
        traverse(root.right);
    }
    Node bTreeToClist(Node root)
    {
        traverse(root);
        prev.right = head;
        head.left = prev;
        
        return head;
    }
    
}


// Method 2: Left side will give me a CDLL, Right side will give me a CDLL and I will merget root between both and return head
// of combines CDLL to the parent node.

// T.C: O(N), S.C: O(H)
class Solution2
{ 
    Node prev = null, head = null;
    
    Node connect(Node head1, Node head2){
        
        if(head1 == null){
            return head2;
        }
        
        if(head2 == null){
            return head1;
        }
        Node tail1 = head1.left;
        Node tail2 = head2.left;
        
        tail1.right = head2;
        head2.left = tail1;
        head1.left = tail2;
        tail2.right = head1;
        
        return head1;
    }
    
    Node build(Node root){
        
        if(root == null){
            return null;
        }
        
        Node leftHead = build(root.left);
        Node rightHead = build(root.right);
        
        root.left = root;
        root.right = root;
        
        Node leftConnectHead = connect(leftHead, root);
        Node head = connect(leftConnectHead, rightHead);
        
        return head;
    }
    Node bTreeToClist(Node root)
    {
        return build(root);
        
    }
    
}
    

    