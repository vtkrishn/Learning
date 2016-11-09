public class YourClassNameHere {
	    public static void main(String[] args) {
	     countRepeats("aaaaabbbccde");
	    }

	    public static void countRepeats(String s1){
	      if(s1 == null)
	        return;

	      StringBuilder str = new StringBuilder();
	      int count=1;
	      for(int i=1;i<s1.length();i++){
	        if(s1.charAt(i-1)!=s1.charAt(i)){
	           str.append(s1.charAt(i-1));
	           str.append(count);
	           count=1;
	        }
	        else{
	          count++;
	        }
	      }

	      if(s1.charAt(s1.length()-1) != s1.charAt(s1.length()-2)){
	        str.append(s1.charAt(s1.length()-1));
	        str.append(1);
	      }

	      System.out.println(str.toString());
	    }

--------------

int[] ch = new int[26];
      for(int i=0;i<s1.length();i++){
         int x = s1.charAt(i);
         ch[x-97]++;
      }

      for(int i=0;i<26;i++){
       if(ch[i]>0){
         int c = 97+i;
         str.append((char)c);
         str.append(ch[i]);
       }
      }
       


	}
