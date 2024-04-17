
import java.util.ArrayList;
import java.util.List;

class TrieNode{
    TrieNode[] children;
    List<String> allStrings;

    public TrieNode(){
        children = new TrieNode[26];
        allStrings = new ArrayList<>();
    }
}

class Trie{
    TrieNode root;
    public Trie(){
        root = new TrieNode();
    }

    public void insert(String word){
        TrieNode node = root;

        for(int i=0; i<word.length(); i++){
            char curr = word.charAt(i);

            if(node.children[curr-'a'] == null){
                node.children[curr-'a'] = new TrieNode();
            }

            node = node.children[curr-'a'];
            node.allStrings.add(word);
        }
    }

    public List<String> search(String word){
        TrieNode node = root;

        for(int i=0; i<word.length(); i++){
            char curr = word.charAt(i);

            if(node.children[curr-'a'] == null){
                return node.allStrings;
            }

            node = node.children[curr-'a'];
        }

        return node.allStrings;
    }
}

public class auto_complete_feature_using_trie {
    public static void main(String[] args) {
        List<String> words = List.of("hello", "dog", "hell", "cat", "a", "hel","help","helps","helping");
        Trie trie = new Trie();
        for(String word: words){
            trie.insert(word);
        }

        System.out.println(trie.search("hel"));
    }
}
