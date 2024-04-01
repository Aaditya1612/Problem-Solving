package HomeWork.Tree_4_and_5;
import java.util.*;


// Method 1: Use a HashSet<>() to keep track of values present in root1

// T.C O(M+N) + O(K*logK), k -> number of common nodes, 
// S.C O(H1) + O(H2) + O(N), N -> Number of nodes in root1, M-> number of nodes in root2
class Solution
{
    public static void addInSet(Node root1, HashSet<Integer> set){
        if(root1 == null){
            return;
        }
        
        set.add(root1.data);
        addInSet(root1.left, set);
        addInSet(root1.right, set);
    }
    public static void addInList(Node root2, ArrayList<Integer> ans, HashSet<Integer> set){
        if(root2 == null) { return; }
        
        if(set.contains(root2.data)){ ans.add(root2.data); }
        
        addInList(root2.left, ans, set);
        addInList(root2.right, ans, set);
    }
	public static ArrayList<Integer> findCommon(Node root1,Node root2)
    {
        HashSet<Integer> set = new HashSet<>();
        ArrayList<Integer> ans = new ArrayList<>();
        
        addInSet(root1, set);
        addInList(root2, ans, set);
        Collections.sort(ans);
        return ans;
    }
}

public class find_common_nodes_in_two_bst {
    
}
