package HomeWork.Tree_1_and_2;

import java.util.*;


// Iterative Solution, Recursive solution is from line 55
class Triple{
    TreeNode node;
    int x;
    int y;
    public Triple(TreeNode node, int x, int y){
        this.node = node;
        this.x = x;
        this.y = y;
    }
}
class Solution2 {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
        List<List<Integer>> ans = new ArrayList<>();
        Stack<Triple> st = new Stack<>();

        st.push(new Triple(root, 0, 0));

        while(!st.isEmpty()){
            Triple curr = st.pop();
            map.putIfAbsent(curr.x, new TreeMap<>());
            TreeMap<Integer, PriorityQueue<Integer>> innerMap = map.get(curr.x);
            innerMap.putIfAbsent(curr.y, new PriorityQueue<>());
            innerMap.get(curr.y).add(curr.node.val);

            if(curr.node.right!=null)
                st.push(new Triple(curr.node.right, curr.x+1, curr.y+1));
            if(curr.node.left!=null)
                st.push(new Triple(curr.node.left, curr.x-1, curr.y+1));
        }

        for(Map.Entry<Integer, TreeMap<Integer, PriorityQueue<Integer>>> entry: map.entrySet()){
            List<Integer> tmp = new ArrayList<>();
            for(Map.Entry<Integer, PriorityQueue<Integer>> innerEntry: entry.getValue().entrySet()){
                PriorityQueue<Integer> curr = innerEntry.getValue();
                while(!curr.isEmpty()){
                    tmp.add(curr.poll());
                }
            }

            ans.add(new ArrayList<>(tmp));
        }

        return ans;
    }
}

// Recusrsive solutiom, T.C: O(N*logN) + O(widthOfTree)+O(N);
class Solution {
    public void traverseAndPut(TreeNode root, TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map, int x, int y){
        if(root == null){ return;}
        map.putIfAbsent(x, new TreeMap<>());
        TreeMap<Integer, PriorityQueue<Integer>> curr = map.get(x);
        curr.putIfAbsent(y, new PriorityQueue<Integer>());
        curr.get(y).add(root.val);

        if(root.right!=null)
            traverseAndPut(root.right, map, x+1, y+1);
        if(root.left!=null)
            traverseAndPut(root.left, map, x-1, y+1);

    }
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
        traverseAndPut(root, map, 0, 0);

        List<List<Integer>> ans = new ArrayList<>();

        for(Map.Entry<Integer, TreeMap<Integer, PriorityQueue<Integer>>> entry: map.entrySet()){
            List<Integer> tmp = new ArrayList<>();
            for(Map.Entry<Integer, PriorityQueue<Integer>> innerEntry: entry.getValue().entrySet()){
                PriorityQueue<Integer> curr = innerEntry.getValue();
                while(!curr.isEmpty()){
                    tmp.add(curr.poll());
                }
            }

            ans.add(new ArrayList<>(tmp));
        }

        return ans;
    }
}

public class vertical_order_traversal_bt {
    
}
