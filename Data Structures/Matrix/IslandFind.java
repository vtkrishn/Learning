package javaproject;

public class IslandFind {
    public IslandFind() {
        super();
    }

    public static void main(String[] args){
        int[][] array = {
              {'O', 'O', 'O'},
              {'X', 'X', 'O'},
              {'X', 'X', 'O'},
              {'O', 'O', 'X'},
              {'O', 'O', 'X'},
              {'X', 'X', 'O'}
             };

        int count = 0;
        for(int i=0;i<array.length;i++){
            for(int j=0;j<array[0].length;j++){
                if(array[i][j] == 'X'){
                    if(i == 0 || array[i-1][j] == 'O' && (j == 0 || array[i][j-1] == 'O'))
                        count++;
                }
            }
        }
        System.out.println(count);
    }
}
