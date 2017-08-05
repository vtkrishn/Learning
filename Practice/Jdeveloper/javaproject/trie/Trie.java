package javaproject.trie;

public class Trie{
  TrieNode root;

  public Trie(){
    root = new TrieNode();
  }
/* TrieNode
*/
class TrieNode{
  TrieNode[] children;
  boolean isLeaf;

  public TrieNode(){
    this.isLeaf = false;
    children = new TrieNode[26];
  }
}

    public static void main(String[] args){
        Trie t = new Trie();
        t.insert("vinod");
        t.insert("vis");
    }
    
  public void insert(String strValue){
      if(strValue == null || strValue.length() == 0)
        return;

      int length = strValue.length();
      TrieNode node = root;
      for(int i=0;i<length;i++){
        int index = (strValue.charAt(i) - 'a');
        if(node.children[index] == null)
           node.children[index] = new TrieNode();
        node = node.children[index];   
      }

      node.isLeaf = true;
  }

  public boolean search(String strValue){
      if(strValue == null || strValue.length() == 0)
        return false;
      int length = strValue.length();
      TrieNode node = root;
      for(int i=0;i<length;i++){
          int index = (strValue.charAt(i) - 'a');
          if(node.children[index] == null)
              return false;
          node = node.children[index];
      }
    
    return node.isLeaf;
  }
   
  public boolean startWith(String strValue){
      if(strValue == null || strValue.length() == 0)
        return false;
      int length = strValue.length();
      TrieNode node = root;
      for(int i=0;i<length;i++){
          int index = (strValue.charAt(i) - 'a');
          if(node.children[index] == null)
              return false;
          node = node.children[index];
      }
      return true;
  }
    
}

