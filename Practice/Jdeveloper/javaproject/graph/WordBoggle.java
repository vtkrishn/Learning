package javaproject.graph;

public class WordBoggle {
    public WordBoggle() {
        super();
    }
    
    public static void main(String[] args){
            char[][] array = {
                                                    {'e','a','e'},
                                                    {'e','n','l'},
                                                    {'t','1','c'},
                                            };
            boolean[][] visited = new boolean[3][3];
            for(int i=0;i<array.length;i++){
                    for(int j=0;j<array[0].length;j++){
                            dfs(array,visited,i,j,"");
                    }       
            }       
    }

    public static void dfs(char[][] array, boolean[][] visited, int row,int col,String str){
            visited[row][col] = true;
            str = str + array[row][col];
            if(str.equals("clean") || str.equals("lean") || str.equals("ten"))
            System.out.println(str);
            for(int x=row-1;x<=x+1 && x<array.length;x++){
                    for(int y=col-1;y<=y+1 && y<array[0].length;y++){
                            if(x>=0 && y>=0 && !visited[x][y]){
                                    dfs(array,visited,x,y,str);
                            }
                    }
            }
            str.substring(0, str.length()-1);
            visited[row][col] = false;
    }

//    public static void dfs(char[][] array, boolean[][] visited, int row,int col,String str){
//            visited[row][col] = true;
//            str = str + array[row][col];
//            System.out.println(str);
//            for(int x=row-1;x<=row+1 && x<array.length;x++){
//                    for(int y=col-1;y<=col+1 && y<array[0].length;y++){
//                            if(x>=0 && y>=0 && !visited[x][y]){
//                               dfs(array,visited,x,y,str);
//                            }
//                    }
//            }
//            str = str.substring(0, str.length()-1);
//            visited[row][col] = false;
//    }

}
