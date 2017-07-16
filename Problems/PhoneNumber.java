public class Solution {
    private static final String[] KEYS = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };

    public static List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<String>();
        if(digits.length() == 0)
            return result;
        letterCombinations("",digits,result, 0);
        return result;
    }

    public static void letterCombinations(String prefix,String digits,List<String> result,int index) {
        if(index >= digits.length()){
            result.add(prefix);
            return;
        }
        String mapper = KEYS[digits.charAt(index)-'0'];
        for(int k=0;k<mapper.length();k++){
              letterCombinations(prefix + mapper.charAt(k),digits,result,index+1);
        }
    }

}
