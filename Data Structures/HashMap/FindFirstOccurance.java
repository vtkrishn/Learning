public class YourClassNameHere {
	    public static void main(String[] args) {
	        String st1 = "a666ysh";
	        String st2 = "12345678";
	        
	        if(st1 != null && st2!=null){
	          
	          Character[] ch1 = convertStringToCharacterArray(st1);
	          Character[] ch2 = convertStringToCharacterArray(st2);
	          
	          java.util.Map<Character,Integer> map = new java.util.HashMap<Character,Integer>();
	          
	          for(int i=0;i<ch1.length;i++){
	           if(!map.containsKey(ch1[i])){
	            map.put(ch1[i],i); 
	            }
	          }
	          
	          for(int i=0;i<ch2.length;i++){
	           if(map.containsKey(ch2[i])){
	              System.out.println(map.get(ch2[i])); 
	              break;
	           }
	          }
	        }
	    }
	    
	    public static Character[] convertStringToCharacterArray(String str) {
    if (str == null || str.isEmpty()) {
        return null;
    }
    char[] c = str.toCharArray();
    final int len = c.length;
    int counter = 0;
    final Character[] result = new Character[len];
    while (len > counter) {
        for (char ch : c) {
            result[counter++] = ch;
        }
    }
    return result;
}
	}
