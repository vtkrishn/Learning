import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class Solution{
	public static void main(String[] args){
		System.out.println(palindromePairs(new String[]{"abcd","dcba","lls","s","sssll"}));
	}

	// From naive O(nnk) to O(nkk) time.
    // public static List<List<Integer>> palindromePairs(String[] words) {
    //     Map<String, Integer> map = new HashMap<>();
    //     for (int i = 0; i < words.length; i++) map.put(words[i], i);

    //     List<List<Integer>> ret = new ArrayList<>();
    //     for (int i = 0; i < words.length; i++) {
    //         for (int j = 0; j <= words[i].length(); j++) { // Note j=[0..len]: s1="",s2=word -> s1=word,s2=""
    //             String s1 = words[i].substring(0, j), s2 = words[i].substring(j);
    //             if (isPalindrome(s1)) { // word2 + s1 + s2 is palindrome
    //                 String t = new StringBuilder(s2).reverse().toString();
    //                 if (map.getOrDefault(t, i) != i) ret.add(Arrays.asList(map.get(t), i));
    //             }
    //             if (isPalindrome(s2) && !s2.isEmpty()) { // s1 + s2 + word2 is palindrome (avoid duplicate)
    //                 String t = new StringBuilder(s1).reverse().toString();
    //                 if (map.getOrDefault(t, i) != i) ret.add(Arrays.asList(i, map.get(t)));
    //             }
    //         }
    //     }
    //     return ret;
    // }

	public static List<List<Integer>> palindromePairs(String[] words){

		Map<String,Integer> map = new HashMap<String,Integer>();
		List<List<Integer>> list = new ArrayList<List<Integer>>();

		//add to the map
		for(int i=0;i<words.length;i++){
			map.put(words[i],i);
		}

		//see if the substring word is also a palindrome
		for(int i=0;i<words.length;i++){
		    for(int j=0;j<=words[i].length();j++){ // j<= is important since we have to evaluate the complete string
		        String s1 = words[i].substring(0,j);
		        String s2 = words[i].substring(j);
		        if(isPalindrome(s1)){
		            String s2Reverse = getReverse(s2);
		            if(map.getOrDefault(s2Reverse,i) != i)
     				    list.add(Arrays.asList(map.get(s2Reverse),i));
		        }

		        if(isPalindrome(s2) && !s2.isEmpty()){
		            String s1Reverse = getReverse(s1);
		            if(map.getOrDefault(s1Reverse,i) != i)
     				    list.add(Arrays.asList(i,map.get(s1Reverse)));
		        }
		    }

		}




// 			//loop and check if the map contains the words
// 			StringBuilder strB = new StringBuilder(words[i]);
// 			String str = strB.toString();
// 			String strReverse = strB.reverse().toString();
// 			if(!(str.equals(strReverse)) && map.containsKey(strReverse)){
// 				int m = map.get(str);
// 				int n = map.get(strReverse);
// 				addToList(list,m,n);
// 			}

// 			for(int j=0;j<words[i].length();j++){
// 				String s1 = words[i]; //lls  sssll
// 				strB = new StringBuilder(s1);
// 				String s1Reverse = strB.reverse().toString(); //sll   llsss

//     				String sub = s1Reverse.substring(0,j); //s
//     				if(map.containsKey(sub) && isPalindrome(sub + s1)){ //slls
//     					int m = map.get(sub);
//     					int n = map.get(s1);
//     					addToList(list,m,n);
// 			        }
// 		       }
// 		}

 		return list;
 	}

    private static String getReverse(String str){
    	StringBuilder strB = new StringBuilder(str);
    	return strB.reverse().toString();
  }

	private static void addToList(List<List<Integer>> m,int a,int b){
        List<Integer> x = new ArrayList<Integer>();
             x.add(a);
             x.add(b);
             m.add(x);
    }

	private static boolean isPalindrome(String str){
		int i=0;
		int j = str.length()-1;
		if(str.isEmpty()) return true;
		while(i<j){
			if(str.charAt(i) != str.charAt(j))
				return false;
			i++;
			j--;
		}
		return true;
	}
}
