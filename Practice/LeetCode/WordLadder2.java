public class YourClassNameHere {
	    public static void main(String[] args) {
	      java.util.Set<String> wordList = new java.util.HashSet<String>();
        wordList.add("hot");
        wordList.add("dot");
        wordList.add("dog");
        wordList.add("lot");
        wordList.add("log");
	      findLadders("hit","cog",wordList);
	    }

    public static java.util.List<java.util.List<String>> findLadders(String beginWord, String endWord, java.util.Set<String> wordList) {
        if(beginWord == null && endWord == null)
            return null;

        java.util.List<java.util.List<String>>  result = new java.util.ArrayList<java.util.List<String>>();
        String temp = "";
        int i = 0;
        java.util.List<String> list = new java.util.ArrayList<String>();
        list.add(beginWord);

        java.util.Map<Character,java.util.Stack> beginMap = new java.util.HashMap<Character,java.util.Stack>();
        java.util.Map<Character,java.util.Stack> endMap = new java.util.HashMap<Character,java.util.Stack>();

        for (String s : wordList) {
          Character ch = s.charAt(0);
          if(beginMap.containsKey(ch)){
            java.util.Stack stk = beginMap.get(ch);
            stk.push(s);
          }
          else{
            java.util.Stack stk = new java.util.Stack();
            stk.push(s);
            beginMap.put(ch,stk);
          }
        }

        for (String s : wordList) {
          int n = s.length()-1;
          Character ch = s.charAt(n);
          if(endMap.containsKey(ch)){
            java.util.Stack stk = endMap.get(ch);
            stk.push(s);
          }
          else{
            java.util.Stack stk = new java.util.Stack();
            stk.push(s);
            endMap.put(ch,stk);
          }
        }


         while(temp != endWord){
          Character ch = beginWord.charAt(i);
            if(beginMap.containsKey(ch)){
              java.util.Stack stk = endMap.get(ch);
              String temp = (String)stk.pop();
              list.add(temp);
              ch = beginWord.charAt(beginWord.length()-1);
              if(endMap.containsKey(ch)){
                java.util.Stack stk = endMap.get(ch);
              }
            }
         }

        list.add(endWord);
        result.add(list);

        return result;
    }


    private static java.util.List<String> getWordMatches(java.util.Set<String> wordList,char ch,int index){
        java.util.List<String> ll = new java.util.ArrayList<String>();
        for (String s : wordList) {
            char c = s.charAt(index);
            if(c == ch)
                ll.add(s);
        }
        return ll;
}
}
