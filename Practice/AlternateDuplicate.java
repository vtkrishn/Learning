public class YourClassNameHere {
    public static void main(String[] args) {
      boolean[] letter = new boolean[26];
      StringBuilder stb = new StringBuilder();
      String str = "you got beautiful eye";
      for(int i=0;i<str.length();i++){
         int ch = str.charAt(i)-97;
         if(ch >= 0 && ch < 26){
          letter[ch] = !letter[ch];
      	if(letter[ch])
      		stb.append(str.charAt(i));
         }
      }
      System.out.println(stb.toString());
    }
}
