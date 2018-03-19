package com.vtkrishn.dfs;

public class Boggle {

	
	public static void main(String[] args) {
		
		char[][] arr = { {'P','E','W'},
		                 {'A','S','T'},
		                 {'E','B','I'},
		                 {'R','H','C'}
	};

		char[][] boolarray = { {'0','0','0'},
				{'0','0','0'},
			    {'0','0','0'},
			    {'0','0','0'}
		};
		
		for(int i=0;i<arr.length;i++){
		    for(int j = 0;j<arr[0].length;j++){
		        dfs(arr, boolarray, i, j, "PETIBRESA", "");
		    }
		  }
	}
	
	
	private static void dfs(char[][] arr , char[][] boolarray, int i, int j, String target, String temp) {
		if(i < 0 || j < 0 || i >= arr.length || j >= arr[0].length)
	        return;
	    
	     if(temp.equals(target)){
	        System.out.println(temp + " Found");
	        System.exit(0);;
	     }
	     
	     if(boolarray[i][j] == '0'){
	       boolarray[i][j] = '1';
	       temp = temp + arr[i][j];
	       dfs(arr, boolarray, i+1, j, target, temp);
	       dfs(arr, boolarray, i, j+1, target, temp);
	       dfs(arr, boolarray, i-1, j, target, temp);
	       dfs(arr, boolarray, i, j-1, target, temp);
	       dfs(arr, boolarray, i-1, j+1, target, temp);
	       dfs(arr, boolarray, i+1, j-1, target, temp);
	       dfs(arr, boolarray, i-1, j-1, target, temp);
	       dfs(arr, boolarray, i+1, j+1, target, temp);
	       temp = temp.substring(temp.length()-1);
	       boolarray[i][j] = '0';
	     }
	}
}

