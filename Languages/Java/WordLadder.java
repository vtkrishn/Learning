public static void main(String[] args){
    Set<String> dict = new HashSet();
      dict.add("hot");
      dict.add("dot");
      dict.add("dog");
      dict.add("lot");
      dict.add("log");
      buildLadder("hit","cog",dict);
  }

public static int buildLadder(String start, String end,Set<String> dict){
    int len = start.length();
    LinkedList<String> queue = new LinkedList<String>();
    queue.add(start);
    dict.add(end);
    while(!queue.isEmpty()){
        start = queue.removeFirst();

        if(start.equals(end))
            return 0;
        for(int i=0;i<len;i++){
            char[] strArray = start.toCharArray();
            for(char j = 'a';j<='z';j++){
                char t = strArray[i];
                strArray[i] = j;
                String conv = new String(strArray);
                if(dict.contains(conv)){
                    System.out.println(conv);
                    queue.addLast(conv);
                    dict.remove(conv);
                }

                strArray[i] = t;
            }
        }

    }
    return 0;
}
