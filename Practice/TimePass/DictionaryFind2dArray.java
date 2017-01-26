package oracle.apps;

import java.util.*;
	public class YourClassNameHere {
	  private static Set<String> dict = new HashSet<String>();
    static int count =0;
      public static void main(String[] args) {
	    char[][] array =
				{
				{'a', 'f', 'g', 'm'},
				{'t', 'r', 'o', 'a'},
				{'a', 'e', 'e', 'r'},
				{'r', 'l', 's', 'k'},
				};

			dict.add("after");
			dict.add("goes");
			dict.add("mark");
			dict.add("reel");
			dict.add("fork");
			dict.add("more");
			dict.add("fat");
			dict.add("freek");


      dfs(array);

      System.out.println(count);

		}

      private static void dfs(char[][] array){
        boolean[][] visited = new boolean[4][4];
        String str = "";

              for(int i=0;i<array.length;i++){
                for(int j=0;j<array[0].length;j++){
                  dfs(array,visited,i,j,str);
                }
              }

      }

		private static void dfs(char[][] array,boolean[][] visited,int i, int j,String str){
		  visited[i][j]=true;
		  str = str + array[i][j];
//		  if(dict.contains(str)){
//        System.out.println(str);
//      }2
      if(str.length()>4 && str.length()<16)
        count++;

      for(int row=i-1;row<=i+1 && row<array.length;row++){
        for(int col=j-1;col<=j+1 && col<array[0].length;col++){
          if(row>=0 && col>=0 && !visited[row][col])
            dfs(array,visited,row,col,str);
        }
      }

      str.substring(0, str.length()-1);
      visited[i][j] = false;
		}
	}
