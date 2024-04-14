package HomeWork.Tries_2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Collections;
class TrieNode {
		
    TrieNode[] children;
    boolean isEnd;
    HashSet<String> allStrings;
    public TrieNode() {
        isEnd = false;
        children = new TrieNode[26];
        allStrings = new HashSet<>();
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
    node.isEnd = true;
}

public ArrayList<String> show(String s){
    TrieNode node = root;
    
    for(int i=0; i<s.length(); i++){
        char curr = s.charAt(i);
        
        if(node.children[curr-'a'] == null){
            return new ArrayList<>();
        }
        node = node.children[curr-'a'];
    }
    ArrayList<String> res = new ArrayList<>();
    
    for(String st : node.allStrings){
        res.add(st);
    }
    return res;
    
}
}

class Solution{

static ArrayList<ArrayList<String>> displayContacts(int n, String contact[], String s)
{
    Trie trie = new Trie();
    for(String cnt : contact){
        trie.insert(cnt);
    }
    
    ArrayList<ArrayList<String>> res = new ArrayList<>();
    for(int i=0; i<s.length(); i++){
        ArrayList<String> list = trie.show(s.substring(0, i+1));
        if(list.size() == 0){
            list.add("0");
        }
        Collections.sort(list);
        res.add(list);
    }
    
    return res;
}
}

public class phone_directory {
    
}
