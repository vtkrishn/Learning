package javaproject;

public class Boggle{
	public Boggle(){
        }
	public static void main(String[] args){
	    char[][] matrix = {
	        {'a','n','s'},
	        {'g','e','y'},
	        {'l','r','t'},
	        };
                String str = "";
                boolean[][] visited = new boolean[3][3];
                for(int i=0;i<matrix.length;i++){
			for(int j=0;j<matrix[0].length;j++){
				findWay(matrix,i,j,str,visited);
			}
		}
	}
	
	private static void findWay(char[][] matrix, int x,int y,String str, boolean[][] visited){
            visited[x][y] = true;
            str = str + matrix[x][y];
               // if(str.equals("lean"))
                    System.out.println(str);
            for(int i=x-1;i<=x+1 && i<matrix.length;i++){
                for(int j=y-1;j<=y+1 && j<matrix[0].length;j++){
                    if(i>=0 && j>=0 && !visited[i][j])
                        findWay(matrix, i, j, str, visited);
                }                
            }
            
            str = str.substring(0,str.length()-1);
	    visited[x][y] = false;
	}
}
