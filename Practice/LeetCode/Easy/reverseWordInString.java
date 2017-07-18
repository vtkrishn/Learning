public class Solution {
    public String reverseWords(String s) {
        StringBuilder result = new StringBuilder();
	    StringBuilder stb = new StringBuilder();
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(ch != ' '){
                stb.append(ch);
            }
            else{
                result.append(reverseWord(stb.toString()));
                result.append(ch);
                stb = new StringBuilder();
            }
        }
        result.append(reverseWord(stb.toString()));
        return result.toString();
    }

    public String reverseWord(String word){
	if(word == null || word.equals(""))
		return "";
	return word.charAt(word.length()-1)+ reverseWord(word.substring(0,word.length()-1));
    }
}
