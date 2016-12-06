public class YourClassNameHere {
	    public static void main(String[] args) {
	        findCost("abcd");
	        findCost("abab");
	        findCost("abcdab");
	        findCost("abcdba");
	        findCost("abacab");
	    }

	    private static void findCost(String str){
	int cost = 0;
	boolean[] characterCount = new boolean[26]; // only lower case
	StringBuilder stb = new StringBuilder();
	for(int i=0;i<str.length();i++){
		int ch = str.charAt(i);
		if(!characterCount[Math.abs(97-ch)]){
			cost++;
			characterCount[Math.abs(97-ch)] = true;
		}
			stb.append((char)ch);
	}

	System.out.println(cost + "/" + stb.toString());
}
}
	
