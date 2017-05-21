// Given a string, return the count of the number of times that a substring length 2 appears in the string and also as the last 2 chars of the string, so "hixxxhi" yields 1 (we won't count the end substring).
//
// last2("hixxhi") → 1
// last2("xaxxaxaxx") → 1
// last2("axxxaaxx") → 2

public int last2(String str) {
  int len = str.length();
  return (str == null || str.equals("") || str.length() < 2) ? 0 :   last(str.substring(len-2),str);
}

public int last(String sub, String str){
  if(str.length() < sub.length())
    return -1;
  String sub2 = str.substring(0,2);
  if(sub.equals(sub2))
    return 1 + last(sub, str.substring(1));
  return last(sub, str.substring(1));
}
