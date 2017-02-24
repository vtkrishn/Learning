public class YourClassNameHere {
	    public static void main(String[] args) {

	     compress("ab");
	    }
	    
	    public static void compress(String str){
	if(str == null || str.length() == 0)
		return;
	if(str.length()==1)
		System.out.println(str.charAt(0));

	for(int i=1;i<str.length();i++){
		if(str.charAt(i-1) != str.charAt(i)){
			System.out.println(str.charAt(i-1));
		}
	}
	System.out.println(str.charAt(str.length()-1));

}
	}
