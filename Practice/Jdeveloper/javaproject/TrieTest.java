package javaproject;

public class TrieTest {
    public TrieTest() {
        super();
    }
    
    static class Trie{
        Node[] node = new Node[26];
            Trie(){
                for(int i=0;i<26;i++){
                    node[i] = new Node((char)(97+i));
                }
            }
    
            class Node{
                char value;
                Node(char c){
                    this.value = c;
                }
            }
    }
    
    public static void main(String[] args){
        String[] arr = {"hat","has","his","age","aging","agenda"};
        Trie[] t = new Trie[3];
        for(int i=0;i<arr[0].length();i++){
             t[i] = new Trie();
        }
    }
}
