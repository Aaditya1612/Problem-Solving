package HomeWork.Tries_1;
import java.util.List;

// Replace each word in the sentence with the smallest prefix present inside the dictionary list.
// If no prefix is present then leave it unchanged.

// T.C: O(N*max_len(string in dictionary)) + O(M*max_len(string in dictionary)), N -> Lemgth of dictionary, M - > number of words in sentence

class TrieNode{
    TrieNode[] children;
    boolean isEnd;
    public TrieNode(){
        children = new TrieNode[26];
        isEnd = false;
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

            if(node.children[curr - 'a'] == null){
                node.children[curr - 'a'] = new TrieNode();
            }

            node = node.children[curr-'a'];
        }
        node.isEnd = true;
    }

    public String findPrefix(String word){
        StringBuilder sb = new StringBuilder();
        TrieNode node = root;

        for(int i=0; i<word.length(); i++){
            char curr = word.charAt(i);
            if(node.isEnd){ return sb.toString();}
            if(node.children[curr - 'a'] == null){
                if(node.isEnd){ return sb.toString();}
                else return "";
            }

            node = node.children[curr - 'a'];
            sb.append(curr);
        }

        return sb.toString();
    }
}
class Solution {
    public String replaceWords(List<String> dictionary, String sentence) {
        Trie trie = new Trie();

        for(String i: dictionary){
            trie.insert(i);
        }

        String[] words = sentence.split(" ");

        StringBuilder sb = new StringBuilder();

        for(String word: words){
            String pre = trie.findPrefix(word);
            if(pre.equals("")){
                sb.append(word+" ");
            } else{
                sb.append(pre+" ");
            }
        }

        return sb.toString().trim();
    }
}
public class replace_words {
    
}
