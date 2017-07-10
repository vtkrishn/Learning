public class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> resultList = new ArrayList<List<String>>();
        addValidLadder(resultList,wordList,beginWord,endWord);
        return resultList;
    }

    public static void addValidLadder(List<List<String>> resultList, List<String> wordList, String beginWord,String endWord){
        List<String> newList = new ArrayList<String>();
        newList.add(beginWord);
        for(int i=0;i<3;i++)
            buildLadder(newList,wordList,resultList,beginWord,endWord,i);
    }

    public static void buildLadder(List<String> newList,List<String> wordList,List<List<String>> resultList,String beginWord,String endWord,int index){
        if(index >= 3)
            return;

        char[] charArray = beginWord.toCharArray();
        char temp = charArray[index];
        for(char j='a';j<='z';j++){
            charArray[index] = j;
            String tempString = new String(charArray);
            if(wordList.contains(tempString)){
                if(!newList.contains(tempString))
                    newList.add(tempString);
            }
        }
        charArray[index] = temp;

        if(newList.contains(endWord)){
            resultList.add(newList);
            return;
        }
        else
           buildLadder(newList,wordList,resultList,newList.get(newList.size()-1),endWord,index+1);
    }
}
