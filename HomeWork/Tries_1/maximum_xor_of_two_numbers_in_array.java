package HomeWork.Tries_1;

// T.C: O(31*N) + O(31*N)
// S.C: O(31*N)
class TrieNode{
    TrieNode[] children;
    public TrieNode(){
        children = new TrieNode[2];
    }
}
class Trie{
    TrieNode root;
    public Trie(){
        root = new TrieNode();
    }

    public void insert(int val){
        int i = 30;
        TrieNode node = root;
        while(i>=0){
            int bit = (val&(1 << i)) > 0 ? 1 : 0;
            if(node.children[bit] == null){
                node.children[bit] = new TrieNode();
            }

            node = node.children[bit];
            i--;
        }
    }

    public int findMaxXOR(int val){
        TrieNode node = root;
        int i = 30;
        int xor = 0;
        while(i >= 0 && node!=null){
            int bit = (val&(1 << i)) > 0 ? 1 : 0;
            if(bit == 1){
                if(node.children[0]!=null){
                    node = node.children[0];
                    xor += (1 << i);
                } else{
                    node = node.children[1];
                }
            } else{
                if(node.children[1]!=null){
                    node = node.children[1];
                    xor += (1 << i);
                } else{
                    node = node.children[0];
                }
            }
            i--;
        }
        return xor;
    }
}
class Solution {
    public int findMaximumXOR(int[] nums) {
        int ans = Integer.MIN_VALUE;
        Trie trie = new Trie();
        for(int i=0; i<nums.length; i++){
            trie.insert(nums[i]);
        }
        for(int i=0; i<nums.length; i++){
            int val = trie.findMaxXOR(nums[i]);
            ans = Math.max(val, ans);
        }

        return ans;
    }
}
public class maximum_xor_of_two_numbers_in_array {
    
}
