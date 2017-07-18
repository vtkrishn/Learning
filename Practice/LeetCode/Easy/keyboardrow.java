public class Solution {
    public String[] findWords(String[] words) {
        List<String> result = new ArrayList<String>();
        Set<String> set = new HashSet<String>();
        set.add("qwertyuiop");
        set.add("asdfghjkl");
        set.add("zxcvbnm");

        //Evaluate all the Strings
        for(int i=0;i<words.length;i++){
            String str = words[i];
            if(set.contains(str) || findWord(str,set))
                result.add(str);
        }

        //convert list to String array
        String[] sList = new String[result.size()];
        for(int i=0;i<sList.length;i++){
            sList[i] = result.get(i);
        }

        return sList;
    }

    public boolean findWord(String str,Set<String> set){
        boolean flag = false;
        Iterator<String> it = set.iterator();
            while(it.hasNext()){
                String st = it.next();
                for(int j=0;j<str.length();j++){
                    if(!st.contains(""+str.toLowerCase().charAt(j))){
                        flag=false;
                        break;
                    }
                    else{
                        flag=true;
                    }
                }
                if(flag)
                  break;
            }
        return flag;
    }
}
