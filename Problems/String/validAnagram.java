public class YourClassNameHere {
    public static void main(String[] args) {
       //isValidAnagram("simon","nikos");
       reverse("vinod");
    }
  

  public static boolean isValidAnagram(String s, String t){
	int k = 0;
	for(int i=0;i<s.length();i++){
		for(int j=0;j<t.length();j++){
			if(s.charAt(i) == t.charAt(j)){
				k++;
				break;
			}
		}
	}
	return k==s.length();
}
}
