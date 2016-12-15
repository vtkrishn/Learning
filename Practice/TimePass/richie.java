public class Solution {

    public static void main(String[] args) {
        int n = 6;
        int k = 3;
        String number = "932239";
        //minimumNumber(n,k,number);
        if(k > n || k > number.length()){
          System.out.println("-1");
         }
         else{
            min(n,k,number);
         }
    }

    public static void min(int n, int k, String number){
        char[] numArray = number.toCharArray();
        int j = numArray.length-1;
        int counter = 0;
        int m = k;
        int mid = numArray.length/2;
        //get the number of occurances
        for(int i=0;i<numArray.length/2;i++){
            //get the start and end character
            char start = numArray[i];
            char end = numArray[j];
            char midChar = numArray[mid];

            //if start is not equal
            if(start != end){
                    //change if its already not 9
                    //increase the counter accordingly
                    if(start != '9'){
                        numArray[i] = '9';
                        counter++;
                    }
                    if(end != '9'){
                        numArray[j] = '9';
                        counter++;
                    }
              }
            else{ // for case where start and end and equal
                // for mid element
                if(k == 1){
                    if(n %2 ==1 && midChar != '9'){
                        numArray[mid] = '9';
                        m--;
                    }
                }
                else{
                        if(m > 1){
                            if(start != '9'){
                                numArray[i] = '9';
                                m--;
                            }
                        }
                        if(m >= 1){
                            if(end != '9'){
                                numArray[j] = '9';
                                m--;
                            }
                        }

                }
            }
            if(counter > 0){
                m = k-counter;
            }

            if(n %2 ==1 && m > 0 && m == 1){
              if(midChar != '9'){
                numArray[mid] = '9';
                m--;
              }
            }
            j--;
        }


        if(counter > k || m != 0){
            System.out.println("-1");
        }
        else{
            System.out.println(numArray);
        }
    }


}
