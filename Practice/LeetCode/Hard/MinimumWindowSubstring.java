class Solution {
    public String minWindow(String s, String t) {
        //1. Use two pointers: start and end to represent a window.
    //2. Move end to find a valid window.
    //3. When a valid window is found, move start to find a smaller window.

    String result = "";
    int s_length = s.length();
    int a_length = t.length();

    //length should not be less than the minimum
    if(s_length < a_length)
      return result;

    //storee the values in the array letters
    int[] letters = new int[128];
    for(char c : t.toCharArray())
      letters[c]++;

    int count = a_length;
    int begin = 0;
    int end = 0;
    int minStart = 0;
    int minEnd = Integer.MAX_VALUE;

    //Move end to find a valid window.
    while(end<s_length){
      // If char in str exists in arr, decrease counter
      if(letters[s.charAt(end)]  > 0)
        count--;
      //if char does not exist then letter will be negative
      letters[s.charAt(end)]--;
      end++;

      // When we found a valid window, move begin to find smaller window
      while(count == 0){
        if(end - begin < minEnd){
          minStart = begin;
          minEnd = end - begin;
        }
        //increase the letter count
        letters[s.charAt(begin)]++;
        // When char exists in t, increase counter.
        if(letters[s.charAt(begin)]  > 0)
          count++;
        begin++;
    }
  }
  return minEnd != Integer.MAX_VALUE ? s.substring(minStart, minStart + minEnd) : "";
    }
}
