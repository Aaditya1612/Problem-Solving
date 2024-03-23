package HomeWork.Tree_1_and_2;

import java.util.*;

class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}

class Solution
{
	int getLevelDiff(Node root)
	{
	    boolean isOdd = true;
	    int oddSum = 0;
	    int evenSum = 0;
	    
	    Queue<Node> q = new LinkedList<>();
	    q.add(root);
	    
	    while(!q.isEmpty()){
	        int size = q.size();
	        int cnt = 0;
	        
	        while(cnt++<size){
	            Node curr = q.poll();
	            if(isOdd){
	                oddSum+=curr.data;
	            } else{
	                evenSum+=curr.data;
	            }
	            
	            if(curr.left!=null) q.add(curr.left);
	            if(curr.right!=null) q.add(curr.right);
	        }
	        
	        isOdd = !isOdd;
	    }
	    
	    return oddSum-evenSum;
	}
}

public class odd_even_level_diff {
    
}
