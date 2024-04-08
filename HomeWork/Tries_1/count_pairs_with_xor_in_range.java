package HomeWork.Tries_1;
// Find number of pairs with xor less than high+1
// find number of pairs with xor less than low
// subtract both the results to get number of pairs with xor within low to high
// T.C: O(90*N), N->length of nums, S.C: O(15*N)
class TrieNode{
    TrieNode children[];
    int cnt;
    public TrieNode(){
        children = new TrieNode[2];
        cnt = 0;
    }
}
class Trie{
    TrieNode root;

    public Trie(){
        root = new TrieNode();
    }

    public void insert(int val){
        int i = 1<<15;
        TrieNode tmp = root;
        while(i>0){
            int curr =(val&i) > 0 ? 1 : 0;
            if(tmp.children[curr] == null){
                tmp.children[curr] = new TrieNode();
            }
            tmp = tmp.children[curr];
            tmp.cnt++;
            i = i>>1;
        } 
    }
    public int search(int val, int key){
        int res = 0;
        int set = 1 << 15;
        TrieNode node = root;
        for(; set>0 && node!=null; set = set>>1){
            int valbit = (val&set) > 0 ? 1 : 0;
            int keybit = (key&set) > 0 ? 1 : 0;

            int xor = valbit ^ keybit;

            if(keybit == 1 && node.children[xor^1]!=null){
                res+=node.children[xor^1].cnt;
            }
            node = node.children[xor];
        }
        return res;
    }
}
class Solution {
    public int countPairs(int[] nums, int low, int high) {
        Trie trie = new Trie();
        int ans = 0;
        for(int i=0; i<nums.length; i++){
            ans+=trie.search(nums[i], high+1);
            ans-=trie.search(nums[i], low);
            trie.insert(nums[i]);
        }

        return ans;
    }
}
public class count_pairs_with_xor_in_range {
    
}
