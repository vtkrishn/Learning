package javaproject;

import java.util.ArrayList;
import java.util.List;

public class MaxSubList {
    public MaxSubList() {
        super();
    }

        public static void main(String[] args) {
            //test cases
            int[][] arr = {
            {1,2,3,4,8,9,10,3,4,5},
            {1,-4,-5,7,8,9},
            {-3,-2,-1,0,4,5,6,7,2,3,4,8,9,12,13,14,15,16},
            {5,6,1},
            {-4,-2},
            {0,1,6,7,8},
            };
            //loop through the test cases
            for(int i=0;i<arr.length;i++){
              //print the output lists
              System.out.println(getMaxSequence(arr[i]));
            }
        }

      public static List<Integer> getMaxSequence(int[] array){
            //define the return list
            List<Integer> list = new ArrayList<Integer>();
            //if the array is null return empty list
            if(array == null)
              return list;
            //required variables
            int currentMax = 0;
            int startIndex = 0;
            int endIndex = 0;
            int prevMax = 0;
            int prevStart =0;
            int prevEnd =0;
            //iterate the length of the array
            for(int i=1;i<array.length;i++){
                    //compare if the previous element is 1 value apart
                    if(Math.abs(array[i]-array[i-1]) == 1){
                            endIndex = i;
                            currentMax++;
                    }
                    else{
                        if(currentMax > prevMax){
                                prevMax = currentMax;
                                prevStart = startIndex;
                                prevEnd = endIndex;
                        }
                        startIndex = endIndex+1;
                        currentMax = 0;
                    }
            }
            //if previous max is greater then update the start and endIndex
            if(prevMax > currentMax){
                startIndex = prevStart;
                endIndex = prevEnd;
            }
            //run through the length of the start and end index and add the values to the list
            for(int i=startIndex;i<=endIndex;i++){
                    list.add(array[i]);
            }

            return list;
    }

}
