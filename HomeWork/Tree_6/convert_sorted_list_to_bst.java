class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

// T.C: O(nlogn), S.C: O(H)
class Solution {
    public ListNode[] getMidOfList(ListNode head){
        ListNode fast = head;
        ListNode slow = head;
        ListNode prevToSlow = head;
        while(fast!=null && fast.next!=null){
            prevToSlow = head;
            slow = slow.next;
            fast = fast.next.next;
        }

        return new ListNode[]{prevToSlow, slow}; // slow is pointing to mid and prev is pointitng to the node just before slow
    }
    public TreeNode sortedListToBST(ListNode head) {
        if(head == null){
            return null;
        } if(head.next == null){
            return new TreeNode(head.val);
        }
        ListNode[] mid = getMidOfList(head);
        TreeNode root = new TreeNode(mid[1].val);
        // System.out.println(mid.val);
        TreeNode right = sortedListToBST(mid[1].next); // mid already included so right subtree will strart from mid.next in LL;
        mid[1].next = null; // To break the chain at mid, the node before the mid is known as prev here
        TreeNode left = sortedListToBST(mid[1].next);

        root.left = left;
        root.right = right;

        return root;
    }
}

public class convert_sorted_list_to_bst {
    
}
