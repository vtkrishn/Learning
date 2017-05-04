import java.util.*;
public class YourClassNameHere {

static class TrieNode{
  Map<Character,TrieNode> children = new HashMap<>();
}

    public static void main(String[] args) {
      List<String> list = new ArrayList<String>();
      list.add("Vinod");
      list.add("Vinodini");
      list.add("Varsha");
      list.add("Alex");
      TrieNode t = new TrieNode();
      for(int i=0;i<list.size();i++){
        String str = list.get(i);
        insertIntoTrie(t,str);
      }
      search(t,"Vinodx");
    }

    public static boolean search(TrieNode root, String str){
        TrieNode current = root;
        TrieNode child;
        for(int i=0;i<str.length();i++){
            char ch = str.charAt(i);
            if(current.children.containsKey(ch)){
              child = current.children.get(ch);
            }
            else{
              return false;
            }
            current = child;
        }
        return true;
    }

    public static void insertIntoTrie(TrieNode root, String str){
        TrieNode current = root;
        TrieNode child;
        for(int i=0;i<str.length();i++){
            char ch = str.charAt(i);
            if(current.children.containsKey(ch)){
              child = current.children.get(ch);
            }
            else{
              child = new TrieNode();
              current.children.put(ch,child);
            }
            current = child;
        }
    }
}
