
// T.C : O(N*32)
// S.C: O(N*32)
class TrieNode{
    int cnt;
    int ind;
    TrieNode[] children;

    public TrieNode(int ind, int cnt){
        this.cnt = cnt;
        this.ind = ind;
        children = new TrieNode[2];
    }
}

class Trie{
    TrieNode root;
    public Trie(){
        root = new TrieNode(-1, -1);
    }

    public void insert(int xor, int index){
        TrieNode node = root;
        for(int i=31; i>=0; i--){
            int bit = (xor & (1 << i)) > 0 ? 1 : 0;
            if(node.children[bit] == null){
                node.children[bit] = new TrieNode(index+1, 1);
            }

            node = node.children[bit];
        }
    }

    public int search(int xor, int index){
        TrieNode node = root;

        for(int i=31; i>=0; i--){
            int bit = (xor & (1 << i)) > 0 ? 1 : 0;
            if(node.children[bit] == null){
                return 0;
            }
            node = node.children[bit];
        }
        int res = (node.cnt*index - node.ind);
        node.cnt = node.cnt + 1;
        node.ind = node.ind + index + 1; 
        return res;
    }
}

class Solution {
    public int countTriplets(int[] arr) {
        int[] pre = new int[arr.length+1];
        Trie trie = new Trie();
        for(int i=1; i<= arr.length; i++){
            pre[i] = arr[i-1] ^ pre[i-1];
        }

        trie.insert(0, 0);
        int ans = 0;
        for(int i=1; i<=arr.length; i++){
            ans += trie.search(pre[i], i);
            trie.insert(pre[i], i);
        }

        return ans;
    }
}