import java.util.ArrayList;
import java.util.List;

class TrieSolution {
  public static void main(String[] args) {

    List<String> list = new ArrayList<String>();
    list.add("single");
    list.add("simple");
    list.add("simplify");

    List<String> result = compute(list);
    for (String prefix : result) {
      System.out.println(prefix);
    }
  }


  public static List<String> compute(List<String> list){
    if(list == null)
      return null;

    TrieNode trie = new TrieNode();
    List<String> result = new ArrayList<String>();

    for(int i=0;i<list.size();i++){
      String value = list.get(i);
      //insert into the trie
      insertToTrie(trie, value);

    }

    for(int i=0;i<list.size();i++){

      String value = list.get(i);
      result.add(processTrie(trie,value));
    }
    return result;
  }

  public static void insertToTrie(TrieNode root, String str) {
    TrieNode current = root;
    for(int i=0;i<str.length();i++){
      char ch = str.charAt(i);
      TrieNode child;
      if(current.children.containsKey(ch)){
        child = current.children.get(ch);
      } else {
        child = new TrieNode();
        current.children.put(ch, child);
      }
      child.count++;
      current = child;
    }
  }

  public static String processTrie(TrieNode root, String str){
    StringBuilder stb = new StringBuilder();
    TrieNode current = root;

    for(int i=0;i<str.length();i++){
      char ch = str.charAt(i);
      //TrieNode child;
      if(current.children.containsKey(ch)){
        stb.append(ch);
        TrieNode child = current.children.get(ch);
        if(child.count == 1) {
          return stb.toString();
        }
        current = child;
      }
    }
    return str;
  }
}
