import java.util.*;
public class ClassNameHere {
   public static void main(String[] args) {
      String arr = "bbbb";
      int start=0;
      int end=0;
      int max = 0;
      Map<Character,Integer> set = new HashMap<Character,Integer>();
      while(end < arr.length()){
         char ch = arr.charAt(end);
         if(!set.containsKey(ch)){
          set.put(ch,end);
         }
         else{
          max = Math.max(max,end-start);
          start = set.get(ch)+1;
          end = start-1;
          set.clear();
         }
         end++;
      }
      max = Math.max(max,end-start);
   }
}
