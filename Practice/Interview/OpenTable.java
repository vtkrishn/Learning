// string reversal
public static String rev(String s) {

        //check if the string is not null
    //character by character 1 and last one upto middle
    //output
    if(s == null || s.length() == 0)
        return "";

    if(s.length() == 1)
       return s;

    char[] ch = s.toCharArray();
    int length = s.length();
    int i=0;
    int j = length-1;
    while(i<j)
       //swap i and j character
       char temp =  ch[i];
       ch[i] = ch[j];
       ch[j] = temp;
       i++;
       j--;
    }
    return new String(ch);
}

// string reversal, recursive
public static String revRecrursive(String s) {

if(s == null || s.length() == 0)
        return "";
return recursiveUtil(s,0,""); //string 0 ""
}

public static String recursiveUtil(String s, int index,String result){
 if(s == null || s.length() == 0)
        return "";
 recursiveUtil(s,index+1,result); string , 1, ""
 result = result + s.charAt(index);
 return result;
}



/*

Moving/sliding average: given a window of size k, find the average for each point in a stream of data. The stream of data can be considered an input array of size n where n.length >= k
window  (k) = 3
stream (n) = [3, 3, 3, 2, 4, 1, 3, 4]
output = [3.00, 2.67, 3.00, 2.33, 2.66, 2.66]

*/


public class YourClassNameHere {
    public static void main(String[] args) {
        int[] arr = {3, 3, 3, 2, 4, 1, 3, 4};
        movingAvg(arr,3);
    }

    public static double[] movingAvg(int[] n, int k) {
    java.util.List<Double> result = new java.util.ArrayList<Double>();
    int runningSum = 0;
    int j=1;
    for(int i=0;i<n.length;i++){
        //first 3 element
        if(i == k){
           result.add((double)runningSum/k);
           runningSum = runningSum - n[0];
         }
        if(i<k){
            runningSum = runningSum + n[i];
         }

        //remaining element greater than 3
         if(i>k){
            runningSum = runningSum + n[i-1];
            result.add((double)runningSum/k);
            runningSum = runningSum - n[j];
            j++;
         }

    }
    double[] list = new double[result.size()];
    for(int i=0;i<result.size();i++){
     list[i] = result.get(i);
    }
    return list;
}
}

i   runningSum  n[i]
0    3            3
1    3+3=6        3
2    6+3=9        3
3    9/3=3.00     2 - 9-3=6
