package HomeWork.Tree_1_and_2;

import java.util.*;
class Pair{
    Node node;
    int y;
    public Pair(Node node, int y){
        this.node = node;
        this.y = y;
    }
}

// Iterative solution, T.C: O(N), S.C: O(N)

class Solution
{
    //Function to return a list containing the bottom view of the given tree.
    public ArrayList <Integer> bottomView(Node root)
    {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        Queue<Pair> q = new LinkedList<>();
        ArrayList<Integer> ans = new ArrayList<>();
        
        q.add(new Pair(root, 0));
        
        while(!q.isEmpty()){
            Pair curr =q.poll();
            map.put(curr.y, curr.node.data);
            
            if(curr.node.left!=null) q.add(new Pair(curr.node.left, curr.y-1));
            if(curr.node.right!=null) q.add(new Pair(curr.node.right, curr.y+1));
        }
        
        for(Map.Entry<Integer, Integer> entry: map.entrySet()){
            ans.add(entry.getValue());
        }
        
        return ans;
    }
}
public class bottom_view_bt {
    
}
