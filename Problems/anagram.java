import java.util.*;
public class YourClassNameHere {
    static List<String> result = new ArrayList<String>();
    public static void main(String[] args) {
      String haystack = "aaabbbaabaaaba";
      String needle = "ab";
      getAnagramIndices(haystack, needle);
    }

    public static List<Integer> getAnagramIndices(String haystack, String needle){
        //find all occurances of needle in haystack
        getAnagrams(needle);
        for(int i=0;i<result.size();i++){
          System.out.println(result.get(i));
        }
        return null;
    }

    public static void getAnagrams(String needle){
        getAnagrams(needle,"");
        //getAnagrams(reverse(needle),"");
    }

    public static String reverse(String str){
        if(str.equals(""))
          return str;
        return reverse(str.substring(1)) + str.charAt(0);
    }

    public static void getAnagrams(String needle, String append){
     if(needle.equals("")){
          if(!result.contains(append))
            result.add(append);
          return;
     }
     else{
        getAnagrams(needle.substring(1),needle.charAt(0) + append);
        getAnagrams(needle.substring(1),append + needle.charAt(0));
     }

}
}
