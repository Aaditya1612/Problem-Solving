package HomeWork.Tries_1;

// for each trienode maintain two variables ind and len which will store index and length of the smallest string in wordsContainer
//  that has a suffix of string till current trieNode. 

// The reverse of each string in the input array has been done so that question of suffix can be converted to question of prefix

// T.C: O(N*len(String)) + O(M*len(String)), N-> Length of wordsContainer, M -> length of wordsQuery
// S.C: O(N*len(String))
class TrieNode{
    TrieNode[] children;
    int ind;
    int len;
    public TrieNode(){
        children = new TrieNode[26];
        ind = Integer.MAX_VALUE;
        len = Integer.MAX_VALUE;
    }
}

class Trie{

    TrieNode root;

    public Trie(){
        root = new TrieNode();
    }

    public void insert(String word, int ind){
        TrieNode node = root;
        int n = word.length();

        if(node.len > n){
            node.len = n;
            node.ind = ind;
        }
        for(int i=0; i<word.length(); i++){
            char curr = word.charAt(i);

            if(node.children[curr-'a'] == null){
                node.children[curr-'a'] = new TrieNode();
            }

            node = node.children[curr-'a'];
            if(node.len > n){
                node.len = n;
                node.ind = ind;
            }
        }
    }

    public int suffix(String s){
        TrieNode node = root;
        
        for(int i=0; i<s.length(); i++){
            char curr = s.charAt(i);

            if(node.children[curr-'a'] == null){
                return node.ind;
            }

            node = node.children[curr-'a'];
        }

        return node.ind;
    }
}

class Solution {
    public int[] stringIndices(String[] wordsContainer, String[] wordsQuery) {
        Trie trie = new Trie();

        for(int i=0; i<wordsContainer.length; i++){
            StringBuilder sb = new StringBuilder(wordsContainer[i]);
            sb = sb.reverse();
            trie.insert(sb.toString(), i);
        }

        int[] ans = new int[wordsQuery.length];

        for(int i=0; i<wordsQuery.length; i++){
            StringBuilder sb = new StringBuilder(wordsQuery[i]);
            sb = sb.reverse();
            ans[i] = trie.suffix(sb.toString());
        }

        return ans;
    }
}
public class longest_common_suffix_queries {
    
}
