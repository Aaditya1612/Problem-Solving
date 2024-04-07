package HomeWork.Tries_1;


class TrieNode{
    TrieNode[] children;
    boolean end;
    int cnt;
    public TrieNode(){
        children = new TrieNode[26];
        cnt = 0;
        end = false;
    }
}
class Trie {
    TrieNode root;
    public Trie() {
        root = new TrieNode();
    }
    
    // T.C: O(len(word))
    public void insert(String word) {
        TrieNode node = root;
        for(int i=0; i<word.length(); i++){
            char curr = word.charAt(i);
            if(node.children[curr-'a'] == null){
                node.children[curr-'a'] = new TrieNode();
            }
            node = node.children[curr-'a'];
            node.cnt++;
        }
        node.end = true;
    }
    
    // T.C: O(len(word))
    public boolean search(String word) {
        TrieNode node = root;
        for(int i=0; i<word.length(); i++){
            char curr = word.charAt(i);
            if(node.children[curr-'a'] == null){
                return false;
            }
            node = node.children[curr-'a'];
        }

        return node.end;
    }
    
    // T.C: O(len(prefix))
    public boolean startsWith(String prefix) {
        TrieNode node = root;
        for(int i=0; i<prefix.length(); i++){
            char curr = prefix.charAt(i);
            if(node.children[curr-'a'] == null){
                return false;
            }
            node = node.children[curr-'a'];
        }

        return node.cnt>0;
    }
}

public class implement_trie_lc {
    
}
