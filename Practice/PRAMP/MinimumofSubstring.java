public class Pramp {
   public static void main(String[] args) {
      char[] arr =  {'a','b','c'};
      subStr(arr,"dbcpbaabc");
   }

   public static String subStr(char[] chars, String s) {
      //sliding window
      int[] map = new int[256];
      for(char c : chars) map[c]++;
      int start = 0, end = 0, minLen = Integer.MAX_VALUE;
      int count = chars.length, minStart = 0;
      //count = 3;

      while(end < s.length()) {//start -> end
         if(map[s.charAt(end)] > 0)
            count--;

         map[s.charAt(end)]--;
         while(count == 0) {
            if(end - start + 1 < minLen) {
               minLen = end - start + 1;
               minStart = start;
            }
            map[s.charAt(start)]++;
            if(map[s.charAt(start)] > 0) count++;
            start++;
         }
         end++;
      }
      if(minStart + minLen > s.length()) return "";

      return s.substring(minStart, minStart+minLen);
   }

}
