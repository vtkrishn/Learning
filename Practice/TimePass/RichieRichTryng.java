public class YourClassNameHere {
	    public static void main(String[] args) {
	      String number = "092282";
	      minimumNumber(6,3,number);
	      }

public static void minimumNumber(int n, int k, String number){

  //number char array
	char[] numberArray = number.toCharArray();
	int j=numberArray.length-1;
	//counter for tracking the change
	int counter = 0;
	//iterate all character
	for(int i=0;i<numberArray.length;i++){
		//get first and last and compare
		char start = numberArray[i];
		char end = numberArray[j];

		//if you see mismatch then update it with the other value and incrememt a counter
		if(start != end){

		            numberArray[i] = '9';
                counter++;
                numberArray[j] = '9';
                counter++;
                j--;
                continue;

     	//see if its greater or not then replace the number accordingly
			if(Integer.valueOf(""+start) > Integer.valueOf(""+end))
			  numberArray[j] = start;
			else
			  numberArray[i] = end;
			//increase the change counter
			counter++;
		}

		j--;

		//if counter reaches k then check if this is palindrome
		if(counter == k && isPalindrome(numberArray)){
			System.out.println(numberArray);
			break;
		}
	}

	if(counter != k)
	  System.out.println(-1);
}

public static boolean isPalindrome(char[] numberArray){
	int j=numberArray.length-1;
	for(int i=0;i<numberArray.length/2;i++){
	  char start = numberArray[i];
		char end = numberArray[j];
	  if(start != end)
	    return false;
	  j--;
	}

	return true;
}
}
