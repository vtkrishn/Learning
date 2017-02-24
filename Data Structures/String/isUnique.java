public class YourClassNameHere {
	    public static void main(String[] args) {
	      String str = "aaaaabbbbcc".toLowerCase();
	      isUnique(str);
	    }
	    
	                    static boolean isUnique(String str){
                  if(str != null && str.length() > 0){
                    
                    if(str.length() == 1)
                      return true;
                    
                    int[] arr = new int[255];
                    char[] ch = str.toCharArray();
                    
                    for(int i=0;i<ch.length;i++){
                      if(arr[ch[i]] == 0)
                        arr[ch[i]] = 1;
                      else
                        return false;
                    }
                    
                  }
                  return true;
                }
	}
