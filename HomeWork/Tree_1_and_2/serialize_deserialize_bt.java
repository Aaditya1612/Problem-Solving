package HomeWork.Tree_1_and_2;

import java.util.*;

// Memory optimized version of the MLE intution, no need to maintain extra arraylist and String[] array in serialize() function
// Simple Level order traversal will do work as in level order traversal nodes come in the way they should have been 
// in the array representaiton of the Binary Tree.

// Note "$" -> NULL

class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null){
            return "$";
        }
        Queue<TreeNode> q = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        q.add(root);
        while(!q.isEmpty()){
            TreeNode curr = q.poll();
            if(curr == null){
                sb.append("$ ");
                continue;
            }

            sb.append(Integer.toString(curr.val)+" ");
            q.add(curr.left);
            q.add(curr.right);
        }
        System.out.println(sb.toString());
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.equals("$")){
            return null;
        }
        String[] arr = data.split(" ");
        TreeNode root = new TreeNode(Integer.parseInt(arr[0]));

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        for(int i=1; i<arr.length; i++){
            TreeNode curr = q.poll();

            if(!arr[i].equals("$")){
                TreeNode left = new TreeNode(Integer.parseInt(arr[i]));
                curr.left = left;
                q.add(left);
            }
            i++;
            if(!arr[i].equals("$")){
                TreeNode right = new TreeNode(Integer.parseInt(arr[i]));
                curr.right = right;
                q.add(right);
            }
        }
        return root;
    }
}


// Below code is the first intuition which I got and giving MLE on last test case.
class Pair{
    TreeNode node;
    int ind;
    public Pair(TreeNode node, int ind){
        this.node = node;
        this.ind = ind;
    }
 }
class Codec2 {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        int maxi = Integer.MIN_VALUE;
        if(root == null){
            return "$";
        }

        Queue<Pair> q = new LinkedList<>();
        List<Pair> lst = new ArrayList<>();
        
        q.add(new Pair(root, 0));
        while(!q.isEmpty()){
            int size = q.size();
            int cnt = 0;
            
            while(cnt++<size){
                Pair curr = q.poll();
                maxi = Math.max(maxi, curr.ind);
                lst.add(new Pair(curr.node, curr.ind));
                if(curr.node.left!=null) q.add(new Pair(curr.node.left, 2*curr.ind+1));
                if(curr.node.right!=null) q.add(new Pair(curr.node.right, 2*curr.ind+2));
            }
        }
        StringBuilder[] arr = new StringBuilder[maxi+1];
        Arrays.fill(arr, new StringBuilder("$"));
        for(Pair p: lst){
            arr[p.ind] = new StringBuilder(Integer.toString(p.node.val));
        }

        StringBuilder builder = new StringBuilder();
        for(StringBuilder s : arr) {
            builder.append(s);
            builder.append(" ");
        }
        return builder.toString();
    }

    public TreeNode arrayToTree(String[] arr, int i){
        if(i>=arr.length){ return null;}
        if(arr[i].equals("$")) { return null;}

        TreeNode root = new TreeNode(Integer.parseInt(arr[i]));
        root.left = arrayToTree(arr, 2*i+1);
        root.right = arrayToTree(arr, 2*i+2);

        return root;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] arr = data.split(" ");
        return arrayToTree(arr, 0);
    }
}

public class serialize_deserialize_bt {
    
}
