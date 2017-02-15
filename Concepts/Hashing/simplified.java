package javaproject.testing;

public class Hash {
    public static void main(String[] args){
        int[] arr = {1,2,3,4,5,6,7,8,9,10};
        int[] slots = new int[5];

        for(int i=0;i<arr.length;i++){
            if(i < slots.length && slots[i] == 0)
                slots[getIndex(i,slots.length)] = arr[i];
            else{
                //create temp
                int[] temp = new int[slots.length * 2];
                //copy slots to temp
                for(int j=0;j<slots.length;j++){
                    temp[j] = slots[j];
                }
                slots = temp;
            }
        }
    }
        private static int getIndex(int i,int length){
            return i % length;
        }

}
