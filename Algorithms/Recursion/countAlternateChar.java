public int countPairs(String str) {
  if(str == null || str.equals("") || str.length() <= 2)
    return 0;
  if(str.charAt(0) == str.charAt(2))
    return 1 + countPairs(str.substring(1));
  return countPairs(str.substring(1));
}
