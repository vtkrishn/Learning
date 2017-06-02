package javaproject;

public class Solution6 {
    public Solution6() {
        super();
    }

    public static void main(String[] args){
        int[] file = {
        7834567,
        9678541,
        1345234,
        2647896,
        3782345,
        4789340,
        8234156,
        5453435,
        6782345
        };

        //method2(file);
        method1(file);
    }

    private static void method2(int[] file) {
        char[] byteArray = new char[file.length];
        for(int i=0;i<byteArray.length;i++){
                byteArray[i] = '0';
        }

        for(int i=0;i<file.length;i++){
            byteArray[i] = '1';
        }
    }

    private static void method1(int[] file) {
        char[][] byteArray = new char[file.length][20];
        for(int i=0;i<byteArray.length;i++){
            for(int j=0;j<byteArray[0].length;j++){
                byteArray[i][j] = '0';
            }
        }
        for(int i=0;i<file.length;i++){
            int k = file[i];
            while(k > 0){
                int mod = k % 10;
                int rem = k / 10;
                byteArray[i][mod] = '1';
                k = rem;
            }
        }
            for(int i=0;i<byteArray.length;i++){
                for(int j=0;j<byteArray[0].length;j++){
                    if(byteArray[i][j] == '1')
                        System.out.print(j);
                }
                System.out.println("");
            }
    }
}
