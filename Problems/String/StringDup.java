https://community.topcoder.com/tc?module=ProblemDetail&rd=2001&pm=40

public class YourClassNameHere {
	    public static void main(String[] args) {
	      String str = "aaaaabb";
	      System.out.println(getMax(str));
	    }

	    static char getMax(String input){
	      if(input == null)
	        return '#';

	      char[] stat = new char[128];
	      for(int i = 0;i<input.length();i++){
	        stat[input.charAt(i)]++;
	      }

	      int max = 0;
	      for(int i = 0;i<128;i++){
	        if(max < stat[i])
	        max = stat[i];
	      }

	      for (int i = 0; i < input.length(); i++) {
        if (stat[s.charAt(i)] == max)
          return s.charAt(i);
        }

	      return ' ';

	     // char[] c = input.toCharArray();
	     // int max = 0;
	     // char cx= ' ';
	     // int[] ch = new int[128];
	     // for(int i=0;i<c.length;i++){
	     //      if(ch[c[i]] != 0){
	     //       ch[c[i]]++;
	     //       if(max < ch[c[i]]){
	     //         max = ch[c[i]];
	     //         cx = c[i];
	     //       }
	     //      }
	     //      else
	     //       ch[c[i]] = 1;
	     // }

	     // return cx;
	    }
}
