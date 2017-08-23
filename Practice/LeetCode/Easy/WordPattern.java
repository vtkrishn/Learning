class Solution {
    public boolean wordPattern(String pattern, String str) {
        Map<Character,String> map = new HashMap<Character,String>();
        String[] splits = str.split(" ");
        if(splits.length != pattern.length())
            return false;
        for(int i=0;i<pattern.length();i++){
            char ch = pattern.charAt(i);
            if(map.containsKey(ch)){
                if(!map.get(ch).equals(splits[i]))
                    return false;
            }
            else{
                if(map.containsValue(splits[i]))
                    return false;
                map.put(ch,splits[i]);
            }
        }
        return true;
    }
}
