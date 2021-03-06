public static String rev(String s){
     if(s.length() == 0)
        return "";

     return s.charAt(s.length()-1) + rev(s.substring(0,s.length()-1));
    }


    public static String rev(String s) {

        //check if the string is not null
    //character by character 1 and last one upto middle
    //output
    if(s == null || s.length() == 0)
        return "";

    if(s.length() == 1)
       return s;

    char[] ch = s.toCharArray();
    int length = s.length();
    int i=0;
    int j = length-1;
    while(i<j)
       //swap i and j character
       char temp =  ch[i];
       ch[i] = ch[j];
       ch[j] = temp;
       i++;
       j--;
    }
    return new String(ch);
}
-------------------
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
