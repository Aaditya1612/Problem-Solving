package HomeWork.Tries_1;


// T.C: O(N*max_len) , n -> Length of words array and max_len is maximum length of string in words array.
class TrieNode{
    TrieNode[] children;
    int cnt;
    public TrieNode(){
        children = new TrieNode[26];
        cnt = 0;
    }
}
class Trie{
    TrieNode root;
    public Trie(){
        root = new TrieNode();
    }

    public void insert(String s){
        TrieNode tmp = root;

        for(int i=0; i<s.length(); i++){
            char curr = s.charAt(i);

            if(tmp.children[curr-'a'] == null){
                tmp.children[curr-'a'] = new TrieNode();
            }
            tmp = tmp.children[curr-'a'];
            tmp.cnt++;
        }
    }

    public int countStringsWithPrefix(String s){
        TrieNode tmp = root;
        int ans = 0;
        for(int i=0; i<s.length(); i++){
            char curr = s.charAt(i);

            if(tmp.children[curr-'a'] == null){
                return ans;
            }
            tmp = tmp.children[curr-'a'];
            ans += tmp.cnt;
        }

        return ans;
    }
}
class Solution {
    public int[] sumPrefixScores(String[] words) {
        Trie trie = new Trie();
        int[] res = new int[words.length];

        for(int i=0; i<words.length; i++){
            trie.insert(words[i]);
        }

        for(int i=0; i<words.length; i++){
            res[i] = trie.countStringsWithPrefix(words[i]);
        }

        return res;
    }
}

public class sum_of_prefix_scores_of_string {
    
}
