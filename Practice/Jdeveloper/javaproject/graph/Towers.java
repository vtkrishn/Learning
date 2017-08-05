package javaproject.graph;

public class Towers {
    public Towers() {
        super();
    }
    
    public static void main(String[] args){
        int block = 3;
        int[][] tower = new int[3][3];
        int i=0;
        for(int j=0;j<3;j++){
            tower[0][j] = i--;
        }
        int k =2;
        while(tower[0].length > 0 && i <= tower.length){
            move(i,tower[0],tower[k],k);
            move(i+1,tower[k],tower[k-1],k-1);
            move(i+2,tower[k-1],tower[k],k);
        }
        
    }
        public static void move(int block, int[] source, int[] target,int k){
               if(block <= 0 || (block >= source.length && block >= target.length))
                return;
               source[block] = 0;
               target[k] = block;
               k++;
        }
        
}
