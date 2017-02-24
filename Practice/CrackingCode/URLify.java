public class YourClassNameHere {
	    public static void main(String[] args) {
	      String str = "My John Smith";
	      System.out.println(urlify(str));
	    }
	    
	   // static String urlify(String str){
	   //     StringBuilder sb = new StringBuilder();
	   //     for(int i=0;i<str.length();i++){
	   //       if(str.charAt(i) == ' '){
	   //         sb.append("%20");
	   //       }
	   //       else{
	   //         sb.append(str.charAt(i));
	   //       }
	   //     }
	   //   return sb.toString();
	   // }
	   
	   static String urlify(String str){
	        int count = 0;
	        for(int i=0;i<str.length();i++){
	          if(str.charAt(i) == ' '){
	            count++;
	          }
	        }
	        
	        char[] ch = new char[str.length() + (count * 2)];
	        int j=0;
	        for(int i=0;i<str.length();i++){
	          char c = str.charAt(i);
	          if(c == ' '){
	            ch[j++]='%';
	            ch[j++]='2';
	            ch[j++]='0';
	          }
	          else{
	            ch[j++]=c;
	          }
	        }
	      return new String(ch);
	    }
	}
