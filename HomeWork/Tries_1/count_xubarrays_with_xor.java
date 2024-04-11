import java.util.*;
class TrieNode{
    TrieNode[] children;
    int zcnt, ocnt;
    public TrieNode(){
        children = new TrieNode[2];
        zcnt = 0;
        ocnt = 0;
    }
}

class Trie{
    TrieNode root;
    public Trie(){
        root = new TrieNode();
    }

    public void insert(int val){
        TrieNode node = root;
        for (int i = 31; i >= 0; i--) {
            int x = (val&(1<<i)) > 0 ? 1 : 0;
            if(node.children[x] == null){
                node.children[x] = new TrieNode();
            }
            node = node.children[x];
            if (x == 1) {
                node.ocnt++;
            } else {
                node.zcnt++;
            }
        }
    }

    public int countSubarrays(int val, int k){
        TrieNode node = root;
        int res = 0;
        if(node == null){
            return res;
        }
        for (int i = 31; i >= 0; i--) {
            int bit_k = (k & (1<<i)) > 0 ? 1 : 0;
            int bit_val = (val & (1<<i)) > 0 ? 1 : 0;
            if (bit_k == 1) {
                if (bit_val == 1) {
                    if (node.children[1] != null)
                        res += node.children[1].ocnt;
                    if (node.children[0] == null)
                        return res;
                    node = node.children[0];
                } 
                else {
                    if (node.children[0] != null)
                        res += node.children[0].zcnt;
                    if (node.children[1] == null)
                        return res;
                    node = node.children[1];
                }
            } 
            else {
                if (bit_val == 1) {
                    if (node.children[1] == null)
                        return res;
                    node = node.children[1];
                } 
                else {
                    if (node.children[0] == null)
                        return res;
                    node = node.children[0];
                }
            }
        }

        return res;
    }
}

public class count_xubarrays_with_xor {
    public static void main(String args[] ) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while(t-->0){
            int n = sc.nextInt();
            int k = sc.nextInt();
            Trie trie = new Trie();
            int[] arr = new int[n];

            for(int i=0; i<n; i++){
                arr[i] = sc.nextInt();
            }

            int xor = 0;
            long ans = 0;
            int prev;
            trie.insert(xor);
            for(int i=0; i<n; i++){
                xor = xor ^ arr[i];
                ans += trie.countSubarrays(xor, k);
                trie.insert(xor);
            }
            System.out.println(ans);
        }
    }
}

